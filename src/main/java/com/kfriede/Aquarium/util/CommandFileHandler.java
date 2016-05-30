package com.kfriede.Aquarium.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONTokener;

import com.kfriede.Aquarium.models.Command;
import com.kfriede.Aquarium.models.Parameter;

public class CommandFileHandler {
	public static List<Command> parseFile (InputStream filePath) throws FileNotFoundException {
		List<Command> commandList = new ArrayList<Command>();
		
		/**
		 * Open file as stream
		 */
		InputStream in = filePath;
		
		JSONTokener tokener = new JSONTokener(in);
		JSONArray root = new JSONArray(tokener);
		
		/**
		 * Build objects from JSON
		 */
		for (int i = 0; i < root.length(); i++) {
			Command workingCommand = null;
			String commandName = root.getJSONObject(i).getString("commandName");
			String command = root.getJSONObject(i).getString("command");
			
			/**
			 * Build parameter list
			 */
			List<Parameter> parameterList = new ArrayList<Parameter>();
			for (int j = 0; j < root.getJSONObject(i).getJSONArray("parameters").length(); j++) {
				Parameter workingParameter = null;
				String name = root.getJSONObject(i).getJSONArray("parameters").getJSONObject(j).getString("name");
				String value = root.getJSONObject(i).getJSONArray("parameters").getJSONObject(j).getString("value");
				
				workingParameter = new Parameter(name, value);
				parameterList.add(workingParameter);
			}
			
			String tooltip = root.getJSONObject(i).getString("tooltip");
			
			workingCommand = new Command(commandName, command, parameterList, tooltip);
			
			if (workingCommand != null) {
				commandList.add(workingCommand);
			}
		}
		
		return commandList;
	}
}
