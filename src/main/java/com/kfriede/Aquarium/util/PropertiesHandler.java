package com.kfriede.Aquarium.util;

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
		
		propInStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
		
		try {
			prop.load(propInStream);
			propInStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean setProperty(String key, String value) {
		prop.setProperty(key, value);
		
//		try {
//			propOutStream = new FileOutputStream("con.fig");
//			prop.store(propOutStream, null);
//			propOutStream.flush();
//			propOutStream.close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			return false;
//		}
		
		return true;
		
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public String toString() {
		return prop.toString();
	}
}
