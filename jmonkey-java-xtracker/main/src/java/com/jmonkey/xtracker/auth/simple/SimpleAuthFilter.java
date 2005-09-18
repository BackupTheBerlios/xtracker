package com.jmonkey.xtracker.auth.simple;

import java.io.IOException;
import java.util.prefs.BackingStoreException;

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
import com.jmonkey.xtracker.config.JdkPrefsConfig;

public class SimpleAuthFilter implements Filter {
	Logger			logger	= LogManager.getLogger(SimpleAuthFilter.class);
	JdkPrefsConfig	config	= null;

	public SimpleAuthFilter() {
		super();
	}

	@SuppressWarnings( { "emptyBlock", "unusedThrown" })
	public void init(FilterConfig filterConfig) throws ServletException {
		config = JdkPrefsConfig.instance();
		try {
			config.load();
		} catch (BackingStoreException e) {
			throw new ServletException(e);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (config.isConfigured()) {
			AuthEnvironment authEnv = new AuthEnvironment(httpRequest);
			if (authEnv.getPrincipal() == null) {
				String loginPath = httpRequest.getContextPath() + "/simplelogin.jsp";
				// logger.debug(loginPath);
				httpResponse.sendRedirect(loginPath);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			String initPath = httpRequest.getContextPath() + "/init.do";
			httpResponse.sendRedirect(initPath);
		}
	}

	@SuppressWarnings("emptyBlock")
	public void destroy() {
	}

}
