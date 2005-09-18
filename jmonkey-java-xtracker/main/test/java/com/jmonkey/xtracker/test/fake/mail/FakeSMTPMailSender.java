package com.jmonkey.xtracker.test.fake.mail;

import java.util.Hashtable;
import java.util.List;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.Person;

public class FakeSMTPMailSender extends SMTPMailSender {

	public FakeSMTPMailSender() {
		super();
	}

	@Override
	public void addHeader(String key, String value) {
		super.addHeader(key, value);
	}

	@Override
	public void addTokenParam(String key, String value) {
		super.addTokenParam(key, value);
	}

	@Override
	public String getHostName() {
		return super.getHostName();
	}

	@Override
	protected Hashtable<String, String> getMailHeaders() {
		return super.getMailHeaders();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getRecipient() {
		return super.getRecipient();
	}

	@Override
	public String getSender() {
		return super.getSender();
	}

	@Override
	public String getSubject() {
		return super.getSubject();
	}

	@Override
	public StringBuffer getTokenTemplate() {
		return super.getTokenTemplate();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@SuppressWarnings("emptyBlock")
	@Override
	public void sendNewPersonMail(Person newPerson, String newPassword, Queue queue) throws Exception {
	}

	@SuppressWarnings("emptyBlock")
	@Override
	public void sendReplyMail(Ticket ticket, History history) throws Exception {
	}

	@SuppressWarnings("emptyBlock")
	@Override
	public void setHostName(String hostName) {
	}

	@Override
	public void setPassword(String password) {
	}

	@Override
	public void setRecipient(String recipient) {
	}

	@Override
	public void setSender(String sender) {
	}

	@Override
	public void setSubject(String subject) {
	}

	@Override
	public void setTokenTemplate(StringBuffer tokenTemplate) {
	}

	@Override
	public void setUsername(String username) {
	}

	@Override
	public void sendNewTicketInQueueMail(Ticket ticket, History history, Queue queue) throws Exception {
		
	}

	@Override
	public void sendTicketDueDatePending(List<Ticket> ticketList, int days) throws Exception {
		super.sendTicketDueDatePending(ticketList, days);
	}

	@Override
	public void sendTicketDueDateToday(List<Ticket> ticketList) throws Exception {
		super.sendTicketDueDateToday(ticketList);
	}

}
