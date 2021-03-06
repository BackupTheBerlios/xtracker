package com.jmonkey.xtracker.mail.pop;

import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.auth.RandomPasswordGenerator;
import com.jmonkey.xtracker.issue.attachment.AttachmentHandler;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class PopReaderTask extends TimerTask {
	private Logger				logger				= LogManager.getLogger(PopReaderTask.class);
	private PreferencesConfig	preferencesConfig	= new PreferencesConfig();
	private boolean debugMail = false;

	public PopReaderTask() {
		super();
		logger.debug("Creating: " + getClass().getName());
	}

	@Override
	public void run() {
		MailConfig mailConfig = new MailConfig();
		if (mailConfig.isPopCheckingEnabled()) {
			POPAccountReader popReader = new POPAccountReader();
			popReader.setDebug(debugMail);
			popReader.setHost(mailConfig.getPopMailHost());
			popReader.setUsername(mailConfig.getPopHostUsername());
			popReader.setPassword(mailConfig.getPopHostPassword());
			popReader.setPopUsingSsl(mailConfig.isPopUsingSslEnabled());

			try {
				List<ReceivedMailMessage> messageList = popReader.getMessageList();
				if (logger.isDebugEnabled()) {
					logger.debug("Pop account has " + messageList.size() + " new messages...");
				}
				ReceivedMailProcessor receivedMailProcessor = prepareMailProcessor(mailConfig);
				for (ReceivedMailMessage mailMessage : messageList) {
					try {
						receivedMailProcessor.processMail(mailMessage);
					} catch (Exception e) {
						logger.fatal("Could not process incoming mail", e);
					}
				}
			} catch (Exception e) {
				logger.error("POP Reader failed", e);
			}
		}
	}

	private ReceivedMailProcessor prepareMailProcessor(MailConfig mailConfig) {
		// REFACTOR: Refactor this; Duplicate of
		// MailInputStreamReceiver.prepareMailProcessor();
		ReceivedMailProcessor receivedMailProcessor = new ReceivedMailProcessor();
		receivedMailProcessor.setPersonLoader(new PersonLoader());
		receivedMailProcessor.setTicketLoader(new TicketLoader());
		receivedMailProcessor.setTicketPersistor(new TicketPersistor());
		receivedMailProcessor.setPersonPersistor(new PersonPersistor());
		receivedMailProcessor.setStatusLoader(new StatusLoader());
		receivedMailProcessor.setDispositionLoader(new DispositionLoader());
		receivedMailProcessor.setQueueLoader(new QueueLoader());
		receivedMailProcessor.setSeverityLoader(new SeverityLoader());
		receivedMailProcessor.setDefaultPriority(preferencesConfig.getInitialTicketPriority());
		receivedMailProcessor.setPasswordGenerator(new RandomPasswordGenerator());
		receivedMailProcessor.setMailSender(new SMTPMailSender());
		AttachmentHandler attachmentHandler = new AttachmentHandler();
		attachmentHandler.setAttachmentRoot(mailConfig.getAttachmentRootDirectory());
		receivedMailProcessor.setAttachmentHandler(attachmentHandler);
		return receivedMailProcessor;
	}

	public boolean isDebugMail() {
		return debugMail;
	}

	public void setDebugMail(boolean debugMail) {
		this.debugMail = debugMail;
	}
	
	
}
