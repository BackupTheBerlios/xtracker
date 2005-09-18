package com.jmonkey.xtracker.my.tickets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplyStringFormatter {
	private int		leadingLines	= 0;
	// private int lineLength = 80;
	private String	lineTerminator	= "\r\n";

	// private String prefixString = "";

	public ReplyStringFormatter() {
		super();
	}

	public int getLeadingLines() {
		return leadingLines;
	}

	public void setLeadingLines(int leadingLines) {
		this.leadingLines = leadingLines;
	}

	// public int getLineLength() {
	// return lineLength;
	// }
	//
	// public void setLineLength(int lineLength) {
	// this.lineLength = lineLength;
	// }

	// public String getPrefixString() {
	// return prefixString;
	// }
	//
	// public void setPrefixString(String prefixString) {
	// this.prefixString = prefixString;
	// }

	public String getLineTerminator() {
		return lineTerminator;
	}

	public void setLineTerminator(String zerothPrefixString) {
		this.lineTerminator = zerothPrefixString;
	}

	public String format(String string) {
		if (string == null) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < leadingLines; i++) {
			buffer.append(lineTerminator);
		}
		buffer.append(string.replaceAll("(?m)^(.*)$", "> $1"));
		return buffer.toString();
		//
		// // XXX This is bogus, I wasn't good enough with the regex to do it
		// // in one pass and this should be refactored. The lines should also
		// // be wrapped if they are over 72 chars.
		// Pattern pattern = Pattern.compile("(^|^>*)(\\s*)");
		// Matcher matcher = pattern.matcher(string);
		// String result = matcher.replaceAll("$1> ");
		//
		// Pattern patternSpc = Pattern.compile("(>\\s+>)");
		// Matcher matcherSpc = patternSpc.matcher(result);
		// String resultSpc = matcherSpc.replaceAll(">>");
		//
		// // Pattern patternSpc = Pattern.compile("(^>+)");
		// // Matcher matcherSpc = patternSpc.matcher(result);
		// // String resultSpc = matcherSpc.replaceAll("$1 ");
		//
		// buffer.append(resultSpc);
		// return buffer.toString();
	}
}
