package com.jmonkey.xtracker.test.fake.profile;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class FakePersonPersistor extends PersonPersistor {
	private Person	savedPerson		= null;
	private Person	updatedPerson	= null;

	public FakePersonPersistor() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.profile.persistor.PersonPersistor#savePerson(com.jmonkey.xtracker.profile.Person)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public void savePerson(Person person) throws HibernateException {
		savedPerson = person;
	}

	/**
	 * @see com.jmonkey.xtracker.profile.persistor.PersonPersistor#updatePerson(com.jmonkey.xtracker.profile.Person)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public void updatePerson(Person person) throws HibernateException {
		updatedPerson = person;
	}

	public Person getSavedPerson() {
		return savedPerson;
	}

	public Person getUpdatedPerson() {
		return updatedPerson;
	}
	
}
