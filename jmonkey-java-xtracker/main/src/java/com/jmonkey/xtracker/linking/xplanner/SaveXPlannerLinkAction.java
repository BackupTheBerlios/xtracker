package com.jmonkey.xtracker.linking.xplanner;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.xplanner.soap.NoteData;
import org.xplanner.soap.PersonData;
import org.xplanner.soap.UserStoryData;

import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.linking.xplanner.soap.XPlanner;
import com.jmonkey.xtracker.linking.xplanner.soap.XPlannerServiceLocator;
import com.jmonkey.xtracker.my.tickets.ActionForwardFactory;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveXPlannerLinkAction extends Action {
	private Logger	logger	= LogManager.getLogger(SaveXPlannerLinkAction.class);

	public SaveXPlannerLinkAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Save called...");
		try {
			XPlannerLinkForm xPlannerLinkForm = (XPlannerLinkForm) form;

			logger.debug("getting environment...");
			AuthEnvironment authEnvironment = new AuthEnvironment(request);
			logger.debug("getting linking configuration...");
			LinkingConfig linkingConfig = new LinkingConfig();

			Long ticketId = xPlannerLinkForm.getTicketId();

			logger.debug("loading authenticated person...");
			PersonLoader personLoader = new PersonLoader();
			Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

			Calendar today = Calendar.getInstance();

			logger.debug("loading the ticket...");
			TicketPersistor ticketPersistor = new TicketPersistor();
			TicketLoader ticketLoader = new TicketLoader();
			Ticket ticket = ticketLoader.loadTicket(ticketId);

			logger.debug("generating xplanner story from ticket...");
			UserStoryData story = createUserStoryData(xPlannerLinkForm, person, today, ticket);

			logger.debug("connecting to XPlanner...");
			XPlanner xplanner = getRemoteXPlanner(linkingConfig, person);

			logger.debug("searching for an xplanner person that matchs the local person...");
			PersonData xplannerPerson = searchForXPlannerPerson(person, xplanner);

			logger.debug("saving the ticket as a story...");
			UserStoryData savedStory = xplanner.addUserStory(story);

			logger.debug("adding a link from the story to the ticket...");
			addLinkToTicket(today, ticketPersistor, ticket, person, savedStory);

			logger.debug("generating note data for the story...");
			List<NoteData> noteDataList = getNoteDataList(today, ticket, savedStory, xplannerPerson);
			logger.debug("saving note data to the story...");
			for (NoteData note : noteDataList) {
				xplanner.addNote(note);
			}

			// XXX How do we deal with a task entry when we don't have a task?
			// Double worked = ticket.getWorked();
			// if (worked != null && worked > 0) {
			// TimeEntryData timeEntry = new TimeEntryData();
			// timeEntry.setDuration(worked);
			// timeEntry.setTaskId(???);
			// xplanner.addTimeEntry(timeEntry);
			// // story.setActualHours(worked.doubleValue());
			// }

			logger.debug("sending the user back tot he ticket...");

			ActionForwardFactory forwardFactory = new ActionForwardFactory();
			return forwardFactory.getOpenTicketForward(ticketId);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private PersonData searchForXPlannerPerson(Person person, XPlanner xplanner) throws RemoteException {
		PersonData xplannerPerson = null;
		PersonData[] xplannerPeople = xplanner.getPeople();
		for (PersonData personData : xplannerPeople) {
			if (personData.getUserId().equals(person.getXplannerUsername())) {
				xplannerPerson = personData;
				break;
			}
		}
		return xplannerPerson;
	}

	private List<NoteData> getNoteDataList(Calendar today, Ticket ticket, UserStoryData savedStory, PersonData xplannerPerson) {
		List<NoteData> noteDataList = new ArrayList<NoteData>();
		List<History> historyList = ticket.getHistory();
		for (History history : historyList) {
			if (!history.isSystem()) {
				NoteData noteData = new NoteData();
				noteData.setAttachedToId(savedStory.getId());
				String noteSubject = history.getSubject();
				if (noteSubject == null) {
					noteSubject = "[No Subject]";
				}
				noteData.setSubject(noteSubject);

				String bodyContent = history.getContent();
				if (bodyContent == null) {
					bodyContent = "[No Content]";
				}
				noteData.setBody(bodyContent);

				noteData.setLastUpdateTime(today);
				Calendar submissionTime = Calendar.getInstance();
				submissionTime.setTime(history.getCreateDate());
				noteData.setSubmissionTime(today);

				if (xplannerPerson != null) {
					// XXX Can't know for sure who the author is.
					noteData.setAuthorId(xplannerPerson.getId());
				}

				noteDataList.add(noteData);
			}
		}
		return noteDataList;
	}

	private XPlanner getRemoteXPlanner(LinkingConfig linkingConfig, Person person) throws Exception {
		XPlannerServiceLocator serviceLocator = new XPlannerServiceLocator();
		serviceLocator.setXPlannerAddress(linkingConfig.getXplannerContext() + "/soap/XPlanner");
		serviceLocator.setUsername(person.getXplannerUsername());

		PersonCipher personCipher = new PersonCipher();
		personCipher.setUsername(person.getUsername());
		personCipher.setPassword(person.getPassword());
		String xppasswd = person.getXplannerPassword();
		if (xppasswd != null) {
			serviceLocator.setPassword(personCipher.decrypt(person.getXplannerPassword()));
		}
		XPlanner xplanner = serviceLocator.getXPlanner();
		return xplanner;
	}

	private void addLinkToTicket(Calendar today, TicketPersistor ticketPersistor, Ticket ticket, Person person, UserStoryData savedStory) throws HibernateException {
		XPlannerLink xplannerLink = new XPlannerLink();
		xplannerLink.setCreated(today.getTime());
		xplannerLink.setUpdated(today.getTime());
		xplannerLink.setOid(new Integer(savedStory.getId()));
		xplannerLink.setName(savedStory.getName());
		xplannerLink.setCreator(person);
		ticket.setXplannerLink(xplannerLink);
		ticketPersistor.updateTicket(ticket);
	}

	private UserStoryData createUserStoryData(XPlannerLinkForm xPlannerLinkForm, Person person, Calendar today, Ticket ticket) {
		logger.debug("loading form data...");
		String subject = xPlannerLinkForm.getSubject();
		// Long ticketId = xPlannerLinkForm.getTicketId();
		Long iterationId = xPlannerLinkForm.getIterationOid();
		String xPlannerDisposition = xPlannerLinkForm.getXplannerDisposition();
		String xplannerDescription = xPlannerLinkForm.getContent();

		logger.debug("loading ticket data...");
		Integer priority = ticket.getPriority();

		logger.debug("filling in story data...");
		UserStoryData story = new UserStoryData();
		story.setIterationId(iterationId.intValue());
		story.setName(subject);
		story.setPriority(priority.intValue());
		story.setDispositionName(xPlannerDisposition);
		story.setLastUpdateTime(today);

		logger.debug("adding comments to story...");
		story.setDescription(xplannerDescription);

		return story;
	}
}
