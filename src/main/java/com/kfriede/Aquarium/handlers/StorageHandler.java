package com.kfriede.Aquarium.handlers;

import java.io.File;

public class StorageHandler {
	
	public static String home = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Aquarium" + File.separator;
	
	public static PropertiesHandler PROPERTIES;
	
	public static void initialize() {
		PROPERTIES = new PropertiesHandler(home + "aquarium.properties");
		System.setProperty("app.root", home);
	}
}
