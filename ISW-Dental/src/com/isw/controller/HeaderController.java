	package com.isw.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HeaderController {
	@FXML private Window oper;
	@FXML private Pane pane; 
	
	@FXML 
    protected void handleOperadorButtonAction(ActionEvent event) {
		System.out.println("operador");
	}
    
	
	@FXML 
    protected void handleSolicitudButtonAction(ActionEvent event) {
		System.out.println("solicitud");
	}
    
	
	@FXML 
    protected void handleCitasButtonAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/operador.fxml"));		    
		Scene scene = new Scene(root);
		Stage stage = new Stage();
        stage.setTitle("Administración de citas - ESCOM IPN ");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
	}
    
	
	@FXML 
    protected void handleMaterialesButtonAction(ActionEvent event) {
		System.out.println("materiales");
	}
    
	
	@FXML 
    protected void handlePacientesButtonAction(ActionEvent event) {
		System.out.println("paciente");
	}
    

}
