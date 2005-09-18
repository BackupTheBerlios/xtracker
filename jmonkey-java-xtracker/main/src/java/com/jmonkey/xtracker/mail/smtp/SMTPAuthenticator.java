package com.jmonkey.xtracker.mail.smtp;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	private PasswordAuthentication	passwordAuthentication	= null;

	public SMTPAuthenticator(String username, String password) {
		super();
		passwordAuthentication = new PasswordAuthentication(username, password);
	}

	/**
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}

}
