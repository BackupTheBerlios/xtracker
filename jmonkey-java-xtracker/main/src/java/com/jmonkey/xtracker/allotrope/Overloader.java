package com.jmonkey.xtracker.allotrope;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class Overloader {

	public Overloader() {
		super();
	}

	public static void main(String[] args) {
		try {
			QueueLoader queueLoader = new QueueLoader();
			Queue queue = queueLoader.loadAnonymousQueue();

			StatusLoader statusLoader = new StatusLoader();
			Status status = statusLoader.loadNewStatus();
			
			SeverityLoader severityLoader = new SeverityLoader();
			Severity severity = severityLoader.loadUnspecifiedSeverity();
			
			DispositionLoader disLoader = new DispositionLoader();
			Disposition disposition = disLoader.loadUnspecifiedDisposition();

			PersonLoader loader = new PersonLoader();
			Person requestor = loader.loadPerson("402880e40503aef1010503aef55d001a");

			Session session = HibernateSessionFactory.currentSession();

			Date created = new Date();
			for (int i = 0; i < 1000; i++) {
				Ticket ticket = new Ticket();
				ticket.setSubject("Overload Test " + i);
				ticket.setCreateDate(created);
				ticket.setModifyDate(created);
				ticket.setPriority(50);
				ticket.setQueue(queue);
				ticket.setStatus(status);
				ticket.setSeverity(severity);
				ticket.setDisposition(disposition);
				ticket.setRequestor(requestor);

				History history = new History();
				history.setSubject("Overload Test " + i);
				history.setCreateDate(created);
				history.setEncoding("ASCII");
				history.setImportance(2);
				history.setSystem(true);
				List<History> historyList = new ArrayList<History>();
				historyList.add(history);
				ticket.setHistory(historyList);
				Transaction transaction = session.beginTransaction();
				session.save(ticket);
				transaction.commit();
			}

			HibernateSessionFactory.closeSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
