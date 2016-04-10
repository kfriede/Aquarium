package com.kfriede.Aquarium.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import com.kfriede.Aquarium.models.Television;

public class InputFileHandler {
	public static List<Television> parseFile (String filePath) throws FileNotFoundException, NullPointerException, JSONException {
		if (filePath == null) {
			throw new FileNotFoundException("Property `last_used_nodes_file` not found");
		}
		
		List<Television> tvList = new ArrayList<Television>();
		
		/**
		 * Open file as stream
		 */
		FileInputStream in = new FileInputStream(filePath);
		
		JSONTokener tokener = new JSONTokener(in);
		JSONArray root = new JSONArray(tokener);
		
		/**
		 * Parse JSON into objects
		 */
		for (int i = 0; i < root.length(); i++) {
			Television workingTelevision = null;
			String name = root.getJSONObject(i).getString("name");
			String ip = root.getJSONObject(i).getString("ip");
			String port = root.getJSONObject(i).getString("port");
			String username = root.getJSONObject(i).getString("username");
			String password = root.getJSONObject(i).getString("password");
			
			try {
				workingTelevision = new Television(name, ip, port, username, password);
			} catch (UnknownHostException e) {
				System.out.println("Error parsing IP address: " + ip);
				e.printStackTrace();
			}
			
			if (workingTelevision != null) {
				tvList.add(workingTelevision);
			}
		}
		
		return tvList;
	}
}
