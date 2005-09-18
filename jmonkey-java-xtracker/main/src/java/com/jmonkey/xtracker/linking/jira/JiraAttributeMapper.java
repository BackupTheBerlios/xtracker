package com.jmonkey.xtracker.linking.jira;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;

public class JiraAttributeMapper {
	public static String getJiraStatusId(Status status) {
		int jiraStatus = 3;
		Long id = status.getId();
		switch (id.intValue()) {
			case 2: // open
				jiraStatus = 1; // Open
			case 3: // Resolved
				jiraStatus = 5;// Resolved
			case 6: // rejected
			case 4: // Closed
				jiraStatus = 6;// Closed
		}
		return Integer.toString(jiraStatus);
	}

	public static String getJiraPriorityId(Severity severity) {
		int jiraPriority = 5;
		Long id = severity.getId();
		switch (id.intValue()) {
			case 4: // minor
				jiraPriority = 4;
				break;
			case 5: // major
				jiraPriority = 3;
				break;
			case 6: // crash
				jiraPriority = 2;
				break;
			case 7: // blocker
				jiraPriority = 1;
				break;
		}
		return Integer.toString(jiraPriority);

	}

	public static String getJiraIssueTypeId(Disposition disposition) {
		int jiraType = 6;
		Long id = disposition.getId();
		switch (id.intValue()) {
			case 3: // bug to jira bug
				jiraType = 1;
				break;
			case 4: // Feature Request to Jira New Feature
				jiraType = 2;
				break;
			case 2: // Action Request to Jira Task
				jiraType = 3;
				break;
		}
		return Integer.toString(jiraType);
	}
}
