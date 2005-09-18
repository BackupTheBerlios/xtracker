package com.jmonkey.xtracker.issue.loader;

import java.util.Date;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Queue;

public class TestQueueLoader extends BaseHibernateTestCase {
	private Queue		testQueue1	= null;
	private Queue		testQueue2	= null;
	private QueueLoader	loader		= null;

	public void testLoadQueueByAlias() throws HibernateException {
		Queue queue = loader.loadQueueByAlias("test");
		assertNotNull(queue);
		assertEquals(testQueue1.getId(), queue.getId());
	}

	public void testLoadQueueByLowercaseAliasWithSpaces() throws HibernateException {
		Queue queue = loader.loadQueueByAlias("aliaswithspace");
		assertNotNull(queue);
		assertEquals(testQueue2.getId(), queue.getId());
	}

	public void testLoadQueueByCamleCaseAliasWithSpaces() throws HibernateException {
		Queue queue = loader.loadQueueByAlias("AliasWithSpace");
		assertNotNull(queue);
		assertEquals(testQueue2.getId(), queue.getId());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new QueueLoader();

		testQueue1 = new Queue();
		testQueue1.setActive(true);
		testQueue1.setCreateDate(new Date());
		testQueue1.setName("test");
		testQueue1.setEmailAlias("test");
		hibernate.insertTestData(testQueue1);

		testQueue2 = new Queue();
		testQueue2.setActive(true);
		testQueue2.setCreateDate(new Date());
		testQueue2.setName("Alias With Space");
		testQueue2.setEmailAlias("AliasWithSpace");
		hibernate.insertTestData(testQueue2);

	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Queue.class);
		super.tearDown();
	}

}
