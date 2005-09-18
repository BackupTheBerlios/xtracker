package com.jmonkey.xtracker.issue.attachment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement;

public class AttachmentHandler {
	private File	attachmentRoot	= null;

	public AttachmentHandler() {
		super();
	}

	public File getAttachmentRoot() {
		return attachmentRoot;
	}

	public void setAttachmentRoot(File attachmentRoot) {
		this.attachmentRoot = attachmentRoot;
	}

	public File getFileForPath(String path) {
		File file = null;
		if (attachmentRoot != null) {
			attachmentRoot.mkdirs();
			file = new File(attachmentRoot, path);
		}
		return file;
	}

	public List<AttachmentFile> listAttachements(History history) {
		List<AttachmentFile> attachements = new ArrayList<AttachmentFile>();
		if (attachmentRoot != null) {
			attachmentRoot.mkdirs();

			File dir = new File(attachmentRoot, history.getId());
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					attachements.add(new AttachmentFile(file));
				}
			}
		}
		return attachements;
	}

	public void storeAttachment(History history, ReceivedMailAttachement attachment) throws IOException {
		if (attachmentRoot != null && attachment != null) {
			attachmentRoot.mkdirs();

			File dir = new File(attachmentRoot, history.getId());
			dir.mkdirs();
			File file = new File(dir, attachment.getFileName());
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			FileChannel channel = fileOutputStream.getChannel();

			InputStream inputStream = attachment.getInputStream();
			channel.transferFrom(Channels.newChannel(inputStream), 0, attachment.getSize());
			channel.force(true);
		}
	}

}
