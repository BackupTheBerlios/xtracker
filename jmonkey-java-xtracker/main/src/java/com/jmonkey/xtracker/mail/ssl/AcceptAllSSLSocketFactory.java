package com.jmonkey.xtracker.mail.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;

import javax.net.ssl.SSLSocketFactory;

import com.sun.net.ssl.SSLContext;
import com.sun.net.ssl.TrustManager;

public class AcceptAllSSLSocketFactory extends SSLSocketFactory {
	private SSLSocketFactory	factory;

	public AcceptAllSSLSocketFactory() {
		super();
		try {
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { new AcceptAllTrustManager() }, new SecureRandom());
			factory = (SSLSocketFactory) sslcontext.getSocketFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String[] getDefaultCipherSuites() {
		return factory.getDefaultCipherSuites();
	}

	@Override
	public String[] getSupportedCipherSuites() {
		return factory.getSupportedCipherSuites();
	}

	@Override
	public Socket createSocket(Socket socket, String s, int i, boolean flag) throws IOException {
		return factory.createSocket(socket, s, i, flag);
	}

	@Override
	public Socket createSocket(String s, int i) throws IOException, UnknownHostException {
		return factory.createSocket(s, i);
	}

	@Override
	public Socket createSocket(String s, int i, InetAddress inaddr, int j) throws IOException, UnknownHostException {
		return factory.createSocket(s, i, inaddr, j);
	}

	@Override
	public Socket createSocket(InetAddress inaddr, int i) throws IOException {
		return factory.createSocket(inaddr, i);
	}

	@Override
	public Socket createSocket(InetAddress inaddr, int i, InetAddress inaddr1, int j) throws IOException {
		return factory.createSocket(inaddr, i, inaddr1, j);
	}

}
