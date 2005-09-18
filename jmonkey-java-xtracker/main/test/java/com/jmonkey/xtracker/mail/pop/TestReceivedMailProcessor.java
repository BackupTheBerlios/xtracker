package com.jmonkey.xtracker.mail.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.auth.RandomPasswordGenerator;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.fake.issue.FakeDispositionLoader;
import com.jmonkey.xtracker.test.fake.issue.FakeQueueLoader;
import com.jmonkey.xtracker.test.fake.issue.FakeSeverityLoader;
import com.jmonkey.xtracker.test.fake.issue.FakeStatusLoader;
import com.jmonkey.xtracker.test.fake.issue.FakeTicketLoader;
import com.jmonkey.xtracker.test.fake.issue.FakeTicketPersistor;
import com.jmonkey.xtracker.test.fake.mail.FakeSMTPMailSender;
import com.jmonkey.xtracker.test.fake.profile.FakePersonLoader;
import com.jmonkey.xtracker.test.fake.profile.FakePersonPersistor;

public class TestReceivedMailProcessor extends BaseHibernateTestCase {
	private FakePersonLoader		fakePersonLoader		= null;
	private FakeTicketLoader		fakeTicketLoader		= null;
	private FakeTicketPersistor		fakeTicketPersistor		= null;
	private FakePersonPersistor		fakePersonPersistor		= null;
	private FakeStatusLoader		fakeStatusLoader		= null;
	private FakeSeverityLoader		fakeSeverityLoader		= null;
	private FakeQueueLoader			fakeQueueLoader			= null;
	private FakeDispositionLoader	fakeDispositionLoader	= null;
	private RandomPasswordGenerator	passwordGenerator		= null;
	private Person					testPerson				= null;
	private FakeSMTPMailSender		fakeMailSender			= null;
	private ReceivedMailProcessor	processor				= null;

	public void testMailWithNoTicketIdIsStored() throws Exception {
		Long expectedId = new Long(555999);
		fakeTicketPersistor.setNewTestId(expectedId);
		MimeMessage mimeMessage = setupNewMimeMessage();
		ReceivedMailMessage mail = new ReceivedMailMessage(mimeMessage);
		mail.processMessage();
		processor.processMail(mail);

		Ticket savedTicket = fakeTicketPersistor.getSavedTicket();
		assertNotNull(savedTicket);
		assertEquals(expectedId, savedTicket.getId());
		assertEquals(1, savedTicket.getHistory().size());
		History savedHistory = savedTicket.getHistory().get(0);
		assertEquals("This is a test subject", savedHistory.getSubject());
		assertEquals("This is a test message...", savedHistory.getContent());
		Person author = savedHistory.getAuthor();
		assertNotNull(author);
		Person savedPerson = fakePersonPersistor.getSavedPerson();
		assertNotNull(savedPerson);
		assertEquals("~JD", savedPerson.getInitials());
		assertEquals(author.getUsername(), savedPerson.getUsername());
	}

	public void testMailWithTicketIdIsStoredinExistingTicket() throws Exception {
		Status open = new Status();
		fakeStatusLoader.setupStatusToReturn(open);
		
		// Long expectedId = new Long(555999);
		// fakeTicketPersistor.setNewTestId(expectedId);
		MimeMessage mimeMessage = setupReplyMimeMessage();
		ReceivedMailMessage mail = new ReceivedMailMessage(mimeMessage);
		// mail.processMessage();
		processor.processMail(mail);

		Ticket updatedTicket = fakeTicketPersistor.getUpdatedTicket();
		assertNotNull(updatedTicket);
		assertEquals(new Long(123), updatedTicket.getId());
		assertEquals(1, updatedTicket.getHistory().size());
		History savedHistory = updatedTicket.getHistory().get(0);
		assertEquals("Re: [XTracker 123] This is a test message...", savedHistory.getSubject());
		assertEquals("This is a test message...", savedHistory.getContent());
		Person author = savedHistory.getAuthor();
		assertNotNull(author);
		Person savedPerson = fakePersonPersistor.getSavedPerson();
		assertNotNull(savedPerson);
		assertEquals("~JD", savedPerson.getInitials());
		assertEquals(author.getUsername(), savedPerson.getUsername());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		fakeMailSender = new FakeSMTPMailSender();
		setupFakeLoadersAndPersistors();

		Queue testQueue = new Queue();
		testQueue.setActive(true);
		testQueue.setEmailAlias("test");
		testQueue.setName("test");
		testQueue.setSelectable(true);
		testQueue.setManager(testPerson);
		fakeQueueLoader.setTestQueueToLoad(testQueue);
		setupProcessor();
		passwordGenerator = new RandomPasswordGenerator();
		processor.setPasswordGenerator(passwordGenerator);
		processor.setMailSender(fakeMailSender);
	}

	private void setupProcessor() {
		processor = new ReceivedMailProcessor();
		processor.setPersonLoader(fakePersonLoader);
		processor.setTicketLoader(fakeTicketLoader);
		processor.setTicketPersistor(fakeTicketPersistor);
		processor.setPersonPersistor(fakePersonPersistor);
		processor.setStatusLoader(fakeStatusLoader);
		processor.setDispositionLoader(fakeDispositionLoader);
		processor.setQueueLoader(fakeQueueLoader);
		processor.setSeverityLoader(fakeSeverityLoader);
		processor.setDefaultPriority(new Integer(50));
		processor.setMailSender(new FakeSMTPMailSender());
	}

	private void setupFakeLoadersAndPersistors() {
		fakeStatusLoader = new FakeStatusLoader();
		
		
		fakeSeverityLoader = new FakeSeverityLoader();
		fakeQueueLoader = new FakeQueueLoader();
		fakeDispositionLoader = new FakeDispositionLoader();

		fakePersonLoader = new FakePersonLoader();
		testPerson = new Person();
		testPerson.setId("asdcde");
		testPerson.setActive(true);
		testPerson.setInitials("TP");
		testPerson.setEmailAddress("test@example.com");
		fakePersonLoader.setupPersonToReturn(testPerson);
		fakePersonPersistor = new FakePersonPersistor();

		fakeTicketLoader = new FakeTicketLoader();
		Ticket testTicket = new Ticket();
		testTicket.setId(new Long(123));
		Status status = new Status();
		status.setId(1);
		testTicket.setStatus(status);
		fakeTicketLoader.setupTicketToReturn(testTicket);

		fakeTicketPersistor = new FakeTicketPersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		processor = null;
		fakePersonLoader = null;
		fakeTicketLoader = null;
		super.tearDown();
	}

	private MimeMessage setupReplyMimeMessage() throws MessagingException, FileNotFoundException {
		File testSource = new File("main/etc/test/reply-ticket-text-plain-message.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}

	private MimeMessage setupNewMimeMessage() throws MessagingException, FileNotFoundException {
		File testSource = new File("main/etc/test/text-plain-mime-message.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}
}
