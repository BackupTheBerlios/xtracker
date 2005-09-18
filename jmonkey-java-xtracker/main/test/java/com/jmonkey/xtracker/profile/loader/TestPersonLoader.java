package com.jmonkey.xtracker.profile.loader;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestPersonLoader extends BaseHibernateTestCase {
	private Person			testPerson	= null;
	private PersonLoader	loader		= null;

	public void testShouldAuthenticatePersonWithMatchingUsernameAndPassword() throws HibernateException {
		Person person = loader.authenticatePerson(ObjectMother.TEST_PERSON_USERNAME, ObjectMother.TEST_PERSON_PASSWORD.toCharArray());
		assertNotNull(person);
		assertEquals(ObjectMother.TEST_PERSON_REAL_NAME, person.getRealname());
	}

	public void testShouldFindPersonByEmailAddress() throws HibernateException {
		Person person = loader.findPersonByEmail(ObjectMother.TEST_PERSON_EMAIL_ADDRESS);
		assertNotNull(person);
		assertEquals(ObjectMother.TEST_PERSON_REAL_NAME, person.getRealname());
	}

	public void testShouldLoadPersonById() throws HibernateException {
		Person person = loader.loadPerson(testPerson.getId());
		assertNotNull(person);
		assertEquals(ObjectMother.TEST_PERSON_REAL_NAME, person.getRealname());
	}

	public void testShouldLoadPersonByPrincipalName() throws HibernateException {
		Person person = loader.loadPersonForPrincipal(ObjectMother.birthPrincipal());
		assertNotNull(person);
		assertEquals(ObjectMother.TEST_PERSON_REAL_NAME, person.getRealname());
	}

	public void testShouldLoadSelectablePersonList() throws HibernateException {
		List<Person> personList = loader.loadPersonList(true);
		assertNotNull(personList);
		assertEquals(1, personList.size());
	}

	public void testShouldLoadPersonList() throws HibernateException {
		List<Person> personList = loader.loadPersonList(false);
		assertNotNull(personList);
		assertEquals(2, personList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new PersonLoader();

		testPerson = ObjectMother.birthPerson();
		Person testNonSelectablePerson = ObjectMother.birthPerson();
		testNonSelectablePerson.setUsername("testperson2");
		testNonSelectablePerson.setSelectable(false);
		hibernate.insertTestData(testPerson);
		hibernate.insertTestData(testNonSelectablePerson);
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Person.class);
		loader = null;
		super.tearDown();
	}

}
