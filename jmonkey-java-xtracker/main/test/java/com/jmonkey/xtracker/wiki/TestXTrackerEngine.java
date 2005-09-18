package com.jmonkey.xtracker.wiki;

import java.util.Locale;

import junit.framework.TestCase;

import org.radeox.api.engine.context.RenderContext;
import org.radeox.engine.context.BaseInitialRenderContext;

public class TestXTrackerEngine extends TestCase {
	private String						testString1	= "string\\\\with break.";
	private String						testString2	= "string\r\nwith break.";
	private BaseInitialRenderContext	context		= null;
	private XTrackerEngine				engine		= null;

	public void testStandardWikiLineBreak() {
		String result = engine.render(testString1, context);
		assertNotNull(result);
		assertEquals("string<br/><br/>with break.<br/>", result);
	}

	public void testNewLineLineBreak() {
		String result = engine.render(testString2, context);
		assertNotNull(result);
		assertEquals("string<br/>\r\nwith break.<br/>", result);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = new BaseInitialRenderContext();
		context.set(RenderContext.INPUT_BUNDLE_NAME, "RadioxXTracker");
		context.set(RenderContext.INPUT_LOCALE, new Locale("wiki", ""));
		engine = new XTrackerEngine(context);
	}

	@Override
	protected void tearDown() throws Exception {
		engine = null;
		super.tearDown();
	}

}
