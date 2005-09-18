package com.jmonkey.xtracker.util;

import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.mail.MailConfig;

public class QueueUtil {
	public static String getQueueEmailAddress(MailConfig config, Queue queue) {
		String emailDomain = config.getEmailDomain();
		if (!emailDomain.startsWith("@")) {
			emailDomain = "@" + emailDomain;
		}
		return queue.getEmailAlias() + emailDomain;
	}
}
