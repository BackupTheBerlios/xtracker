package com.jmonkey.xtracker.test.fake.issue;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;

public class FakeSeverityLoader extends SeverityLoader {

	public FakeSeverityLoader() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.SeverityLoader#loadSeverity(java.lang.String)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Severity loadSeverity(long id) throws HibernateException {
		return null;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.SeverityLoader#loadSeverityList()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public List<Severity> loadSeverityList() throws HibernateException {
		return null;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.SeverityLoader#loadUnspecifiedSeverity()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Severity loadUnspecifiedSeverity() throws HibernateException {
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
