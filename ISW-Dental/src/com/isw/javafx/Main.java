package com.isw.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/operador.fxml"));		    
		Scene scene = new Scene(root);
//		stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("com/fcm/ope/javafx/sources/logoblanco2.jpg")));
        stage.setTitle("Administración de citas - ESCOM IPN ");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(true);
        stage.show();
	}
	
	public static void main (String []args){
		Application.launch(args);
	}

}
