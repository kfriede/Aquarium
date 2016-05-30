package com.kfriede.Aquarium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesHandler {
	private static final String DEFAULT_PROPERTIES_FILE = "default.properties";
	
	private Properties props;
	
	InputStream propInStream;
	FileOutputStream propOutStream;
	
	String filePath;
	
	public PropertiesHandler(String filePath) {
		
		this.filePath = filePath;
		
		props = new Properties();
		
		try {
			
			File f = new File(filePath);
			
			// if user file is not found, create it from defaults file
			if (!f.exists() || f.isDirectory()) {
				
				// creates parent directories if not already done
				new File(filePath).getParentFile().mkdirs();	// creates parent dir(s) if they don't already exist
				
				// copy the default file to the user folder location
				Files.copy(this.getClass().getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE), Paths.get(filePath));
			}
			
			// open file as stream
			propInStream = new FileInputStream(filePath);
				
			// load properties from file
			props.load(propInStream);
			propInStream.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean setProperty(String key, String value) {
		props.setProperty(key, value);
		
		try {
			propOutStream = new FileOutputStream(filePath);
			props.store(propOutStream, null);
			propOutStream.flush();
			propOutStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public String toString() {
		return props.toString();
	}
}
