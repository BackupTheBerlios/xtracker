/*
 * Copyright 2004 Brill Pappin
 */
package com.jmonkey.xtracker.mail.pop;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author brill
 * @version $Revision: 1.3 $
 */
public class POPAccountReader {
	private final Logger	logger			= LogManager.getLogger(POPAccountReader.class);
	private String			host			= null;
	private String			username		= null;
	private String			password		= null;
	private boolean			popUsingSsl		= false;
	private boolean			smtpUsingSsl	= false;
	private int				popSslPort		= 995;
	private boolean			debug			= false;

	public POPAccountReader() {
		super();
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isPopUsingSsl() {
		return popUsingSsl;
	}

	public void setPopUsingSsl(boolean popUsesSsl) {
		this.popUsingSsl = popUsesSsl;
	}

	public boolean isSmtpUsingSsl() {
		return smtpUsingSsl;
	}

	public void setSmtpUsingSsl(boolean smtpUsesSsl) {
		this.smtpUsingSsl = smtpUsesSsl;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int messageCount() throws NoSuchProviderException, MessagingException {
		if (logger.isDebugEnabled()) {
			logger.debug("getting message count...");
		}
		Store store = getMailStore();
		Folder folder = getInboxFolder(store);
		int count = folder.getMessageCount();
		store.close();
		if (logger.isDebugEnabled()) {
			logger.debug("found " + count + " messages...");
		}
		return count;
	}

	public List<ReceivedMailMessage> getMessageList() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("Opening connection to POP server...");
		}
		Store store = getMailStore();
		Folder folder = getInboxFolder(store);
		List<ReceivedMailMessage> messageList = new ArrayList<ReceivedMailMessage>();
		Message[] messages = folder.getMessages();
		if (logger.isDebugEnabled()) {
			logger.debug("Getting " + messages.length + " messages from POP server...");
		}
		for (int i = 0; i < messages.length; i++) {
			// try {
			MimeMessage message = (MimeMessage) messages[i];
			ReceivedMailMessage mailMessage = new ReceivedMailMessage(message);
			mailMessage.processMessage();
			messageList.add(mailMessage);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Marking " + messages.length + " messages as deleted...");
		}
		closeFolderAndDeleteMessages(folder);
		store.close();
		return messageList;
	}

	/**
	 * @param folder
	 * @throws MessagingException
	 */
	private void closeFolderAndDeleteMessages(Folder folder) throws MessagingException {
		Flags deleteFlag = new Flags(Flags.Flag.DELETED);
		int maxCount = folder.getMessageCount();
		folder.setFlags(1, maxCount, deleteFlag, true);
		folder.close(true);
	}

	/**
	 * @return
	 * @throws NoSuchProviderException
	 * @throws MessagingException
	 * @throws Exception
	 */
	private Folder getInboxFolder(Store store) throws NoSuchProviderException, MessagingException {

		// -- Try to get hold of the default folder --
		Folder folder = store.getDefaultFolder();
		if (folder == null) {
			throw new FolderNotFoundException(folder, "No default folder");
		}

		// -- ...and its INBOX --
		folder = folder.getFolder("INBOX");
		if (folder == null) {
			throw new FolderNotFoundException(folder, "No POP3 INBOX");
		}

		// -- Open the folder for read only --
		// folder.open(Folder.READ_ONLY);
		folder.open(Folder.READ_WRITE);

		return folder;
	}

	/**
	 * @return
	 * @throws NoSuchProviderException
	 * @throws MessagingException
	 */
	private Store getMailStore() throws NoSuchProviderException, MessagingException {
		// -- Get hold of the default session --
		Properties props = System.getProperties();

		String protocol = "pop3";

		props.setProperty("mail.debug", String.valueOf(debug));

		// XXX We need to set up some special stuff if we're using SSL.
		if (popUsingSsl) {
			protocol = "pop3s";

			Security.setProperty("ssl.SocketFactory.provider", "com.jmonkey.xtracker.mail.ssl.AcceptAllSSLSocketFactory");
			// POP3 provider
			props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			// POP3 provider
			props.setProperty("mail.pop3.socketFactory.fallback", "false");
			// POP3 provider
			props.setProperty("mail.pop3.socketFactory.fallback", "false");
			// POP3 provider
			props.setProperty("mail.pop3.port", Integer.toString(popSslPort));
			props.setProperty("mail.pop3.socketFactory.port", Integer.toString(popSslPort));

		}

		Session session = Session.getDefaultInstance(props, null);

		// -- Get hold of a POP3 message store, and connect to it --
		Store store = session.getStore(protocol);
		store.connect(host, username, password);
		return store;
	}

	// public static void printMessage(Message message)
	// {
	// try
	// {
	// // Get the header information
	// String from=((InternetAddress)message.getFrom()[0]).getPersonal();
	// if (from==null) from=((InternetAddress)message.getFrom()[0])
	// .getAddress();
	// System.out.println("FROM: "+from);
	//
	// String subject=message.getSubject();
	// System.out.println("SUBJECT: "+subject);
	//
	// // -- Get the message part (i.e. the message itself) --
	// Part messagePart=message;
	// Object content=messagePart.getContent();
	//
	// // -- or its first body part if it is a multipart message --
	// if (content instanceof Multipart)
	// {
	// messagePart=((Multipart)content).getBodyPart(0);
	// System.out.println("[ Multipart Message ]");
	// }
	//
	// // -- Get the content type --
	// String contentType=messagePart.getContentType();
	//
	// // -- If the content is plain text, we can print it --
	// System.out.println("CONTENT:"+contentType);
	//
	// if (contentType.startsWith("text/plain")
	// || contentType.startsWith("text/html"))
	// {
	// InputStream is = messagePart.getInputStream();
	//
	// BufferedReader reader
	// =new BufferedReader(new InputStreamReader(is));
	// String thisLine=reader.readLine();
	//
	// while (thisLine!=null)
	// {
	// System.out.println(thisLine);
	// thisLine=reader.readLine();
	// }
	// }
	//
	// System.out.println("-----------------------------");
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// }
	// }
	// }
}
