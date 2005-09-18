package com.jmonkey.xtracker.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public class FileTemplate extends Template {
	private String name = null;
	private File root = new File("/usr/local/chickenlittle/template");

	public FileTemplate() {
		super();
	}

	public FileTemplate(String name) {
		super();
		setName(name);
	}

	public FileTemplate(File root, String name) {
		super();
		setRoot(root);
		setName(name);
	}

	/**
	* attempts to load the buffer from a file in /usr/local/gap/template.
	*/
	public void loadBufferFile() throws IOException {
		File templateFile = getTemplateFile();

		if (templateFile.exists() && !templateFile.isDirectory()) {
			StringBuffer buffer = new StringBuffer();

			String lineSep = System.getProperties().getProperty("line.separator", "\n");
			BufferedReader reader = new BufferedReader(new FileReader(templateFile));
			String line = null;

			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(lineSep);
			}
			reader.close();
			setBuffer(buffer);
		}
	}

	/**
	 * @return the name of the template.
	*/
	public String getName() {
		return name;
	}

	/**
	 * Setting the name to null will search for a template called null.template.<p>
	 * @param string the name of the template. this name will be
	 * used to load a file called &lt;name&gt;.template if the
	 * loadBufferFile() method is called.
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @return java.io.File the template File. The file may not actually exist.
	 */
	public File getTemplateFile() {
		return new File(root, getName() + ".template");
	}

	public File getRoot() {
		return root;
	}

	public void setRoot(File file) {
		root = file;
	}

}
