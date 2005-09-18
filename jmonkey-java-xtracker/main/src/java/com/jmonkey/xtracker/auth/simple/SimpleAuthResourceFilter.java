package com.jmonkey.xtracker.auth.simple;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.auth.AuthEnvironment;

public class SimpleAuthResourceFilter implements Filter {
	Logger						logger			= LogManager.getLogger(SimpleAuthResourceFilter.class);
	private Map<String, String>	roleMappings	= new HashMap<String, String>();

	public SimpleAuthResourceFilter() {
		super();
	}

	@SuppressWarnings({"unchecked","unusedThrown"})
	public void init(FilterConfig filterConfig) throws ServletException {
		Enumeration<String> patternEnum = filterConfig.getInitParameterNames();
		while (patternEnum.hasMoreElements()) {
			String pattern = patternEnum.nextElement();
			String role = filterConfig.getInitParameter(pattern);
			if (logger.isDebugEnabled()) {
				logger.debug("Loading role " + role + " for pattern " + pattern);
			}
			roleMappings.put(pattern, role);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		AuthEnvironment authEnvironment = new AuthEnvironment(httpRequest);

		String roleToTest = null;
		String requestURI = httpRequest.getRequestURI();
		Iterator<String> patternIterator = roleMappings.keySet().iterator();
		while (patternIterator.hasNext()) {
			String pattern = patternIterator.next();
			String role = roleMappings.get(pattern);
			logger.debug("Testing pattern: " + pattern + " matches " + requestURI);
			if (requestURI.matches(".*" + pattern.replace("*", ".*"))) {
				roleToTest = role;
				break;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Authenticating against role: " + roleToTest);
		}
		if (!authEnvironment.isUserInRole(roleToTest)) {
			if (logger.isDebugEnabled()) {
				logger.debug("User attempted to access resource without proper rights");
			}
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			String noAccessPage = httpRequest.getContextPath() + "/noaccess.jsp";
			httpResponse.sendRedirect(noAccessPage);
		} else {
			chain.doFilter(request, response);
		}
	}

	@SuppressWarnings("emptyBlock")
	public void destroy() {
	}

}
