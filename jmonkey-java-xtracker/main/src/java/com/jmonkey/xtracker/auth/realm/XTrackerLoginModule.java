package com.jmonkey.xtracker.auth.realm;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.PersonRole;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

/**
 * ref: http://www.hibernate.org/139.html
 * 
 * @author brill
 */
public class XTrackerLoginModule implements LoginModule {
	private Subject			subject				= null;
	private CallbackHandler	callbackHandler		= null;
	private Map<String, ?>	sharedState			= null;
	private Map<String, ?>	options				= null;
	private boolean			authenticated		= false;
	private Person			authenticatedPerson	= null;

	public XTrackerLoginModule() {
		super();
	}

	@SuppressWarnings("localHiding")
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	public boolean login() throws LoginException {
		if (callbackHandler == null) {
			throw new LoginException("No CallbackHandler was specified");
		}
		try {
			Callback[] callbacks = new Callback[2];
			callbacks[0] = new NameCallback("User: ");
			callbacks[1] = new PasswordCallback("Password: ", false);

			callbackHandler.handle(callbacks);

			String username = ((NameCallback) callbacks[0]).getName();
			char[] password = ((PasswordCallback) callbacks[1]).getPassword();

			((PasswordCallback) callbacks[1]).clearPassword();

			authenticatedPerson = authenticatePerson(username, password);
			if (authenticatedPerson != null) {
				authenticated = true;
			}

			callbacks[0] = null;
			callbacks[1] = null;

			if (!authenticated) {
				throw new LoginException("Authentication failed");
			}
		} catch (Exception e) {
			authenticated = false;
			throw new LoginException(e.getMessage());
		}
		return true;
	}

	public boolean commit() throws LoginException {
		if (authenticated) {
			if (subject.isReadOnly()) {
				throw new LoginException("Subject is read-only");
			}

			Set<Principal> principals = subject.getPrincipals();

			UserPrincipal userPrincipal = new UserPrincipal(authenticatedPerson.getUsername());
			principals.add(userPrincipal);

			List<PersonRole> roles = authenticatedPerson.getRoles();
			for (PersonRole role : roles) {
				RolePrincipal rolePrincipal = new RolePrincipal(role.getName());
				principals.add(rolePrincipal);
			}
		}
		return true;
	}

	public boolean abort() throws LoginException {
		authenticated = false;
		logout();
		return true;
	}

	@SuppressWarnings("unusedThrown")
	public boolean logout() throws LoginException {
		Iterator<Principal> iterator = subject.getPrincipals().iterator();
		while (iterator.hasNext()) {
			Principal principal = iterator.next();
			subject.getPrincipals().remove(principal);
		}
		return true;
	}

	private Person authenticatePerson(String username, char[] password) throws HibernateException {
		PersonLoader personLoader = new PersonLoader();
		Person result = personLoader.authenticatePerson(username, password);
		return result;
	}
}
