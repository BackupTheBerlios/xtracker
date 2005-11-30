package com.jmonkey.xtracker.mail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.BooleanUtils;

import com.jmonkey.xtracker.config.ConfigException;
import com.jmonkey.xtracker.config.PropertiesConfig;

public class MailConfig extends PropertiesConfig {

	private static final String	CONFIG_NAME	= "mail";

	public MailConfig() {
		this(false);
	}

	public MailConfig(boolean autoReload) {
		super(CONFIG_NAME, autoReload);
	}

	public MailConfig(File root, boolean autoReload) {
		super(root, CONFIG_NAME, autoReload);
	}

	public void writeNewConfigDefaults(File file) throws ConfigException {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			throw new ConfigException(e);
		}
	}

	public String getSmtpMailHost() {
		String host = getConfiguration().getString("smtp.host.name", "localhost");
		return host;
	}

	public void setSmtpMailHost(String host) {
		getConfiguration().setProperty("smtp.host.name", host);
	}

	public boolean isSmtpHostRequiresPassword() {
		boolean value = getConfiguration().getBoolean("smtp.host.auth.required", false);
		return value;
	}

	public void setSmtpHostRequiresPassword(boolean requires) {
		getConfiguration().setProperty("smtp.host.auth.required", BooleanUtils.toStringTrueFalse(requires));
	}

	public String getSmtpHostUsername() {
		String username = getConfiguration().getString("smtp.host.auth.username", "");
		return username;
	}

	public void setSmtpHostUsername(String username) {
		getConfiguration().setProperty("smtp.host.auth.username", username);
	}

	public String getSmtpHostPassword() {
		String password = getConfiguration().getString("smtp.host.auth.password", "");
		return password;
	}

	public void setSmtpHostPassword(String password) {
		getConfiguration().setProperty("smtp.host.auth.password", password);
	}

	public String getFromEmailAddress() {
		String value = getConfiguration().getString("from.email.address", "xtracker@example.com");
		return value;
	}

	public void setFromEmailAddress(String address) {
		getConfiguration().setProperty("from.email.address", address);
	}

	public String getPopCheckCronExpression() {
		String value = getConfiguration().getString("pop.cron.expression", "0 * * * * ?");
		return value;
	}

	public void setPopCheckCronExpression(String expression) {
		getConfiguration().setProperty("pop.cron.expression", expression);
	}

	public String getPopMailHost() {
		String host = getConfiguration().getString("pop.host.name", "localhost");
		return host;
	}

	public void setPopMailHost(String host) {
		getConfiguration().setProperty("pop.host.name", host);
	}

	public String getPopHostUsername() {
		String username = getConfiguration().getString("pop.host.auth.username", "");
		return username;
	}

	public void setPopHostUsername(String username) {
		getConfiguration().setProperty("pop.host.auth.username", username);
	}

	public String getPopHostPassword() {
		String password = getConfiguration().getString("pop.host.auth.password", "");
		return password;
	}

	public void setPopHostPassword(String password) {
		getConfiguration().setProperty("pop.host.auth.password", password);
	}

	public File getAttachmentRootDirectory() {
		String dir = getConfiguration().getString("attachment.root.directory", "/var/xtracker/attachments");
		return new File(dir);
	}

	public void setAttachmentRootDirectory(File dir) {
		getConfiguration().setProperty("attachment.root.directory", dir.getAbsolutePath());
	}
	
	public boolean isPopUsingSslEnabled() {
		boolean value = getConfiguration().getBoolean("pop.ssl.enabled", false);
		return value;
	}

	public void setPopUsingSslEnabled(boolean requires) {
		getConfiguration().setProperty("pop.ssl.enabled", requires);
	}

	public boolean isPopCheckingEnabled() {
		boolean value = getConfiguration().getBoolean("pop.checking.enabled", false);
		return value;
	}

	public void setPopCheckingEnabled(boolean requires) {
		getConfiguration().setProperty("pop.checking.enabled", requires);
	}

	public String getEmailDomain() {
		String fromEmail = getFromEmailAddress();

		String result = "";
		if (fromEmail.indexOf('@') > -1) {
			result = fromEmail.substring(fromEmail.indexOf('@') + 1, fromEmail.length());
		}
		return result;
	}

	public String getCustomQueueMailHeader() {
		String value = getConfiguration().getString("custom.queue.mail.header", "Envelope-To:");
		return value;
	}

	public void setCustomQueueMailHeader(String header) {
		getConfiguration().setProperty("custom.queue.mail.header", header);
	}

	public boolean isCustomQueueMailHeaderEnabled() {
		boolean value = getConfiguration().getBoolean("custom.queue.mail.header.enabled", false);
		return value;
	}

	public void setCustomQueueMailHeaderEnabled(boolean enabled) {
		getConfiguration().setProperty("custom.queue.mail.header.enabled", BooleanUtils.toStringTrueFalse(enabled));
	}

	public String getMailInputStreamHost() {
		String value = getConfiguration().getString("mail.inputstream.host", "localhost");
		return value;
	}

	public void setMailInputStreamHost(String host) {
		getConfiguration().setProperty("mail.inputstream.host", host);
	}

	public int getMailInputStreamPort() {
		int value = getConfiguration().getInt("mail.inputstream.port", 2525);
		return value;
	}

	public void setMailInputStreamPort(int port) {
		getConfiguration().setProperty("mail.inputstream.port", port);
	}

	public int getMailInputStreamBacklog() {
		int value = getConfiguration().getInt("mail.inputstream.backlog", 10);
		return value;
	}

	public void setMailInputStreamBacklog(int backlog) {
		getConfiguration().setProperty("mail.inputstream.backlog", backlog);
	}

	public boolean isMailInputStreamServiceEnabled() {
		boolean value = getConfiguration().getBoolean("mail.inputstream.enabled", false);
		return value;
	}

	public void setMailInputStreamServiceEnabled(boolean enabled) {
		getConfiguration().setProperty("mail.inputstream.enabled", BooleanUtils.toStringTrueFalse(enabled));
	}

}
