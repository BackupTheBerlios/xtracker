package com.jmonkey.xtracker.wiki;

import org.radeox.filter.CacheFilter;
import org.radeox.filter.regex.RegexReplaceFilter;

public class CRLFFilter extends RegexReplaceFilter implements CacheFilter {

	public CRLFFilter() {
		super("$", "<br/>");
	}
}
