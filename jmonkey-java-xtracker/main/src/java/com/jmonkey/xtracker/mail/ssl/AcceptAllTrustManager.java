package com.jmonkey.xtracker.mail.ssl;

import java.security.cert.X509Certificate;

import com.sun.net.ssl.X509TrustManager;

/**
 * This should be changed to use the javax.security.ssl version of the class.
 * 
 * @author brill
 * @deprecated use the javax version of this class.
 * 
 */
public class AcceptAllTrustManager implements X509TrustManager {

	public AcceptAllTrustManager() {
		super();
	}

	public boolean isClientTrusted(X509Certificate[] arg0) {
		return true;
	}

	public boolean isServerTrusted(X509Certificate[] arg0) {
		return true;
	}

	public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	}

}
