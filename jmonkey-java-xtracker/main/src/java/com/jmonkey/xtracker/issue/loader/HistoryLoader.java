package com.jmonkey.xtracker.issue.loader;

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.MailReference;

public class HistoryLoader extends PersistanceManager {

	public HistoryLoader() {
		super();
	}

	public History loadHistory(String id) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		History history = (History) session.load(History.class, id);
		transaction.commit();
		checkClose();
		return history;
	}

	@SuppressWarnings("unchecked")
	public List<History> loadHistoryListByReferences(History rootHistory) throws HibernateException {
		List<History> historyList = new ArrayList<History>();
		checkOpen();
		Transaction transaction = session.beginTransaction();

		List<MailReference> rootReferences = rootHistory.getMessageReferences();
		if (rootReferences.size() > 0) {
			List<String> refIds = new ArrayList<String>();

			for (MailReference ref : rootReferences) {
				refIds.add(ref.getMessageId());
			}

			Criteria criteria = session.createCriteria(History.class);
			criteria.add(Expression.in("messageId", refIds));
			criteria.addOrder(Order.desc("createDate"));
			historyList = criteria.list();
		}
		transaction.commit();
		checkClose();
		return historyList;
	}
}
