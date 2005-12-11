package com.jmonkey.xtracker.mail.local;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.mail.MailConfig;

public class MailInputStreamService extends Thread {
	private Logger			logger			= LogManager.getLogger(MailInputStreamService.class);
	private boolean			running			= true;
	private ServerSocket	serverSocket	= null;
	private ThreadGroup		receiverGroup	= new ThreadGroup("RAW-Receiver-Group");

	public MailInputStreamService() {
		super("MIS-Service");
	}

	@Override
	public void run() {
		logger.warn("RAW Mail input service waiting...");
		int resetCount = 0;
		while (running) {
			try {
				initializeServerSocket();
				resetCount = listenForConnections(resetCount);
			} catch (InterruptedIOException e) {
				logger.warn("Mail input stream service interrupted...");
			} catch (IOException e) {
				logger.warn("Mail input stream service waiting to reset...", e);
				resetCount = handleRecoverableException(resetCount, e);
			}
		}

		logger.warn("RAW Mail input service shutdown...");
	}

	private int listenForConnections(int resetCount) throws IOException {
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
			resetCount = 0;
			logger.debug("Reset Count: " + resetCount + ", Connection from: " + socket.getInetAddress().toString());
			MailInputStreamReceiver receiver = new MailInputStreamReceiver(receiverGroup, socket);
			receiver.start();
		}
		return resetCount;
	}

	private int handleRecoverableException(int resetCount, IOException e) {
		try {
			sleep(5000);
			resetCount++;
		} catch (InterruptedException e1) {
			running = false;
			logger.fatal("Could not revive mail input stream service; exiting now...", e1);
		}
		if (resetCount > 10) {
			running = false;
			logger.fatal("Could not revive mail input stream service; retry count exceeded; exiting now...", e);
		} else {
			logger.warn("Mail input stream service resetting...");
		}
		return resetCount;
	}

	private void initializeServerSocket() throws IOException {
		if (serverSocket != null) {
			serverSocket.close();
			serverSocket = null;
		}

		MailConfig mailConfig = new MailConfig();
		String host = mailConfig.getMailInputStreamHost();
		int port = mailConfig.getMailInputStreamPort();
		int backlog = mailConfig.getMailInputStreamBacklog();

		InetSocketAddress socketAddress = null;
		if ("*".equals(host)) {
			socketAddress = new InetSocketAddress(port);
		} else {
			socketAddress = new InetSocketAddress(host, port);
		}
		serverSocket = new ServerSocket();
		serverSocket.setSoTimeout(0);
		serverSocket.setReuseAddress(true);
		serverSocket.bind(socketAddress, backlog);
		logger.debug("RAW Mail service listening on :" + host + ":" + port);
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
