package com.kfriede.Aquarium;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource(MAIN_VIEW_FILE_PATH));
			
			Scene scene = new Scene(root);
			
			stage.getIcons().add(new Image(ICON_FILE));

			stage.setTitle(APPLICATION_TITLE + PROPERTIES.getProperty("version"));
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			alert(e);
		}
		
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
	
	private void alert(Exception ex) {
		
		ex.printStackTrace();
		
		/**
		 * SHOW EXCEPTION ALERT DIALOG
		 */
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Unhandled Exception:");
		alert.setContentText(ex.getMessage().toString());

		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}
}
