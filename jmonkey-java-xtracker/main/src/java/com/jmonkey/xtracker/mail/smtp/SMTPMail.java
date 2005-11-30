package com.jmonkey.xtracker.mail.smtp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;

public class SMTPMail {
	public static final int			PRIOTIRY_HIGHEST			= 1;
	public static final int			PRIOTIRY_HIGH				= 2;
	public static final int			PRIOTIRY_NORMAL				= 3;
	public static final int			PRIOTIRY_LOW				= 4;
	public static final int			PRIOTIRY_LOWEST				= 5;
	public static final String		HEADER_X_PRIORITY			= "X-Priority";
	public static final String		HEADER_X_MAILER				= "X-Mailer";
	public static final String		TYPE_TEXT_PLAIN				= "text/plain";

	private Date					sentDate					= new Date();
	private String					subject						= null;
	private String					charset						= null;
	private Object					content						= null;
	private String					contentType					= null;
	private MimeMultipart			body						= null;
	private InternetAddress			fromAddress					= null;
	private List<InternetAddress>	toList						= new ArrayList<InternetAddress>();
	private List<InternetAddress>	ccList						= new ArrayList<InternetAddress>();
	private List<InternetAddress>	bccList						= new ArrayList<InternetAddress>();
	private List<InternetAddress>	replyToList					= new ArrayList<InternetAddress>();
	private Session					session						= null;
	private String					host						= null;
	private int						port						= 25;
	private boolean					debug						= false;
	private SMTPAuthenticator		smtpAuthenticator			= null;
	private Map<String, String>		headers						= new HashMap<String, String>();
	private int						priority					= PRIOTIRY_NORMAL;
	private String					mailer						= null;

	public SMTPMail() {
		super();
	}
	
	public boolean hasRecipient() {
		return (toList.size() > 0) || (replyToList.size() > 0);
	}

	public void addHeader(String name, String value) {
		headers.put(name, value);
	}

	protected Session initlSession() {
		if (session == null) {
			Properties properties = new Properties(System.getProperties());
			properties.setProperty("mail.transport.protocol", "smtp");

			if (!StringUtils.isNotEmpty(host)) {
				host = properties.getProperty("mail.host");
			}

			if (!StringUtils.isNotEmpty(host)) {
				throw new IllegalStateException("Cannot find valid hostname for mail session");
			}

			properties.setProperty("mail.smtp.port", Integer.toString(port));
			properties.setProperty("mail.host", host);
			properties.setProperty("mail.debug", String.valueOf(debug));

			if (smtpAuthenticator != null) {
				properties.setProperty("mail.smtp.auth", "true");
			}

			session = Session.getInstance(properties, smtpAuthenticator);
		}
		return session;
	}

	private InternetAddress parseInternetAddress(String email, String name) throws Exception {
		InternetAddress address = null;
		if (!StringUtils.isNotEmpty(name)) {
			name = email;
		}
		if (StringUtils.isNotEmpty(charset)) {
			address = new InternetAddress(email, name, charset);
		} else {
			address = new InternetAddress(email, name);
		}
		address.validate();
		return address;
	}

