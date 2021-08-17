package com.gutenberg.qa.utils;

import java.util.UUID;

public class Utils {

	// generate random text for input fields
	public static String getRandomText() {
		String pn = UUID.randomUUID().toString();
		String auto = pn.substring(0, 6);
		String projectname = "Auto";
		projectname = projectname.concat(auto);
		return projectname;
	}
}