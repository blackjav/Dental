	package com.isw.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HeaderController {
	
	@FXML 
    protected void handleOperadorButtonAction(ActionEvent event) throws IOException {
		System.out.println("operador");
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/operador.fxml"));		    
		Scene nueva = new Scene(root);
        Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        actual.hide();
        actual.setScene(nueva);
//        actual.show();
	}
    
	
	@FXML 
    protected void handleSolicitudButtonAction(ActionEvent event) throws IOException {
		System.out.println("solicitud");
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/Solicitud.fxml"));		    
		Scene nueva = new Scene(root);
        Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        actual.hide();
        actual.setScene(nueva);
//        actual.show();
	}
    
	
	@FXML 
    protected void handleCitasButtonAction(ActionEvent event) throws IOException {
		System.out.println("Citas");
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/Citas.fxml"));		    
		Scene nueva = new Scene(root);
        Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        actual.hide();
        actual.setScene(nueva);
//        actual.show();
	}
    
	
	@FXML 
    protected void handleMaterialesButtonAction(ActionEvent event) throws IOException {
		System.out.println("materiales");
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/Materiales.fxml"));		    
		Scene nueva = new Scene(root);
        Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        actual.hide();
        actual.setScene(nueva);
//        actual.show();
	}
    
	
	@FXML 
    protected void handlePacientesButtonAction(ActionEvent event) throws IOException {
		System.out.println("paciente");
		Parent root = FXMLLoader.load (getClass().getClassLoader().getResource("com/isw/fxml/Paciente.fxml"));		    
		Scene nueva = new Scene(root);
        Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        actual.hide();
        actual.setScene(nueva);
//        actual.show();
	}
    

}
