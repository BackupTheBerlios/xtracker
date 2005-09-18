/*
 * Copyright 2004 Brill Pappin
 */
package com.jmonkey.xtracker.mail.pop;

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
 * @version $Revision: 1.1 $
 */
public class POPAccountReader {
	private final Logger	logger		= LogManager.getLogger(POPAccountReader.class);
	private String			host		= null;
	private String			username	= null;
	private String			password	= null;

	public POPAccountReader() {
		super();
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
	 * @param message
	 * @param event
	 * @throws MessagingException
	 */
	// private void getExtraHeaders(MimeMessage message, EventMessage event)
	// throws MessagingException {
	// Enumeration enum = message.getAllHeaders();
	// while (enum.hasMoreElements()) {
	// Header header = (Header) enum.nextElement();
	// if (header.getName().equalsIgnoreCase("X-Priority")) {
	// String hval = header.getValue();
	// try {
	// String numPart = "" + hval.trim().charAt(0);
	// event.setPriority(numPart);
	// if (logger.isDebugEnabled()) {
	// logger.debug("X-Priority: " + header.getValue());
	// }
	// } catch (Exception e) {
	// logger.error("Error parsing priority header: " + header.getValue(), e);
	// }
	// } else if (header.getName().equalsIgnoreCase("X-Accept-Language")) {
	// event.setAcceptLanguage(header.getValue());
	// if (logger.isDebugEnabled()) {
	// logger.debug("X-Accept-Language: " + header.getValue());
	// }
	// } else if (header.getName().equalsIgnoreCase("User-Agent")) {
	// event.setUserAgent(header.getValue());
	// if (logger.isDebugEnabled()) {
	// logger.debug("User-Agent: " + header.getValue());
	// }
	// }
	// }
	// }
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
		Session session = Session.getDefaultInstance(props, null);

		// -- Get hold of a POP3 message store, and connect to it --
		Store store = session.getStore("pop3");
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
