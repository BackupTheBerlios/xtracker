package com.jmonkey.xtracker.wiki;

import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.radeox.api.engine.WikiRenderEngine;
import org.radeox.api.engine.context.InitialRenderContext;
import org.radeox.engine.BaseRenderEngine;
import org.radeox.filter.Filter;
import org.radeox.filter.FilterPipe;
import org.radeox.util.Service;

public class XTrackerEngine extends BaseRenderEngine implements WikiRenderEngine {
	private Logger				logger		= LogManager.getLogger(XTrackerEngine.class);
	public static final String	ENGINE_NAME	= "xtracker";

	public XTrackerEngine() {
		super();
	}

	public XTrackerEngine(InitialRenderContext context) {
		super(context);
	}

	/**
	 * @see org.radeox.engine.BaseRenderEngine#getName()
	 */
	@Override
	public String getName() {
		return ENGINE_NAME;
	}

	public boolean exists(String name) {
		return false;
	}

	public boolean showCreate() {
		return false;
	}

	@SuppressWarnings("emptyBlock")
	public void appendLink(StringBuffer buffer, String name, String view, String anchor) {
	}

	@SuppressWarnings("emptyBlock")
	public void appendLink(StringBuffer buffer, String name, String view) {
	}

	public void appendCreateLink(StringBuffer buffer, String name, String view) {
		buffer.append("<a>");
		buffer.append("?");
		buffer.append("</a>");
	}

	/**
	 * @see org.radeox.engine.BaseRenderEngine#init()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void init() {
		if (null == fp) {
			fp = new FilterPipe(initialContext);
			Iterator<Filter> iterator = Service.providers(XTrackerEngine.class);
			while (iterator.hasNext()) {
				try {
					Filter filter = iterator.next();
					fp.addFilter(filter);
					logger.debug("Loaded filter: " + filter.getClass().getName());
				} catch (Exception e) {
					logger.warn("XTrackerEngine: unable to load filter", e);
				}
			}
			fp.init();
		}
	}

}
