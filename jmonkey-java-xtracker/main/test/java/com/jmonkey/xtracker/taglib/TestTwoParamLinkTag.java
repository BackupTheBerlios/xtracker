package com.jmonkey.xtracker.taglib;

import javax.servlet.jsp.JspException;

import com.jmonkey.xtracker.test.fake.FakeHttpServletRequest;
import com.jmonkey.xtracker.test.fake.FakeJspWriter;
import com.jmonkey.xtracker.test.fake.FakePageContext;
import com.jmonkey.xtracker.test.fake.FakeServletContext;

import junit.framework.TestCase;

public class TestTwoParamLinkTag extends TestCase {
	private String					testProperty			= null;
	private FakeHttpServletRequest	fakeHttpServletRequest	= null;
	private FakeServletContext		fakeServletContext		= null;
	private FakeJspWriter			fakeJspWriter			= null;
	private FakePageContext			fakePageContext			= null;
	private TwoParamLinkTag			tag						= null;

	public void testLinkTagWorksAsOriginalyIntended() throws JspException {
		testProperty = "123456";
		tag.setParamId("id");
		tag.setParamName("test");
		tag.setParamProperty("testProperty");
		executeTag();

		String result = fakeJspWriter.getTestWriter().toString();
		assertNotNull(result);
		assertEquals("<a href=\"/test/href?id=123456\"></a>", result);
	}

	public void testLinkTagWorksWithNewParams() throws JspException {
		testProperty = "123456";
		tag.setParam1Id("id");
		tag.setParam1Name("test");
		tag.setParam1Property("testProperty");
		executeTag();

		String result = fakeJspWriter.getTestWriter().toString();
		assertNotNull(result);
		assertEquals("<a href=\"/test/href?id=123456\"></a>", result);
	}
	
	public void testLinkTagAppendsBothParams() throws JspException {
		testProperty = "123456";
		tag.setParamId("id1");
		tag.setParamName("test");
		tag.setParamProperty("testProperty");
		tag.setParam1Id("id2");
		tag.setParam1Name("test");
		tag.setParam1Property("testProperty");
		executeTag();

		String result = fakeJspWriter.getTestWriter().toString();
		assertNotNull(result);
		assertEquals("<a href=\"/test/href?id1=123456&amp;id2=123456\"></a>", result);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		fakeHttpServletRequest = new FakeHttpServletRequest();
		fakeServletContext = new FakeServletContext();
		fakeJspWriter = new FakeJspWriter();
		fakePageContext = new FakePageContext();
		fakePageContext.setFakeJspWriter(fakeJspWriter);
		fakePageContext.addTestAttribute("test", this);
		fakePageContext.setFakeServletContext(fakeServletContext);
		fakePageContext.setFakeHttpServletRequest(fakeHttpServletRequest);
		tag = new TwoParamLinkTag();
		tag.setPageContext(fakePageContext);
	}

	@Override
	protected void tearDown() throws Exception {
		tag.release();
		tag = null;
		fakePageContext.release();
		fakePageContext = null;
		fakeJspWriter.close();
		fakeJspWriter = null;
		fakeServletContext = null;
		fakeHttpServletRequest = null;
		super.tearDown();
	}

	private void executeTag() throws JspException {
		tag.setHref("/test/href");
		tag.doStartTag();
		tag.doInitBody();
		tag.doAfterBody();
		tag.doEndTag();
	}

	public String getTestProperty() {
		return testProperty;
	}

	public void setTestProperty(String testProperty) {
		this.testProperty = testProperty;
	}

}
