package com.jmonkey.xtracker.issue.loader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.MailReference;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestHistoryLoader extends BaseHibernateTestCase {
	private HistoryLoader	loader			= null;
	private History			testHistory1	= null;
	private History			testHistory2	= null;

	public void testResultIsZeroLengthNotNull() throws HibernateException {
		List<History> refHistoryList = loader.loadHistoryListByReferences(testHistory1);
		assertNotNull(refHistoryList);
		assertEquals(0, refHistoryList.size());
	}

	public void testMailRefLoader() throws HibernateException {
		List<History> refHistoryList = loader.loadHistoryListByReferences(testHistory2);
		assertNotNull(refHistoryList);
		assertEquals(1, refHistoryList.size());
		for (History history : refHistoryList) {
			System.out.println(history.getMessageId());
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new HistoryLoader();

		Person person = ObjectMother.birthPerson();
		hibernate.insertTestData(person);

		testHistory1 = new History();
		testHistory1.setAuthor(person);
		testHistory1.setSubject("test 1");
		testHistory1.setContent("Test 1");
		testHistory1.setCreateDate(new Date());
		testHistory1.setMessageId("test-1-mailref");
		hibernate.insertTestData(testHistory1);

		testHistory2 = new History();
		testHistory2.setAuthor(person);
		testHistory2.setSubject("test 2");
		testHistory2.setContent("Test 2");
		testHistory2.setCreateDate(new Date());
		testHistory2.setMessageId("test-2-mailref");
		List<MailReference> mailReferences = new ArrayList<MailReference>();
		MailReference mailRef = new MailReference();
		mailRef.setMessageDate(new Date());
		mailRef.setMessageId("test-1-mailref");
		mailReferences.add(mailRef);
		testHistory2.setMessageReferences(mailReferences);
		hibernate.insertTestData(testHistory2);
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(History.class);
		hibernate.cleanUpDatabase(Person.class);
		loader = null;
		super.tearDown();
	}

}
