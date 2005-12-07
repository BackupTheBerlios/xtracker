package com.jmonkey.xtracker.my.tickets;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.profile.Person;

public class TicketPeopleForm extends ActionForm {
	private Long				id					= null;
	private Person				requestor			= null;
	private List<Person>		ownerList			= null;
	private List<Person>		watcherList			= null;
	private List<Person>		allPeopleList		= null;
	private String				newOwnerId			= null;
	private String				newWatcherId		= null;
	private String[]			deletedOwners		= new String[0];
	private String[]			deletedWatchers		= new String[0];

	private Map<String, String>	ownerSource			= new TreeMap<String, String>();
	private String[]			selectedOwners		= new String[0];
	private String[]			selectedWatchers	= new String[0];

	public TicketPeopleForm() {
		super();
	}

	public Map<String, String> getOwnerSource() {
		return ownerSource;
	}

	public void setOwnerSource(Map<String, String> ownerMap) {
		this.ownerSource = ownerMap;
	}

	public String[] getSelectedWatchers() {
		return selectedWatchers;
	}

	public void setSelectedWatchers(String[] selectedWatchers) {
		this.selectedWatchers = selectedWatchers;
	}

	public String[] getSelectedOwners() {
		return selectedOwners;
	}

	public void setSelectedOwners(String[] selectedOwners) {
		this.selectedOwners = selectedOwners;
	}

	/**
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		deletedOwners = new String[0];
	}

	public List<Person> getAllPeopleList() {
		return allPeopleList;
	}

	public void setAllPeopleList(List<Person> allPeopleList) {
		this.allPeopleList = allPeopleList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewOwnerId() {
		return newOwnerId;
	}

	public void setNewOwnerId(String newOwnerId) {
		this.newOwnerId = newOwnerId;
	}

	public List<Person> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(List<Person> ownerList) {
		this.ownerList = ownerList;
	}

	public Person getRequestor() {
		return requestor;
	}

	public void setRequestor(Person requestor) {
		this.requestor = requestor;
	}

	public String[] getDeletedOwners() {
		return deletedOwners;
	}

	public void setDeletedOwners(String[] deletedOwners) {
		this.deletedOwners = deletedOwners;
	}

	public String[] getDeletedWatchers() {
		return deletedWatchers;
	}

	public void setDeletedWatchers(String[] deletedWatchers) {
		this.deletedWatchers = deletedWatchers;
	}

	public String getNewWatcherId() {
		return newWatcherId;
	}

	public void setNewWatcherId(String newWatcherId) {
		this.newWatcherId = newWatcherId;
	}

	public List<Person> getWatcherList() {
		return watcherList;
	}

	public void setWatcherList(List<Person> watcherList) {
		this.watcherList = watcherList;
	}

}
