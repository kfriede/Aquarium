package com.kfriede.Aquarium.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MessageHandlerTest {

	public static void main(String[] args) {
		InetAddress addr = null;
		try {
			addr = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (addr != null) {
			System.out.println(MessageHandler.sendCommand(addr, 10002, null, null, "POWR", "1   "));
		}

	}

}
