/**
 * XPlannerSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.jmonkey.xtracker.linking.xplanner.soap;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;
import org.xplanner.soap.IterationData;
import org.xplanner.soap.NoteData;
import org.xplanner.soap.PersonData;
import org.xplanner.soap.ProjectData;
import org.xplanner.soap.TaskData;
import org.xplanner.soap.TimeEntryData;
import org.xplanner.soap.UserStoryData;

public class XPlannerSoapBindingStub extends org.apache.axis.client.Stub implements XPlanner {
	private Vector										cachedSerClasses		= new Vector();
	private Vector										cachedSerQNames			= new Vector();
	private Vector										cachedSerFactories		= new Vector();
	private Vector										cachedDeserFactories	= new Vector();

	static OperationDesc[]	operations;

	static {
		operations = new OperationDesc[43];
		_initOperationDesc1();
		_initOperationDesc2();
		_initOperationDesc3();
		_initOperationDesc4();
		_initOperationDesc5();
	}

	private static void _initOperationDesc1() {
		OperationDesc oper;
		oper = new OperationDesc();
		oper.setName("getAttributes");
		oper.addParameter(new QName("", "objectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xml.apache.org/xml-soap", "Map"));
		oper.setReturnClass(HashMap.class);
		oper.setReturnQName(new QName("", "getAttributesReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "TaskData"), TaskData.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "ProjectData"),
				ProjectData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "IterationData"),
				IterationData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "PersonData"), PersonData.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "note"), new QName("http://xplanner.org/soap", "NoteData"), NoteData.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[5] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "UserStoryData"),
				UserStoryData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[6] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("update");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "TimeEntryData"),
				TimeEntryData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[7] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getAttribute");
		oper.addParameter(new QName("", "objectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.addParameter(new QName("", "key"), new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
		oper.setReturnClass(String.class);
		oper.setReturnQName(new QName("", "getAttributeReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[8] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("setAttribute");
		oper.addParameter(new QName("", "objectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.addParameter(new QName("", "key"), new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class,
				ParameterDesc.IN, false, false);
		oper.addParameter(new QName("", "value"), new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[9] = oper;

	}

	private static void _initOperationDesc2() {
		org.apache.axis.description.OperationDesc oper;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getNote");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "NoteData"));
		oper.setReturnClass(NoteData.class);
		oper.setReturnQName(new QName("", "getNoteReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[10] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removeNote");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[11] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getPerson");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "PersonData"));
		oper.setReturnClass(PersonData.class);
		oper.setReturnQName(new QName("", "getPersonReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[12] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addTask");
		oper.addParameter(new QName("", "task"), new QName("http://xplanner.org/soap", "TaskData"), TaskData.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "TaskData"));
		oper.setReturnClass(TaskData.class);
		oper.setReturnQName(new QName("", "addTaskReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[13] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getIterations");
		oper.addParameter(new QName("", "projectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_IterationData"));
		oper.setReturnClass(IterationData[].class);
		oper.setReturnQName(new QName("", "getIterationsReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[14] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getUserStories");
		oper.addParameter(new QName("", "containerId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_UserStoryData"));
		oper.setReturnClass(UserStoryData[].class);
		oper.setReturnQName(new QName("", "getUserStoriesReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[15] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getTasks");
		oper.addParameter(new QName("", "containerId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_TaskData"));
		oper.setReturnClass(TaskData[].class);
		oper.setReturnQName(new QName("", "getTasksReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[16] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getTimeEntries");
		oper.addParameter(new QName("", "containerId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_TimeEntryData"));
		oper.setReturnClass(TimeEntryData[].class);
		oper.setReturnQName(new QName("", "getTimeEntriesReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[17] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getCurrentIteration");
		oper.addParameter(new QName("", "projectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "IterationData"));
		oper.setReturnClass(IterationData.class);
		oper.setReturnQName(new QName("", "getCurrentIterationReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[18] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getProject");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "ProjectData"));
		oper.setReturnClass(ProjectData.class);
		oper.setReturnQName(new QName("", "getProjectReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[19] = oper;

	}

	private static void _initOperationDesc3() {
		org.apache.axis.description.OperationDesc oper;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getTask");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "TaskData"));
		oper.setReturnClass(TaskData.class);
		oper.setReturnQName(new QName("", "getTaskReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[20] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getPeople");
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_PersonData"));
		oper.setReturnClass(PersonData[].class);
		oper.setReturnQName(new QName("", "getPeopleReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[21] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getProjects");
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_ProjectData"));
		oper.setReturnClass(ProjectData[].class);
		oper.setReturnQName(new QName("", "getProjectsReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[22] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addProject");
		oper.addParameter(new QName("", "project"), new QName("http://xplanner.org/soap", "ProjectData"),
				ProjectData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "ProjectData"));
		oper.setReturnClass(ProjectData.class);
		oper.setReturnQName(new QName("", "addProjectReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[23] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removeProject");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[24] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getIteration");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "IterationData"));
		oper.setReturnClass(IterationData.class);
		oper.setReturnQName(new QName("", "getIterationReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[25] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addIteration");
		oper.addParameter(new QName("", "iteration"), new QName("http://xplanner.org/soap", "IterationData"),
				IterationData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "IterationData"));
		oper.setReturnClass(IterationData.class);
		oper.setReturnQName(new QName("", "addIterationReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[26] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removeIteration");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[27] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getUserStory");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "UserStoryData"));
		oper.setReturnClass(UserStoryData.class);
		oper.setReturnQName(new QName("", "getUserStoryReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[28] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addUserStory");
		oper.addParameter(new QName("", "story"), new QName("http://xplanner.org/soap", "UserStoryData"),
				UserStoryData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "UserStoryData"));
		oper.setReturnClass(UserStoryData.class);
		oper.setReturnQName(new QName("", "addUserStoryReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[29] = oper;

	}

	private static void _initOperationDesc4() {
		org.apache.axis.description.OperationDesc oper;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removeUserStory");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[30] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getCurrentTasksForPerson");
		oper.addParameter(new QName("", "personId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_TaskData"));
		oper.setReturnClass(TaskData[].class);
		oper.setReturnQName(new QName("", "getCurrentTasksForPersonReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		oper.addFault(new org.apache.axis.description.FaultDesc(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "fault"),
				"com.technoetic.xplanner.db.QueryException", new QName("http://db.xplanner.technoetic.com", "QueryException"), true));
		operations[31] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getPlannedTasksForPerson");
		oper.addParameter(new QName("", "personId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_TaskData"));
		oper.setReturnClass(TaskData[].class);
		oper.setReturnQName(new QName("", "getPlannedTasksForPersonReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		oper.addFault(new org.apache.axis.description.FaultDesc(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "fault"),
				"com.technoetic.xplanner.db.QueryException", new QName("http://db.xplanner.technoetic.com", "QueryException"), true));
		operations[32] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removeTask");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[33] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getTimeEntry");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "TimeEntryData"));
		oper.setReturnClass(TimeEntryData.class);
		oper.setReturnQName(new QName("", "getTimeEntryReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[34] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addTimeEntry");
		oper.addParameter(new QName("", "timeEntry"), new QName("http://xplanner.org/soap", "TimeEntryData"),
				TimeEntryData.class, ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "TimeEntryData"));
		oper.setReturnClass(TimeEntryData.class);
		oper.setReturnQName(new QName("", "addTimeEntryReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[35] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removeTimeEntry");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[36] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addNote");
		oper.addParameter(new QName("", "note"), new QName("http://xplanner.org/soap", "NoteData"), NoteData.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "NoteData"));
		oper.setReturnClass(NoteData.class);
		oper.setReturnQName(new QName("", "addNoteReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[37] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getNotesForObject");
		oper.addParameter(new QName("", "attachedToId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_NoteData"));
		oper.setReturnClass(NoteData[].class);
		oper.setReturnQName(new QName("", "getNotesForObjectReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[38] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("addPerson");
		oper.addParameter(new QName("", "object"), new QName("http://xplanner.org/soap", "PersonData"), PersonData.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xplanner.org/soap", "PersonData"));
		oper.setReturnClass(PersonData.class);
		oper.setReturnQName(new QName("", "addPersonReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[39] = oper;

	}

	private static void _initOperationDesc5() {
		org.apache.axis.description.OperationDesc oper;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("removePerson");
		oper.addParameter(new QName("", "id"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[40] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("deleteAttribute");
		oper.addParameter(new QName("", "objectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.addParameter(new QName("", "key"), new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[41] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getAttributesWithPrefix");
		oper.addParameter(new QName("", "objectId"), new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class,
				ParameterDesc.IN, false, false);
		oper.addParameter(new QName("", "prefix"), new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"),
				String.class, ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://xml.apache.org/xml-soap", "Map"));
		oper.setReturnClass(HashMap.class);
		oper.setReturnQName(new QName("", "getAttributesWithPrefixReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[42] = oper;

	}

	public XPlannerSoapBindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public XPlannerSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public XPlannerSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		java.lang.Class cls;
		QName qName;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_PersonData");
		cachedSerQNames.add(qName);
		cls = PersonData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_TaskData");
		cachedSerQNames.add(qName);
		cls = TaskData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://xplanner.org/soap", "ProjectData");
		cachedSerQNames.add(qName);
		cls = ProjectData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://domain.soap.xplanner.technoetic.com", "DomainData");
		cachedSerQNames.add(qName);
		cls = com.technoetic.xplanner.soap.domain.DomainData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://xplanner.org/soap", "UserStoryData");
		cachedSerQNames.add(qName);
		cls = UserStoryData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://xplanner.org/soap", "PersonData");
		cachedSerQNames.add(qName);
		cls = PersonData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://xplanner.org/soap", "NoteData");
		cachedSerQNames.add(qName);
		cls = NoteData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://xplanner.org/soap", "TimeEntryData");
		cachedSerQNames.add(qName);
		cls = TimeEntryData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://xplanner.org/soap", "IterationData");
		cachedSerQNames.add(qName);
		cls = IterationData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_UserStoryData");
		cachedSerQNames.add(qName);
		cls = UserStoryData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_IterationData");
		cachedSerQNames.add(qName);
		cls = IterationData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://xml.apache.org/xml-soap", "mapItem");
		cachedSerQNames.add(qName);
		cls = org.apache.xml.xml_soap.MapItem.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_ProjectData");
		cachedSerQNames.add(qName);
		cls = ProjectData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://xplanner.org/soap", "TaskData");
		cachedSerQNames.add(qName);
		cls = TaskData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_NoteData");
		cachedSerQNames.add(qName);
		cls = NoteData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://dev.pappin.ca/xplanner-dev/soap/XPlanner", "ArrayOf_tns1_TimeEntryData");
		cachedSerQNames.add(qName);
		cls = TimeEntryData[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

		qName = new QName("http://db.xplanner.technoetic.com", "QueryException");
		cachedSerQNames.add(qName);
		cls = com.technoetic.xplanner.db.QueryException.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected Call createCall() throws RemoteException {
		try {
			Call _call = (Call) super.service.createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
					_call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
						QName qName = (QName) cachedSerQNames.get(i);
						java.lang.Class sf = (java.lang.Class) cachedSerFactories.get(i);
						java.lang.Class df = (java.lang.Class) cachedDeserFactories.get(i);
						_call.registerTypeMapping(cls, qName, sf, df, false);
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
		}
	}

	public HashMap getAttributes(int objectId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getAttributes"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(objectId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (HashMap) _resp;
			} catch (Exception _exception) {
				return (HashMap) JavaUtils.convert(_resp, HashMap.class);
			}
		}
	}

	public void update(TaskData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public void update(ProjectData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public void update(IterationData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[3]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public void update(PersonData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[4]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public void update(NoteData note) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[5]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { note });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public void update(UserStoryData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[6]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public void update(TimeEntryData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[7]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "update"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public String getAttribute(int objectId, String key) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[8]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getAttribute"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(objectId), key });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (String) _resp;
			} catch (Exception _exception) {
				return (String) JavaUtils.convert(_resp, String.class);
			}
		}
	}

	public void setAttribute(int objectId, String key, String value) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[9]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "setAttribute"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(objectId), key, value });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public NoteData getNote(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[10]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getNote"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (NoteData) _resp;
			} catch (Exception _exception) {
				return (NoteData) JavaUtils.convert(_resp, NoteData.class);
			}
		}
	}

	public void removeNote(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[11]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removeNote"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(_call);
	}

	public PersonData getPerson(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[12]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getPerson"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (PersonData) _resp;
			} catch (Exception _exception) {
				return (PersonData) JavaUtils.convert(_resp, PersonData.class);
			}
		}
	}

	public TaskData addTask(TaskData task) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[13]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addTask"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { task });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (TaskData) _resp;
			} catch (Exception _exception) {
				return (TaskData) JavaUtils.convert(_resp, TaskData.class);
			}
		}
	}

	public IterationData[] getIterations(int projectId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[14]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getIterations"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(projectId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (IterationData[]) _resp;
			} catch (Exception _exception) {
				return (IterationData[]) JavaUtils.convert(_resp, IterationData[].class);
			}
		}
	}

	public UserStoryData[] getUserStories(int containerId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[15]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getUserStories"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(containerId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (UserStoryData[]) _resp;
			} catch (Exception _exception) {
				return (UserStoryData[]) JavaUtils.convert(_resp, UserStoryData[].class);
			}
		}
	}

	public TaskData[] getTasks(int containerId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[16]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getTasks"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(containerId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (TaskData[]) _resp;
			} catch (Exception _exception) {
				return (TaskData[]) JavaUtils.convert(_resp, TaskData[].class);
			}
		}
	}

	public TimeEntryData[] getTimeEntries(int containerId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[17]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getTimeEntries"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(containerId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (TimeEntryData[]) _resp;
			} catch (Exception _exception) {
				return (TimeEntryData[]) JavaUtils.convert(_resp, TimeEntryData[].class);
			}
		}
	}

	public IterationData getCurrentIteration(int projectId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(operations[18]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getCurrentIteration"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { new Integer(projectId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (IterationData) _resp;
			} catch (Exception _exception) {
				return (IterationData) JavaUtils.convert(_resp, IterationData.class);
			}
		}
	}

	public ProjectData getProject(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[19]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getProject"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (ProjectData) _resp;
			} catch (Exception _exception) {
				return (ProjectData) JavaUtils.convert(_resp, ProjectData.class);
			}
		}
	}

	public TaskData getTask(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[20]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getTask"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (TaskData) _resp;
			} catch (Exception _exception) {
				return (TaskData) JavaUtils.convert(_resp, TaskData.class);
			}
		}
	}

	public PersonData[] getPeople() throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[21]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getPeople"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] {});

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (PersonData[]) _resp;
			} catch (Exception _exception) {
				return (PersonData[]) JavaUtils.convert(_resp, PersonData[].class);
			}
		}
	}

	public ProjectData[] getProjects() throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[22]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getProjects"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] {});

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (ProjectData[]) _resp;
			} catch (Exception _exception) {
				return (ProjectData[]) JavaUtils.convert(_resp, ProjectData[].class);
			}
		}
	}

	public ProjectData addProject(ProjectData project) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[23]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addProject"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { project });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (ProjectData) _resp;
			} catch (Exception _exception) {
				return (ProjectData) JavaUtils.convert(_resp, ProjectData.class);
			}
		}
	}

	public void removeProject(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[24]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removeProject"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public IterationData getIteration(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[25]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getIteration"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (IterationData) _resp;
			} catch (Exception _exception) {
				return (IterationData) JavaUtils.convert(_resp, IterationData.class);
			}
		}
	}

	public IterationData addIteration(IterationData iteration) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[26]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addIteration"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { iteration });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (IterationData) _resp;
			} catch (Exception _exception) {
				return (IterationData) JavaUtils.convert(_resp, IterationData.class);
			}
		}
	}

	public void removeIteration(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[27]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removeIteration"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public UserStoryData getUserStory(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[28]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getUserStory"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (UserStoryData) _resp;
			} catch (Exception _exception) {
				return (UserStoryData) JavaUtils.convert(_resp, UserStoryData.class);
			}
		}
	}

	public UserStoryData addUserStory(UserStoryData story) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[29]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addUserStory"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { story });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (UserStoryData) _resp;
			} catch (Exception _exception) {
				return (UserStoryData) JavaUtils.convert(_resp, UserStoryData.class);
			}
		}
	}

	public void removeUserStory(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[30]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removeUserStory"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public TaskData[] getCurrentTasksForPerson(int personId) throws RemoteException, com.technoetic.xplanner.db.QueryException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[31]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getCurrentTasksForPerson"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(personId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (TaskData[]) _resp;
			} catch (Exception _exception) {
				return (TaskData[]) JavaUtils.convert(_resp, TaskData[].class);
			}
		}
	}

	public TaskData[] getPlannedTasksForPerson(int personId) throws RemoteException, com.technoetic.xplanner.db.QueryException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[32]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getPlannedTasksForPerson"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(personId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (TaskData[]) _resp;
			} catch (Exception _exception) {
				return (TaskData[]) JavaUtils.convert(_resp, TaskData[].class);
			}
		}
	}

	public void removeTask(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[33]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removeTask"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public TimeEntryData getTimeEntry(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[34]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getTimeEntry"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (TimeEntryData) _resp;
			} catch (Exception _exception) {
				return (TimeEntryData) JavaUtils.convert(_resp, TimeEntryData.class);
			}
		}
	}

	public TimeEntryData addTimeEntry(TimeEntryData timeEntry) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[35]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addTimeEntry"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { timeEntry });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (TimeEntryData) _resp;
			} catch (Exception _exception) {
				return (TimeEntryData) JavaUtils.convert(_resp, TimeEntryData.class);
			}
		}
	}

	public void removeTimeEntry(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[36]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removeTimeEntry"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public NoteData addNote(NoteData note) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[37]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addNote"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { note });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (NoteData) _resp;
			} catch (Exception _exception) {
				return (NoteData) JavaUtils.convert(_resp, NoteData.class);
			}
		}
	}

	public NoteData[] getNotesForObject(int attachedToId) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[38]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getNotesForObject"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(attachedToId) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (NoteData[]) _resp;
			} catch (Exception _exception) {
				return (NoteData[]) JavaUtils.convert(_resp, NoteData[].class);
			}
		}
	}

	public PersonData addPerson(PersonData object) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[39]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "addPerson"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { object });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (PersonData) _resp;
			} catch (Exception _exception) {
				return (PersonData) JavaUtils.convert(_resp, PersonData.class);
			}
		}
	}

	public void removePerson(int id) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[40]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "removePerson"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(id) });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public void deleteAttribute(int objectId, String key) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[41]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "deleteAttribute"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(objectId), key });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		}
		extractAttachments(call);
	}

	public HashMap getAttributesWithPrefix(int objectId, String prefix) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call call = createCall();
		call.setOperation(operations[42]);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("");
		call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		call.setOperationName(new QName("http://soap.xplanner.technoetic.com", "getAttributesWithPrefix"));

		setRequestHeaders(call);
		setAttachments(call);
		Object _resp = call.invoke(new Object[] { new Integer(objectId), prefix });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(call);
			try {
				return (HashMap) _resp;
			} catch (Exception _exception) {
				return (HashMap) JavaUtils.convert(_resp, HashMap.class);
			}
		}
	}

}
