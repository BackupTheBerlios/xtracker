package com.jmonkey.xtracker.test.fake.issue;

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.loader.QueueLoader;

public class FakeQueueLoader extends QueueLoader {
	private Queue	testQueueToLoad	= null;

	public FakeQueueLoader() {
		return;
	}

	public void setTestQueueToLoad(Queue testQueueToLoad) {
		this.testQueueToLoad = testQueueToLoad;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.QueueLoader#loadAnonymousQueue()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Queue loadAnonymousQueue() throws HibernateException {
		return testQueueToLoad;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.QueueLoader#loadQueue(java.lang.String)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Queue loadQueue(String id) throws HibernateException {
		return testQueueToLoad;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.QueueLoader#loadQueueList()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public List<Queue> loadQueueList(boolean selectable, boolean avtive) throws HibernateException {
		List<Queue> queueList = new ArrayList<Queue>();
		queueList.add(testQueueToLoad);
		return queueList;
	}

	@Override
	public Queue loadQueueByAlias(String string) throws HibernateException {
		return null;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	protected void checkClose() throws HibernateException {
		return;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	protected void checkOpen() throws HibernateException {
		return;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public void close() throws HibernateException {
		return;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public void open() throws HibernateException {
		return;
	}

}
