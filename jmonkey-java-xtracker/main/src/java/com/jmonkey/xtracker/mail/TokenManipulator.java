package com.jmonkey.xtracker.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenManipulator {
	private String	prefix	= "XTracker";

	public TokenManipulator() {
		super();
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String addTokenToSubject(Long id, String subject) {
		if (!hasTicketToken(subject)) {
			subject = "[" + prefix + " " + id + "] " + subject;
		}
		return subject;
	}

	public Long extractTicketNumber(String subject) {
		Long id = null;
		Pattern pattern = Pattern.compile("\\[" + prefix + "\\s\\d+\\]");
		Matcher matcher = pattern.matcher(subject);
		boolean found = matcher.find();
		if (found) {
			String group = matcher.group();
			String ticketNumber = group.substring(group.lastIndexOf(" ") + 1, group.lastIndexOf("]"));
			id = new Long(ticketNumber);
		}
		return id;
	}

	public boolean hasTicketToken(String subject) {
		return subject.matches(".*\\[" + prefix + "\\s\\d+\\].*");
	}

	public String stripToken(String subject) {
		Pattern pattern = Pattern.compile("\\[" + prefix + "\\s\\d+\\]");
		Matcher matcher = pattern.matcher(subject);
		String result = matcher.replaceAll("");
		return result.trim();
	}

}
