package com.jmonkey.xtracker.mail.pop;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.Part;

public class ReceivedMailAttachement {
	private Part		part		= null;
	private String		contentType	= null;
	private String		fileName	= null;
	private InputStream	inputStream	= null;
	private int			size		= 0;

	public ReceivedMailAttachement(Part part) {
		super();
		this.part = part;
	}

	public void processPart() throws MessagingException, IOException {
		String partType = part.getContentType();
		contentType = partType.substring(0, partType.indexOf(";"));
		fileName = part.getFileName();
		inputStream = part.getInputStream();
		size = part.getSize();
	}

	public String getContentType() {
		return contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public int getSize() {
		return size;
	}

}
