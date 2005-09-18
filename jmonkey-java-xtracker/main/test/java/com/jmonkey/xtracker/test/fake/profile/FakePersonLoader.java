package com.jmonkey.xtracker.test.fake.profile;

import java.security.Principal;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class FakePersonLoader extends PersonLoader {
	private Person	personByNameAndEmailToReturn	= null;
	private Person	personToReturn					= null;

	public FakePersonLoader() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.profile.loader.PersonLoader#loadPerson(java.lang.String)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Person loadPerson(String id) throws HibernateException {
		return personToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.profile.loader.PersonLoader#loadPersonForPrincipal(javax.servlet.http.HttpServletRequest)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Person loadPersonForPrincipal(Principal principal) throws HibernateException {
		return personToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.profile.loader.PersonLoader#loadPersonList()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public List<Person> loadPersonList(boolean selectable) throws HibernateException {
		return null;
	}

	/**
	 * @see com.jmonkey.xtracker.profile.loader.PersonLoader#findPersonByEmail(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Person findPersonByEmail(String emailAddress) {
		return personByNameAndEmailToReturn;
	}

	public void setupPersonToReturn(Person personToReturn) {
		this.personToReturn = personToReturn;
	}

	public void setupPersonByNameAndEmailToReturn(Person personByNameAndEmailToReturn) {
		this.personByNameAndEmailToReturn = personByNameAndEmailToReturn;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public Person authenticatePerson(String username, char[] password) throws HibernateException {
		return this.personToReturn;
	}

}
