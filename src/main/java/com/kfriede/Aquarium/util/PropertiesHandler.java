package com.kfriede.Aquarium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
	private Properties prop;
	
	InputStream propInStream;
	FileOutputStream propOutStream;
	
	String filePath;
	
	public PropertiesHandler(String filePath) {
		
		this.filePath = filePath;
		
		prop = new Properties();
		
		try {
			// creates file and parent directories if file does not exist
			new File(filePath).getParentFile().mkdirs();	// creates parent dir(s) if they don't already exist
			new File(filePath).createNewFile(); // creates file if it doesn't already exist
			
			propInStream = new FileInputStream(filePath);
			
			prop.load(propInStream);
			propInStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean setProperty(String key, String value) {
		prop.setProperty(key, value);
		
		try {
			propOutStream = new FileOutputStream(filePath);
			prop.store(propOutStream, null);
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
		return prop.getProperty(key);
	}
	
	public String toString() {
		return prop.toString();
	}
}
