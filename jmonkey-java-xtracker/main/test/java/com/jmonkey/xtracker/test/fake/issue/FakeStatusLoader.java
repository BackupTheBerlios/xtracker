package com.jmonkey.xtracker.test.fake.issue;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.loader.StatusLoader;

public class FakeStatusLoader extends StatusLoader {
	private Status	statusToReturn	= null;

	public FakeStatusLoader() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.StatusLoader#loadNewStatus()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Status loadNewStatus() throws HibernateException {
		return statusToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.StatusLoader#loadStatus(java.lang.String)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Status loadStatus(long id) throws HibernateException {
		return statusToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.StatusLoader#loadStatusList()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public List<Status> loadStatusList() throws HibernateException {
		return null;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.StatusLoader#loadStatusWithNextId(com.jmonkey.xtracker.issue.Status)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Status loadStatusWithNextId(Status status) throws HibernateException {
		return statusToReturn;
	}


	public void setupStatusToReturn(Status statusToReturn) {
		this.statusToReturn = statusToReturn;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public Status loadOpenStatus() throws HibernateException {
		return statusToReturn;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public List<Status> loadStatusListNotClosed() throws HibernateException {
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
