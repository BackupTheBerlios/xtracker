package com.jmonkey.xtracker.mail.local;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

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
import com.jmonkey.xtracker.mail.pop.ReceivedMailMessage;
import com.jmonkey.xtracker.mail.pop.ReceivedMailProcessor;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class MailInputStreamReceiver extends Thread {
	private Logger	logger	= LogManager.getLogger(MailInputStreamReceiver.class);
	private Socket	socket	= null;

	public MailInputStreamReceiver(ThreadGroup group, Socket socket) {
		super(group, "RAW-Receiver");
		this.socket = socket;
	}

	@Override
	public void run() {
		// try {
		// logger.debug("Setting socket timeout to 30 sec.");
		// socket.setSoTimeout(30000);
		// } catch (SocketException e) {
		// logger.warn("Error setting socket timeout", e);
		// }
		try {
			logger.debug("Reading message from stream...");
			ReceivedMailMessage mailMessage = readIncomingMessage();
			logger.debug("Processing message data...");
			processMessage(mailMessage);
		} catch (IOException e) {
			logger.error("Unable to receive message data", e);
		} catch (MessagingException e) {
			logger.error("Unable to parse MIME message", e);
		} catch (Exception e) {
			logger.error("Unable to process incoming message", e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				logger.warn("Unable to close receiver socket", e);
			}
		}
	}

	private ReceivedMailMessage readIncomingMessage() throws IOException, MessagingException {
		Properties sessionProperties = new Properties();
		Session session = Session.getDefaultInstance(sessionProperties);
		BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
		MimeMessage mimeMessage = new MimeMessage(session, inputStream);
		ReceivedMailMessage mailMessage = new ReceivedMailMessage(mimeMessage);
		mailMessage.processMessage();
		return mailMessage;
	}

	private void processMessage(ReceivedMailMessage mailMessage) throws Exception {
		MailConfig mailConfig = new MailConfig();
		PreferencesConfig preferencesConfig = new PreferencesConfig();
		ReceivedMailProcessor receivedMailProcessor = prepareMailProcessor(mailConfig, preferencesConfig);
		receivedMailProcessor.processMail(mailMessage);
	}

	private ReceivedMailProcessor prepareMailProcessor(MailConfig mailConfig, PreferencesConfig preferencesConfig) {
		// REFACTOR Refactor this; Duplicate of
		// POPReaderJob.prepareMailProcessor();
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
}
