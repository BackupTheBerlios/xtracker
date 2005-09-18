package com.jmonkey.xtracker.issue.attachment;

import java.io.File;
import java.text.NumberFormat;

public class AttachmentFile {
	private String	name	= null;
	private String	size	= null;
	private String	path	= null;

	public AttachmentFile(File file) {
		super();
		name = file.getName();

		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false);
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		long len = file.length();
		if (len < 1000) {
			size = len + "b";
		} else if (len > 999 && len < 1000000) {
			size = nf.format((len / 1000.0)) + "k";
		} else if (len > 999999) {
			size = nf.format((len / 1000000.0)) + "M";
		} else {
			size = "" + len;
		}

		path = file.getParentFile().getName() + "/" + file.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
