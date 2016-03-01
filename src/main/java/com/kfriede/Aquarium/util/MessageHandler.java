package com.kfriede.Aquarium.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.kfriede.Aquarium.MainApp;

public class MessageHandler {
	
	private static int TIMEOUT = Integer.parseInt(MainApp.PROPERTIES.getProperty("socket_timeout"));

	/**
	 * 
	 * @param ip - IP of the TV
	 * @param port - Port of the TV
	 * @param username - NOT IMPLEMENTED
	 * @param password - NOT IMPLEMENTED
	 * @param command - 4 character command
	 * @param parameter - 4 character parameter (padded with "space" if needed)
	 * @return the response
	 */
	public static String sendCommand(InetAddress ip, Integer port, String username, String password, String command, String parameter) {
		
		BufferedReader reader;
		BufferedWriter writer;
		
		String message = new String();
		String response = null;
		
		message = ( command + parameter);
		
		try {
			
			if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
				//TODO
				System.out.println("Error: Node is requesting username and password of " + username + " : " + password);
				return "Abort: Username/Password feature not yet implemented";
			}
			
			Socket cSocket = new Socket();
			cSocket.connect(new InetSocketAddress(ip, port), TIMEOUT);
			
			reader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));

			writer.write(message);
			writer.write("\r");
			writer.flush();
			
			response =  reader.readLine();
			System.out.println(response);
			
			cSocket.close();
			
		} catch (IOException e) {
			return e.getMessage().toString();
		} 
		
		
		return response;
	}
	
}
