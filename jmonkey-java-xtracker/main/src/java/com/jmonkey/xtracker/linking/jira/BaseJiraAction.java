package com.jmonkey.xtracker.linking.jira;

import javax.xml.rpc.ServiceException;

import org.apache.struts.action.Action;

import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.linking.jira.soap.JiraSoapService;
import com.jmonkey.xtracker.linking.jira.soap.JiraSoapServiceServiceLocator;
import com.jmonkey.xtracker.profile.Person;

public class BaseJiraAction extends Action {

	protected JiraSoapService getJiraService(LinkingConfig linkingConfig, Person person, PersonCipher personCipher) throws Exception, ServiceException {
		JiraSoapServiceServiceLocator locator = new JiraSoapServiceServiceLocator();
		// http://jira.codehaus.org
		locator.setServiceAddress(linkingConfig.getJiraContext() + "/rpc/soap/jirasoapservice-v2");
		locator.setUsername(person.getJiraUsername());
		String jiraPassword = person.getJiraPassword();
		if (jiraPassword != null) {
			locator.setPassword(personCipher.decrypt(jiraPassword));
		}
	
		JiraSoapService jira = locator.getJirasoapserviceV2();
		return jira;
	}

}
