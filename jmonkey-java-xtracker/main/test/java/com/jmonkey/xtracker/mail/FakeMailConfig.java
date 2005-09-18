package com.jmonkey.xtracker.mail;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.configuration.Configuration;

import com.jmonkey.xtracker.config.ConfigException;

public class FakeMailConfig extends MailConfig {
	private String	emailDomain	= null;

	public FakeMailConfig() {
		return;
	}

	public FakeMailConfig(boolean autoReload) {
		return;
	}

	public FakeMailConfig(File root, boolean autoReload) {
		return;
	}

	@Override
	public File getAttachmentRootDirectory() {
		return null;
	}

	@Override
	public String getCustomQueueMailHeader() {
		return null;
	}

	@Override
	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String domain) {
		this.emailDomain = domain;
	}

	@Override
	public String getFromEmailAddress() {
		return null;
	}

	@Override
	public String getPopCheckCronExpression() {
		return null;
	}

	@Override
	public String getPopHostPassword() {
		return null;
	}

	@Override
	public String getPopHostUsername() {
		return null;
	}

	@Override
	public String getPopMailHost() {
		return null;
	}

	@Override
	public String getSmtpHostPassword() {
		return null;
	}

	@Override
	public String getSmtpHostUsername() {
		return null;
	}

	@Override
	public String getSmtpMailHost() {
		return null;
	}

	@Override
	public boolean isCustomQueueMailHeaderEnabled() {
		return false;
	}

	@Override
	public boolean isPopCheckingEnabled() {
		return false;
	}

	@Override
	public boolean isSmtpHostRequiresPassword() {
		return false;
	}

	@Override
	public void setAttachmentRootDirectory(File dir) {
		return;
	}

	@Override
	public void setCustomQueueMailHeader(String header) {
		return;
	}

	@Override
	public void setCustomQueueMailHeaderEnabled(boolean enabled) {
		return;
	}

	@Override
	public void setFromEmailAddress(String address) {
		return;
	}

	@Override
	public void setPopCheckCronExpression(String expression) {
		return;
	}

	@Override
	public void setPopCheckingEnabled(boolean requires) {
		return;
	}

	@Override
	public void setPopHostPassword(String password) {
		return;
	}

	@Override
	public void setPopHostUsername(String username) {
		return;
	}

	@Override
	public void setPopMailHost(String host) {
		return;
	}

	@Override
	public void setSmtpHostPassword(String password) {
		return;
	}

	@Override
	public void setSmtpHostRequiresPassword(boolean requires) {
		return;
	}

	@Override
	public void setSmtpHostUsername(String username) {
		return;
	}

	@Override
	public void setSmtpMailHost(String host) {
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public void writeNewConfigDefaults(File file) throws ConfigException {
		return;
	}

	@Override
	public Configuration getConfiguration() {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public Iterator getKeys() throws ConfigException {
		return null;
	}

	@Override
	public File getRoot() {
		return null;
	}

	@Override
	public boolean isReloadEnabled() {
		return false;
	}

	@Override
	public boolean isTransient() {
		return false;
	}

	@SuppressWarnings("unused")
	@Override
	public void load() throws ConfigException {
		return;
	}

	@Override
	public void setReloadEnabled(boolean reloadEnabled) {
		return;
	}

	@Override
	public void setTransient(boolean trans) {
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public void store() throws ConfigException {
		return;
	}

}
