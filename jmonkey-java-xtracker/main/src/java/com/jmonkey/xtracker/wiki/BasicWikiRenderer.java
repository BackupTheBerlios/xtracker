package com.jmonkey.xtracker.wiki;

import java.util.Locale;

import org.radeox.api.engine.RenderEngine;
import org.radeox.api.engine.context.RenderContext;
import org.radeox.engine.BaseRenderEngine;
import org.radeox.engine.context.BaseInitialRenderContext;
import org.radeox.engine.context.BaseRenderContext;

public class BasicWikiRenderer {

	public BasicWikiRenderer() {
		super();
	}

	public String render(String content) {
		RenderContext context = new BaseRenderContext();
		RenderEngine engine = new BaseRenderEngine();
		String result = engine.render(content, context);
		return result;
	}

	public String renderXTracker(String content) {
		 BaseInitialRenderContext context = new BaseInitialRenderContext();
		 context.set(RenderContext.INPUT_BUNDLE_NAME, "RadioxXtracker");
		 context.set(RenderContext.INPUT_LOCALE, new Locale("wiki", ""));
		 XTrackerEngine engine = new XTrackerEngine(context);
		 String result = engine.render(content, context);

//		String result = renderBold(content);
		
//		Pattern pattern = Pattern.compile("(^|>|[\\p{Punct}\\p{Space}]+)\\*(.*?)\\*([\\p{Punct}\\p{Space}]+|<|$)");
//		Matcher matcher = pattern.matcher(content);
//		result = matcher.replaceAll("$1<b>$2</b>$3");
		
		return result;
	}

//	private String renderBold(String content) {
//		Pattern pattern = Pattern.compile("(^|>|[\\p{Punct}\\p{Space}]+)\\*(.*?)\\*([\\p{Punct}\\p{Space}]+|<|$)");
//		Matcher matcher = pattern.matcher(content);
//		String result = matcher.replaceAll("$1<b>$2</b>$3");
//		return result;
//	}

}
