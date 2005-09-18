package com.jmonkey.xtracker.auth;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.jmonkey.xtracker.auth.realm.RolePrincipal;
import com.jmonkey.xtracker.auth.realm.UserPrincipal;
import com.jmonkey.xtracker.test.fake.FakeHttpServletRequest;
import com.jmonkey.xtracker.test.fake.FakeHttpSession;

public class TestAuthEnvironment extends TestCase {
	private FakeHttpSession			fakeSession		= null;
	private FakeHttpServletRequest	fakeHttpRequest	= null;
	private AuthEnvironment			authEnv			= null;
	private UserPrincipal			testPrincipal1	= null;
	private UserPrincipal			testPrincipal2	= null;

	public void testPrincipalTakenFromSessionBeforeRequestIfExists() {
		fakeHttpRequest.setupPrincipal(testPrincipal1);
		fakeSession.setAttribute(UserPrincipal.class.getName(), testPrincipal2);

		Principal principal = authEnv.getPrincipal();
		assertNotNull(principal);
		assertEquals(testPrincipal2.getName(), principal.getName());
	}

	public void testPrincipalTakenFromSessionIfRequestPrincipalNotExists() {
		fakeSession.setAttribute(UserPrincipal.class.getName(), testPrincipal1);

		Principal principal = authEnv.getPrincipal();
		assertNotNull(principal);
		assertEquals(testPrincipal1.getName(), principal.getName());
	}

	public void testReturnsNullIfNoRequestOrSessionPrincipal() {
		Principal principal = authEnv.getPrincipal();
		assertNull(principal);
	}

	public void testIsInRoleReturnFalseIfPrincipalNull() {

		boolean result = authEnv.isUserInRole("example");
		assertFalse(result);
	}

	public void testIsInRoleReturnsFromRequestIfRequestNotNull() {
		fakeHttpRequest.setupPrincipal(testPrincipal1);
		fakeHttpRequest.setupUserInRole(true);

		boolean result = authEnv.isUserInRole("example");
		assertTrue(result);
	}

	public void testIsInRoleReturnsFromSessionIfRequestIsNull() {
		fakeHttpRequest.setupUserInRole(false);
		fakeSession.setAttribute(UserPrincipal.class.getName(), testPrincipal1);

		boolean result = authEnv.isUserInRole("role-1-B");
		assertTrue(result);
	}
	
	public void testCanRemoveSessionPrincipal() {
		fakeSession.setAttribute(UserPrincipal.class.getName(), testPrincipal2);

		Principal principal = authEnv.getPrincipal();
		assertNotNull(principal);
		assertEquals(testPrincipal2.getName(), principal.getName());
		
		boolean removed = authEnv.removePrincipal();
		assertTrue(removed);
		assertNull(authEnv.getPrincipal());
	}
	
	public void testRemoveSessionPrincipalFalseIfHasRequestPrincipal() {
		fakeHttpRequest.setupPrincipal(testPrincipal1);
		fakeSession.setAttribute(UserPrincipal.class.getName(), testPrincipal2);

		Principal principal = authEnv.getPrincipal();
		assertNotNull(principal);
		assertEquals(testPrincipal2.getName(), principal.getName());
		
		boolean removed = authEnv.removePrincipal();
		assertFalse(removed);
		assertNotNull(authEnv.getPrincipal());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		List<RolePrincipal> roles1 = new ArrayList<RolePrincipal>();
		roles1.add(new RolePrincipal("role-1-A"));
		roles1.add(new RolePrincipal("role-1-B"));
		testPrincipal1 = new UserPrincipal("test-1");
		testPrincipal1.setRoles(roles1);

		List<RolePrincipal> roles2 = new ArrayList<RolePrincipal>();
		roles2.add(new RolePrincipal("role-2-A"));
		roles2.add(new RolePrincipal("role-2-B"));
		testPrincipal2 = new UserPrincipal("test-2");
		testPrincipal2.setRoles(roles2);

		fakeSession = new FakeHttpSession();
		fakeHttpRequest = new FakeHttpServletRequest();
		fakeHttpRequest.setupSession(fakeSession);

		authEnv = new AuthEnvironment(fakeHttpRequest);
	}

	@Override
	protected void tearDown() throws Exception {
		authEnv = null;
		fakeSession = null;
		fakeHttpRequest = null;
		testPrincipal1 = null;
		testPrincipal2 = null;

		super.tearDown();
	}

}
