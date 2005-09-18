package com.jmonkey.xtracker.issue.attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.mail.MailConfig;

public class DownloadServlet extends HttpServlet {
	private Logger		logger		= LogManager.getLogger(DownloadServlet.class);
	private MailConfig	mailConfig	= new MailConfig();

	public DownloadServlet() {
		super();
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
@SuppressWarnings("unusedThrown")
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttachmentHandler handler = new AttachmentHandler();
		handler.setAttachmentRoot(mailConfig.getAttachmentRootDirectory());

		String pathInfo = request.getPathInfo();
		logger.debug("Looking for file: " + pathInfo);
		File file = handler.getFileForPath(pathInfo);
		if(file != null) {
			FileDataSource fileDataSource = new FileDataSource(file);
			response.setContentType(fileDataSource.getContentType());
			FileInputStream inputStream = (FileInputStream)fileDataSource.getInputStream();
			FileChannel channel = inputStream.getChannel();

			OutputStream outputStream = response.getOutputStream();
			long bytesTransfered = channel.transferTo(0, channel.size(), Channels.newChannel(outputStream));
			
			logger.debug("Transfered " + bytesTransfered + " bytes to the browser...");
			
			response.flushBuffer();
		}
	}
}
