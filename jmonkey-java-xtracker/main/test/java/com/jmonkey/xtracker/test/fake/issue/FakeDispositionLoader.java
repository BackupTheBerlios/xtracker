package com.jmonkey.xtracker.test.fake.issue;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;

public class FakeDispositionLoader extends DispositionLoader {

	public FakeDispositionLoader() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.DispositionLoader#loadDisposition(java.lang.String)
	 */
	@Override
	public Disposition loadDisposition(long id) throws HibernateException {
		return null;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.DispositionLoader#loadDispositionList()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public List<Disposition> loadDispositionList(boolean filterActive, boolean filterSelectable) throws HibernateException {
		return null;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.DispositionLoader#loadUnspecifiedDisposition()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public Disposition loadUnspecifiedDisposition() throws HibernateException {
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
