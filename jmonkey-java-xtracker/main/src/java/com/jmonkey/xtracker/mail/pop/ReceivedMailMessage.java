package com.jmonkey.xtracker.mail.pop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ReceivedMailMessage {
	private final List<ReceivedMailAttachement>	attachements		= new ArrayList<ReceivedMailAttachement>();
	private MimeMessage							message				= null;
	private Date								receivedDate		= null;
	private String								subject				= null;
	private String								body				= null;
	private String								contentType			= null;
	private String								characterSet		= null;
	private String								fromPersonalName	= null;
	private String								fromEmailAddress	= null;
	private String								toEmailAddress		= null;
	private String								messageId			= null;
	private List<String>						messageReferenceIds	= new ArrayList<String>();
	private boolean								processed			= false;
	private Map<String, String>					headers				= new TreeMap<String, String>();

	// private String language = null;

	public ReceivedMailMessage() {
		super();
	}

	public ReceivedMailMessage(MimeMessage message) {
		super();
		this.message = message;
	}

	public MimeMessage getMessage() {
		return message;
	}

	public void setMessage(MimeMessage message) {
		this.message = message;
	}

	public String getHeader(String key) {
		return headers.get(key);
	}

	public void processMessage() throws MessagingException, IOException {
		if (!processed) {
			handleMessageAttributes();
			handleMessageHeaders();
			
			Object content = message.getContent();
			if (content instanceof MimeMultipart) {
				MimeMultipart multipart = (MimeMultipart) content;
				for (int i = 0, n = multipart.getCount(); i < n; i++) {
					Part part = multipart.getBodyPart(i);
					String disposition = part.getDisposition();
					String partContentType = part.getContentType();
					// System.out.println("Types: " + disposition + ", " +
					// contentType);
					if (disposition == null) { // When just body
						if (partContentType.startsWith("text/plain")) {
							body = (String) part.getContent();
						}
					} else if (disposition.equalsIgnoreCase(Part.ATTACHMENT)) {
						handleAttachement(part);
					} else if (disposition.equalsIgnoreCase(Part.INLINE)) {
						handleAttachement(part);
					}
				}
			} else {
				body = (String) content;
			}
			processed = true;
		}
	}

	private void handleMessageHeaders() throws MessagingException {
		Enumeration headerEnum = message.getAllHeaders();
		while (headerEnum.hasMoreElements()) {
			@SuppressWarnings("unchecked") 
			Header element = (Header) headerEnum.nextElement();
			headers.put(element.getName(), element.getValue());

		}
	}

	public boolean isProcessed() {
		return processed;
	}

	private void handleMessageAttributes() throws MessagingException, IOException {
		// language = message.getContentLanguage();
		InternetAddress[] fromAddress = (InternetAddress[]) message.getFrom();
		if (fromAddress.length > 0) {
			InternetAddress fromAddr = fromAddress[0];
			fromEmailAddress = fromAddr.getAddress();
			fromPersonalName = fromAddr.getPersonal();
			if (fromPersonalName == null) {
				fromPersonalName = fromEmailAddress;
			}
		}

		InternetAddress[] toAddress = (InternetAddress[]) message.getRecipients(Message.RecipientType.TO);
		if (toAddress.length > 0) {
			InternetAddress toAddr = toAddress[0];
			toEmailAddress = toAddr.getAddress();
		}

		messageId = message.getMessageID();
		String[] refIds = message.getHeader("References");
		if (refIds != null) {
			BufferedReader reader = new BufferedReader(new StringReader(refIds[0]));
			String line = null;
			while ((line = reader.readLine()) != null) {
				messageReferenceIds.add(line.trim());
			}
		}

		subject = message.getSubject();
		receivedDate = message.getReceivedDate();
		String mailType = message.getContentType();

		String[] mimeStr = mailType.split(";");
		// text/plain; charset=US-ASCII
		contentType = mimeStr[0].trim();
		if (mimeStr.length > 1) {
			String[] charset = mimeStr[1].split("=");
			if (charset[0] != null && charset[0].trim().equalsIgnoreCase("charset")) {
				characterSet = charset[1].trim();
			}
		}
	}

	private void handleAttachement(Part part) throws MessagingException, IOException {
		ReceivedMailAttachement attachement = new ReceivedMailAttachement(part);
		attachement.processPart();
		attachements.add(attachement);
	}

	public String getSubject() {
		return subject;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public List<ReceivedMailAttachement> getAttachements() {
		return attachements;
	}

	public String getBody() {
		return body;
	}

	public String getContentType() {
		return contentType;
	}

	public String getCharset() {
		return characterSet;
	}

	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	public String getFromPersonalName() {
		return fromPersonalName;
	}

	public String getToEmailAddress() {
		return toEmailAddress;
	}

	public String getMessageId() {
		return messageId;
	}

	public List<String> getMessageReferenceIds() {
		return messageReferenceIds;
	}

}
