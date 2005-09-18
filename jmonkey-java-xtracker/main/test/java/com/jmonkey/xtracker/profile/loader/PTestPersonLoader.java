package com.jmonkey.xtracker.profile.loader;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.profile.Person;

public class PTestPersonLoader extends TestCase {

	public void testAuthenticate() throws HibernateException {
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.authenticatePerson("admin", "admin".toCharArray());
		assertNotNull(person);
	}
}