	public void send() throws MessagingException {
		initlSession();
		MimeMessage message = new MimeMessage(this.session);

		if (StringUtils.isNotEmpty(subject)) {
			if (StringUtils.isNotEmpty(charset)) {
				message.setSubject(subject, charset);
			} else {
				message.setSubject(subject);
			}
		}

		if (content != null) {
			message.setContent(content, contentType);
		} else if (body != null) {
			message.setContent(body);
		} else {
			message.setContent("", TYPE_TEXT_PLAIN);
		}

		if (fromAddress != null) {
			message.setFrom(fromAddress);
		} else {
			throw new IllegalStateException("Sender address required");
		}

		if (toList.size() + ccList.size() + bccList.size() == 0) {
			throw new IllegalStateException("At least one receiver address required");
		}

		if (this.toList.size() > 0) {
			message.setRecipients(Message.RecipientType.TO, toList.toArray(new InternetAddress[0]));
		}

		if (ccList.size() > 0) {
			message.setRecipients(Message.RecipientType.CC, ccList.toArray(new InternetAddress[0]));
		}

		if (bccList.size() > 0) {
			message.setRecipients(Message.RecipientType.BCC, bccList.toArray(new InternetAddress[0]));
		}

		if (replyToList.size() > 0) {
			message.setReplyTo(replyToList.toArray(new InternetAddress[0]));
		}

		if (headers.size() > 0) {
			Iterator<String> headerKeys = headers.keySet().iterator();
			while (headerKeys.hasNext()) {
				String name = headerKeys.next();
				String value = headers.get(name);
				message.addHeader(name, value);
			}
		}

		message.addHeader(HEADER_X_PRIORITY, Integer.toString(priority));
		if (mailer != null) {
			message.addHeader(HEADER_X_MAILER, mailer);
		}

		if (sentDate == null) {
			message.setSentDate(new Date());
		} else {
			message.setSentDate(sentDate);
		}

		Transport.send(message);
	}

	public void setContent(MimeMultipart multiPart) {
		body = multiPart;
	}

	public void setContent(Object bodyContent, String type) {
		content = bodyContent;
		if (!StringUtils.isNotEmpty(type)) {
			type = null;
		} else {
			contentType = type;
			String strMarker = "; charset=";
			int charsetPos = type.toLowerCase().indexOf(strMarker);

			if (charsetPos != -1) {
				// find the next space (after the marker)
				charsetPos += strMarker.length();
				int intCharsetEnd = type.toLowerCase().indexOf(" ", charsetPos);

				if (intCharsetEnd != -1) {
					charset = type.substring(charsetPos, intCharsetEnd);
				} else {
					charset = type.substring(charsetPos);
				}
			}
		}
	}

	public void setMessage(String msg) {
		setContent(msg, TYPE_TEXT_PLAIN);
	}

	public void setFrom(String email) throws Exception {
		setFrom(email, null);
	}

	public void setFrom(String email, String name) throws Exception {
		fromAddress = parseInternetAddress(email, name);
	}

	public void addTo(String email) throws Exception {
		addTo(email, null);
	}

	public void addTo(String email, String name) throws Exception {
		toList.add(parseInternetAddress(email, name));
	}

	public void setTo(List<InternetAddress> tos) {
		toList = tos;
	}

	public void addCc(String email) throws Exception {
		addCc(email, null);
	}

	public void addCc(String email, String name) throws Exception {
		ccList.add(parseInternetAddress(email, name));
	}

	public void setCc(List<InternetAddress> ccs) {
		ccList = ccs;
	}

	public void addBcc(String email) throws Exception {
		addBcc(email, null);
	}

	public void addBcc(String email, String name) throws Exception {
		bccList.add(parseInternetAddress(email, name));
	}

	public void setBcc(List<InternetAddress> bccs) {
		this.bccList = bccs;
	}

	public void addReplyTo(String email) throws Exception {
		addReplyTo(email, null);
	}

	public void addReplyTo(String email, String name) throws Exception {
		replyToList.add(parseInternetAddress(email, name));
	}

	public MimeMultipart getBody() {
		return body;
	}

	public void setBody(MimeMultipart body) {
		this.body = body;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public InternetAddress getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(InternetAddress fromAddress) {
		this.fromAddress = fromAddress;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMailer() {
		return mailer;
	}

	public void setMailer(String mailer) {
		this.mailer = mailer;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public SMTPAuthenticator getAuthenticator() {
		return smtpAuthenticator;
	}

	public void setAuthenticator(SMTPAuthenticator smtpAuthenticator) {
		this.smtpAuthenticator = smtpAuthenticator;
	}

	public void setAuthentication(String username, String password) {
		this.smtpAuthenticator = new SMTPAuthenticator(username, password);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
