package com.kfriede.Aquarium.models;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Television {
    private final String name;
    private final InetAddress ip;
    private final int port;
    private final String username;
    private final String password;

	public Television(String name, String ip, String port, String username, String password) throws UnknownHostException {
        this.name = name;
        this.ip = InetAddress.getByName(ip);
        this.port = Integer.parseInt(port);
        this.username = username;
        this.password = password;
    }

	public String getName() {
		return name;
	}

	public InetAddress getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
    public String toString() {
        return name + " <" + ip + ">";
    }
	
 
}
