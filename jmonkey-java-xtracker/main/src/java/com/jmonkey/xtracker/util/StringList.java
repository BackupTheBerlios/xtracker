package com.jmonkey.xtracker.util;

public class StringList {
	private String			separator	= " ";
	private StringBuffer	buffer		= new StringBuffer();

	public StringList() {
		super();
	}

	public void join(long l) {
		if (buffer.length() > 0) {
			buffer.append(separator);
		}
		buffer.append(l);
	}

	public String getBuffer() {
		return buffer.toString();
	}

	public void setBuffer(String list) {
		buffer.setLength(0);
		buffer.append(list);
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public long[] getLongArray() {
		long[] result = null;
		String bufStr = buffer.toString().trim();
		if (bufStr.length() > 0) {
			String[] elements = bufStr.split(separator);
			result = new long[elements.length];
			for (int i = 0; i < result.length; i++) {
//				System.out.println(i + ": " + elements[i]);
				result[i] = Long.parseLong(elements[i]);
			}
		} else {
			result = new long[0];
		}
		return result;
	}
}
