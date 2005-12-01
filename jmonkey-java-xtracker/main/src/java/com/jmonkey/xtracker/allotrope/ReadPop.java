package com.jmonkey.xtracker.allotrope;

import com.jmonkey.xtracker.mail.pop.PopReaderTask;

public class ReadPop {

	public ReadPop() {
		super();
	}

	public static void main(String[] args) {
		PopReaderTask task = new PopReaderTask();
		if (args != null && args.length > 0 && "true".equalsIgnoreCase(args[0])) {
			task.setDebugMail(true);
		}
		task.run();
	}

}
