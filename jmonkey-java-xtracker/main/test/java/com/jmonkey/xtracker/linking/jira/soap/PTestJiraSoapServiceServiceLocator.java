package com.jmonkey.xtracker.linking.jira.soap;

import javax.xml.rpc.ServiceException;

import junit.framework.TestCase;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import com.atlassian.jira.rpc.exception.RemoteException;
import com.atlassian.jira.rpc.exception.RemotePermissionException;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;

public class PTestJiraSoapServiceServiceLocator extends TestCase {
	private JiraSoapServiceServiceLocator	locator	= null;

	public void testService() throws ServiceException, RemotePermissionException, RemoteAuthenticationException, RemoteException, java.rmi.RemoteException {
		JiraSoapService service = locator.getJirasoapserviceV2();
		String token = service.login("brill", "<your password>");
		// RemoteProject[] projects = service.getProjects(token);
		// for (RemoteProject project : projects) {
		// System.out.println(project.getId() + " :: " + project.getKey() + " ::
		// " + project.getName()+" :: "+project.getDescription());
		//
		// }

		RemoteVersion[] versions = service.getVersions(token, "TP");
		for (RemoteVersion version : versions) {
			System.out.println(version.getId() + " :: " + version.getName() + " :: " + version.getReleaseDate() + " :: " + version.getSequence());
		}
		// RemoteUser user = service.getUser(token, "brill");
		// System.out.println(user.getName() + " :: " + user.getFullname() + "
		// :: " + user.getEmail());

		// RemoteIssue issue = service.getIssue(token, "TP-1");
		// System.out.println(issue.getKey() + " :: " + issue.getSummary());

		// RemoteProject[] elements = service.getProjects(token);
		// for (RemoteProject project : elements) {
		// System.out.println(project.getId() + " :: " + project.getName());
		// }

		// RemoteStatus[] elements = service.getStatuses(token);
		// for (RemoteStatus status : elements) {
		// System.out.println(status.getId() + " :: " + status.getName());
		// }

		// RemotePriority[] elements = service.getPriorities(token);
		// for (RemotePriority element : elements) {
		// System.out.println(element.getIcon() + " :: " + element.getColor() +
		// " :: " +element.getId()+ " :: " + element.getName() + " :: " +
		// element.getDescription());
		// }

		// RemoteIssueType[] types1 = service.getIssueTypes(token);
		// for (RemoteIssueType type : types1) {
		// String typeStr = type.getIcon() + " :: " + type.getId() + " :: " +
		// type.getName() + " :: " + type.getDescription();
		// System.out.println(typeStr);
		// }

		// RemoteIssue issue = service.getIssue(token, "XPR-75");
		// if(issue != null) {
		// System.out.println(issue.getId() + " :: " + issue.getKey() + " :: " +
		// issue.getStatus() + " :: " + issue.getType());
		// }else {
		// System.out.println("null");
		// }
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		locator = new JiraSoapServiceServiceLocator();
		locator.setServiceAddress("http://localhost:8888/rpc/soap/jirasoapservice-v2");
	}

	@Override
	protected void tearDown() throws Exception {
		locator = null;
		super.tearDown();
	}

}
