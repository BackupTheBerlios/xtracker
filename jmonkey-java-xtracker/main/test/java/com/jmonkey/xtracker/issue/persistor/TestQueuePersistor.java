package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;

public class TestQueuePersistor extends BaseHibernateTestCase {
	private Queue			testQueue	= null;
	private QueuePersistor	persistor	= null;

	@SuppressWarnings("unchecked")
	public void testSeverityGetsSaved() throws HibernateException {
		persistor.saveQueue(testQueue);

		List<Queue> loadedStatus = hibernate.loadAllObjects(Queue.class);
		assertNotNull(loadedStatus);
		assertEquals(1, loadedStatus.size());
		Queue loaded = loadedStatus.get(0);
		assertEquals("test@example.com", loaded.getEmailAlias());
		assertEquals("test", loaded.getName());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testSeverityGetsUpdated() throws HibernateException {

		hibernate.insertTestData(testQueue);
		assertNotNull(testQueue.getId());
		testQueue.setName("test test");
		persistor.updateQueue(testQueue);

		List<Queue> loadedStatus = hibernate.loadAllObjects(Queue.class);
		assertNotNull(loadedStatus);
		assertEquals(1, loadedStatus.size());
		Queue loaded = loadedStatus.get(0);
		assertEquals("test test", loaded.getName());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testSeverityGetsDeleted() throws HibernateException {
		hibernate.insertTestData(testQueue);

		persistor.deleteQueue(testQueue);

		List<Severity> loadedList = hibernate.loadAllObjects(Queue.class);
		assertNotNull(loadedList);
		assertEquals(0, loadedList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testQueue = new Queue();
		testQueue.setActive(true);
		testQueue.setCreateDate(new Date());
		testQueue.setEmailAlias("test@example.com");
		testQueue.setName("test");
		// testQueue.setManager(manager)

		persistor = new QueuePersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Queue.class);
		super.tearDown();
	}

}
