package com.jmonkey.xtracker.profile.persistor;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestPersonPersistor extends BaseHibernateTestCase {
	private Person			testPerson	= null;
	private PersonPersistor	persistor	= null;

	@SuppressWarnings("unchecked")
	public void testPersonGetsSaved() throws HibernateException {
		persistor.savePerson(testPerson);

		List<Person> loadedList = hibernate.loadAllObjects(Person.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Person loaded = loadedList.get(0);
		assertEquals(ObjectMother.TEST_PERSON_USERNAME, loaded.getUsername());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testPersonGetsUpdated() throws HibernateException {

		hibernate.insertTestData(testPerson);
		assertNotNull(testPerson.getId());
		testPerson.setUsername("test test");
		persistor.updatePerson(testPerson);

		List<Person> loadedList = hibernate.loadAllObjects(Person.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Person loaded = loadedList.get(0);
		assertEquals("test test", loaded.getUsername());
		assertNotNull(loaded.getId());

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testPerson = ObjectMother.birthPerson();
		persistor = new PersonPersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Person.class);
		super.tearDown();
	}

}
