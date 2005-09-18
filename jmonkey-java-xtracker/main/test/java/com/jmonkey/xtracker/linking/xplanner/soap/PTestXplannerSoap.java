package com.jmonkey.xtracker.linking.xplanner.soap;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import junit.framework.TestCase;

import org.xplanner.soap.PersonData;
import org.xplanner.soap.ProjectData;

import com.jmonkey.xtracker.linking.xplanner.soap.XPlanner;
import com.jmonkey.xtracker.linking.xplanner.soap.XPlannerServiceLocator;

public class PTestXplannerSoap extends TestCase {
	private XPlannerServiceLocator	serviceLocator	= null;

	public void testCanGetProjectList() throws ServiceException, RemoteException {
		XPlanner xplanner = serviceLocator.getXPlanner();
		ProjectData[] projectData = xplanner.getProjects();
		assertNotNull(projectData);
		for (ProjectData data : projectData) {
			System.out.println("[" + data.getId() + "] " + data.getName());
		}
	}

	public void testCanGetPeopleList() throws ServiceException, RemoteException {
		XPlanner xplanner = serviceLocator.getXPlanner();
		PersonData[] personData = xplanner.getPeople();
		assertNotNull(personData);
		for (PersonData data : personData) {
			System.out.println("[" + data.getId() + "] " + data.getUserId());
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		serviceLocator = new XPlannerServiceLocator();
		serviceLocator.setUsername("");
		serviceLocator.setPassword("");
		serviceLocator.setXPlannerAddress("http://dev.pappin.ca/xplanner-dev/soap/XPlanner");
	}

	@Override
	protected void tearDown() throws Exception {
		serviceLocator = null;
		super.tearDown();
	}

}
