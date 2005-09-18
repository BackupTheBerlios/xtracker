package com.jmonkey.xtracker.mail;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Looks for a file in /usr/local/gap/template with the specified name and a
 * .template extension. e.g. testname.template.
 * <p>
 * The template will replate the tags with the tag values.
 * 
 * @author brill
 * @version $Revision: 1.1 $
 * @created 18-Dec-2003
 */
public class Template {

	private final HashMap<String, String>	tags	= new HashMap<String, String>();
	private StringBuffer					buffer	= null;

	public Template() {
		super();
	}

	/**
	 * @param tag
	 *            the tag to search for
	 * @param value
	 *            the string to replace the tag with.
	 * @throws IllegalArgumentException
	 *             if the specified tag is null or the specified value is null.
	 */
	public void setTag(String tag, String value) {
		if (tag == null) {
			throw new IllegalArgumentException("Tag must not be null");
		}

		if (value == null) {
			throw new IllegalArgumentException("Value must not be null");
		}

		tags.put(tag, value);
	}

	/**
	 * @param tag
	 *            the named tag to get the value for.
	 * @return the value of the specified tag or null if the tag does not exist.
	 * @throws IllegalArgumentException
	 *             if the specified tag is null.
	 */
	public String getTag(String tag) {
		if (tag == null) {
			throw new IllegalArgumentException("Tag must not be null");
		}

		return tags.get(tag);
	}

	/**
	 * gets the current template.
	 * 
	 * @return java.lang.StringBuffer
	 */
	public StringBuffer getBuffer() {
		return buffer;
	}

	/**
	 * Allows the template to be programatically set.
	 * 
	 * @param buffer
	 *            java.lang.StringBuffer
	 */
	public void setBuffer(StringBuffer newBuffer) {
		this.buffer = newBuffer;
	}

	/**
	 * @return java.lang.StringBuffer with the parsed content
	 */
	public StringBuffer parseBuffer() {
		StringBuffer output = new StringBuffer();
		output.append(this.getBuffer());

		if (!tags.isEmpty()) {
			Iterator<String> keyIterator = tags.keySet().iterator();

			while (keyIterator.hasNext()) {
				String tag = keyIterator.next();

				while (output.indexOf(tag) >= 0) {
					int index = output.indexOf(tag);
					int length = tag.length();
					output.replace(index, index + length, tags.get(tag));
				}
			}
		}

		return output;
	}
}
