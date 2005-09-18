package com.jmonkey.xtracker.wiki;

import junit.framework.TestCase;

public class TestBasicWikiRenderer extends TestCase {
	private final String		testContent1	= "this is a test\n\nand a paragraph break...";
	private final String		testContent2	= "this is a test\rand not a paragraph break...";
	private final String		testString3		= "string *with* bold.";
	private final String		testString4		= "string ~with~ italic.";
	private final String		testString5		= "string ~*with*~ underline.";
	private final String		testString6		= "string *~with~* underline.";
	private final String		testString7		= "string with http://dev.pappin.ca with link";
	private final String		testString8		= "string --with-- strikethrough.";
	private BasicWikiRenderer	renderer		= null;

	public void testParagraphBreakIsFormatted() {
		String value = renderer.render(testContent1);
		assertNotNull(value);
		assertEquals("this is a test<p class=\"paragraph\"/>and a paragraph break&#8230;", value);
	}

	public void testEndOfLineGetsHtmlBR() {
		String value = renderer.renderXTracker(testContent2);
		assertNotNull(value);
//		assertEquals("this is a test<br/>\nand not a paragraph break...<br/>", value);
		assertEquals("this is a test<br/>\rand not a paragraph break...<br/>",value);
	}

	public void testBoldTextWithAstrix() {
		String result = renderer.renderXTracker(testString3);
		assertNotNull(result);
		assertEquals("string <b class=\"bold\">with</b> bold.<br/>", result);
	}

	public void testItalicTextWithTildx() {
		String result = renderer.renderXTracker(testString4);
		assertNotNull(result);
		assertEquals("string <i class=\"italic\">with</i> italic.<br/>", result);
	}

	public void testBoldAndItalicText1() {
		String result = renderer.renderXTracker(testString6);
		assertNotNull(result);
		assertEquals("string <b class=\"bold\"><i class=\"italic\">with</i></b> underline.<br/>", result);
	}

	public void testBoldAndItalicText2() {
		String result = renderer.renderXTracker(testString5);
		assertNotNull(result);
		assertEquals("string <i class=\"italic\"><b class=\"bold\">with</b></i> underline.<br/>", result);
	}

	public void testLinkExpression() {
		String result = renderer.renderXTracker(testString7);
		assertNotNull(result);
		assertEquals("string with <span class=\"nobr\"><a href=\"http://dev.pappin.ca\">&#104;ttp://dev.pappin.ca</a></span> with link<br/>", result);
	}
	
	public void testStrikethrough() {
		String result = renderer.renderXTracker(testString8);
		assertNotNull(result);
		assertEquals("string <strike class=\"strike\">with</strike> strikethrough.<br/>", result);
	}

	// public void testMatches() {
	// System.out.println(testString3.matches(".*\\*(.*?)\\*.*"));
	// System.out.println(testString4.matches(".*~(.*?)~.*"));
	// System.out.println(testString5.matches(".*_(.*?)_.*"));
	// System.out.println(testString6.matches(".*~(.*?)~.*"));
	// System.out.println(testString7.matches(".*\\*(.*?)\\*.*"));
	// System.out.println(testString8.matches(".*\\*(.*?)\\*.*"));
	// }

	// public void testSubstitute() {
	// Pattern pattern =
	// Pattern.compile("([^\"\'=]|^)((http|ftp)s?://(%[\\p{Digit}A-Fa-f][\\p{Digit}A-Fa-f]|[-_.!~*\';/?:@#&=+$,\\p{Alnum}])+)");
	// Matcher matcher = pattern.matcher(testString9);
	// String result = matcher.replaceAll("<span class=\"nobr\">$1<a
	// href=\"$2\">$3</a></span>");
	// System.out.println(result);
	//
	// }

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// testContent1 = "this is a test\n\nand a paragraph break...";
		renderer = new BasicWikiRenderer();
	}

	@Override
	protected void tearDown() throws Exception {
		renderer = null;
		super.tearDown();
	}

}
