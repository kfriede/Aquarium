package com.kfriede.Aquarium.util;

import com.kfriede.Aquarium.MainApp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AboutWindow {
	public static Alert buildWindow() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About Aquarium");
		alert.setHeaderText(null);
		
		StringBuilder content = new StringBuilder();
		content.append("Aquarium v." + MainApp.PROPERTIES.getProperty("version") + "\n\n");
		content.append("Copyright (c) 2016 Kevin Friedemann - MIT License\n\n");
		content.append("This software is provided free of charge.  If you paid for this software, get your money back and contact <kevin.friedemann@gmail.com> ");
		
		
		alert.setContentText(content.toString());

		return alert;
	}
}
