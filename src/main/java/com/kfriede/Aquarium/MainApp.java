package com.kfriede.Aquarium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application{
	private static final String MAIN_VIEW_FILE_PATH = "MainWindow.fxml";
	private static final String APPLICATION_TITLE = "Aquarium ";
	private static final String PROPERTIES_FILE = "project.properties";
	private static final String ICON_FILE = "icon.png";
	
	public static Properties PROPERTIES = new Properties();;

	@Override
	public void start(Stage stage) throws Exception {
		loadProperties();
		
		Parent root = FXMLLoader.load(getClass().getResource(MAIN_VIEW_FILE_PATH));

		Scene scene = new Scene(root);
		
		stage.getIcons().add(new Image(ICON_FILE));

		stage.setTitle(APPLICATION_TITLE + PROPERTIES.getProperty("version"));
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void loadProperties() {
		PROPERTIES = new Properties();
		
		InputStream propInStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
		
		try {
			PROPERTIES.load(propInStream);
			propInStream.close();
		} catch (IOException e) {
			System.out.println("Error loading properties file");
			e.printStackTrace();
		}
	}
}
