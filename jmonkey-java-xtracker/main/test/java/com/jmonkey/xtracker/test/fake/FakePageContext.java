package com.jmonkey.xtracker.test.fake;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.VariableResolver;


public class FakePageContext extends PageContext {
	private FakeHttpServletRequest	fakeHttpServletRequest	= null;
	private FakeServletContext		fakeServletContext		= null;
	private FakeJspWriter			fakeJspWriter			= null;
	private Map<String, Object>		attributes				= new HashMap<String, Object>();

	public FakePageContext() {
		super();
	}

	public void setFakeJspWriter(FakeJspWriter fakeJspWriter) {
		this.fakeJspWriter = fakeJspWriter;
	}

	public void setFakeServletContext(FakeServletContext fakeServletContext) {
		this.fakeServletContext = fakeServletContext;
	}

	public void setFakeHttpServletRequest(FakeHttpServletRequest fakeHttpServletRequest) {
		this.fakeHttpServletRequest = fakeHttpServletRequest;
	}

	public void addTestAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	@Override
	public void initialize(Servlet arg0, ServletRequest arg1, ServletResponse arg2, String arg3, boolean arg4, int arg5, boolean arg6) throws IOException, IllegalStateException, IllegalArgumentException {
	}

	@Override
	public void release() {
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		attributes.put(arg0, arg1);
	}

	@Override
	public void setAttribute(String arg0, Object arg1, int arg2) {
		attributes.put(arg0, arg1);
	}

	@Override
	public Object getAttribute(String arg0) {
		return attributes.get(arg0);
	}

	@Override
	public Object getAttribute(String arg0, int arg1) {
		return attributes.get(arg0);
	}

	@Override
	public Object findAttribute(String arg0) {
		return attributes.get(arg0);
	}

	@Override
	public void removeAttribute(String arg0) {
		attributes.remove(arg0);
	}

	@Override
	public void removeAttribute(String arg0, int arg1) {
		attributes.remove(arg0);
	}

	@Override
	public int getAttributesScope(String arg0) {
		return 0;
	}

	@Override
	public Enumeration getAttributeNamesInScope(int arg0) {
		return null;
	}

	@Override
	public JspWriter getOut() {
		return fakeJspWriter;
	}

	@Override
	public HttpSession getSession() {
		return null;
	}

	@Override
	public Object getPage() {
		return null;
	}

	@Override
	public ServletRequest getRequest() {
		return fakeHttpServletRequest;
	}

	@Override
	public ServletResponse getResponse() {
		return null;
	}

	@Override
	public Exception getException() {
		return null;
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public ServletContext getServletContext() {
		return fakeServletContext;
	}

	@Override
	public void forward(String arg0) throws ServletException, IOException {
	}

	@Override
	public void include(String arg0) throws ServletException, IOException {
	}

	@Override
	public void handlePageException(Exception arg0) throws ServletException, IOException {
	}

	@Override
	public void handlePageException(Throwable arg0) throws ServletException, IOException {
	}

	@Override
	public void include(String arg0, boolean arg1) throws ServletException, IOException {
	}

	@Override
	public ExpressionEvaluator getExpressionEvaluator() {
		return null;
	}

	@Override
	public VariableResolver getVariableResolver() {
		return null;
	}

}
