package com.isw.controller;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isw.dao.PacienteDao;
import com.isw.model.Paciente;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PacienteController implements Initializable{
	
	@FXML private TableView<Paciente> tablePaciente;
	@FXML private TableColumn<Paciente, Long> id;
	@FXML private TableColumn<Paciente, String> nombre;
	@FXML private TableColumn<Paciente, String> apellidoPat;
	@FXML private TableColumn<Paciente, String> apellidoMat;
	@FXML private TableColumn<Paciente, String> visitas;
	@FXML private TableColumn<Paciente, String> usuario;
	@FXML private TableColumn<Paciente, String> telefono;
	@FXML private Button deleteButton;
	
	private Paciente paciente;
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/isw/spring/springMain.xml");;
	private PacienteDao pacienteDao = (PacienteDao) appContext.getBean("pacienteDao");

	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		
        id.setCellValueFactory(new PropertyValueFactory<Paciente, Long>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre"));
        apellidoPat.setCellValueFactory(new PropertyValueFactory<Paciente, String>("apellidPat"));
        apellidoMat.setCellValueFactory(new PropertyValueFactory<Paciente, String>("apellidoMat"));
        visitas.setCellValueFactory(new PropertyValueFactory<Paciente, String>("visitas"));
        usuario.setCellValueFactory(new PropertyValueFactory<Paciente, String>("usuario"));
        telefono.setCellValueFactory(new PropertyValueFactory<Paciente, String>("telefono"));
       
        tablePaciente.getItems().setAll(this.pacienteDao.findAll());
        deleteButton.setDisable(true);
        
       
	}
	
	@FXML 
	protected void handleMouseClick(MouseEvent event) {
		deleteButton.setDisable(false);
		Paciente paciente = tablePaciente.getSelectionModel().getSelectedItem();
		this.paciente = paciente;
		if (event.getClickCount() == 2) 
	            popUp(paciente);
	        
	}
	
	@FXML
	protected void handleAddOperatorButtonAction(ActionEvent event){
		popUp(null);
		
		
	}
	
	@FXML
	protected void handleDeleteButtonAction(ActionEvent event){
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Operador");
		alert.setHeaderText(" Borrar registro " + this.paciente.getNombre());
		alert.setContentText("¿Estas seguro que quieres Borrar esto ?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			pacienteDao.delete(this.paciente);
			tablePaciente.getItems().setAll(this.pacienteDao.findAll());
		}
			
	}
	
	private void popUp(Paciente p){
		if(p == null){
			// Esto crea Un nuevo dialogo
			Dialog<Paciente> dialog = new Dialog<>();
			dialog.setTitle("Agregar un nuevo Paciente");
			dialog.setHeaderText("Paciente");

			// Descomentar esto para agregar una imagen al dialogo
//					dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

			// Aqui se editan los tipos de botones.
			ButtonType loginButtonType = new ButtonType("Guardar", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

			// Creamos el espacio para los fields
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 150, 10, 10));

			TextField username = new TextField();
			username.setPromptText("Nombre");
			
			TextField apellidoPat = new TextField();
			apellidoPat.setPromptText("Apellido Paterno");
			
			TextField apellidoMat = new TextField();
			apellidoMat.setPromptText("Apellido Materno");
			
			TextField visitas = new TextField();
			visitas.setPromptText("Visitas");
			
			TextField telefono = new TextField();
			telefono.setPromptText("Telefono");
			
			TextField usuario = new TextField();
			usuario.setPromptText("Username");
			
			PasswordField password = new PasswordField();
			password.setPromptText("Password");

			grid.add(new Label("Nombre:"), 0, 0);
			grid.add(username, 1, 0);
			
			grid.add(new Label("Apellido Paterno:"), 0, 1);
			grid.add(apellidoPat, 1, 1);
			
			grid.add(new Label("Apellido Materno:"), 0, 2);
			grid.add(apellidoMat, 1, 2);
			
			grid.add(new Label("Telefono:"), 0, 3);
			grid.add(telefono, 1, 3);
			
			grid.add(new Label("Visitas:"), 0, 4);
			grid.add(visitas, 1, 4);
			
			grid.add(new Label("Usuario:"), 0, 5);
			grid.add(usuario, 1, 5);
			
			grid.add(new Label("Password:"), 0, 6);
			grid.add(password, 1, 6);
			
			visitas.setText("0");
			visitas.setDisable(true);

			// Habilita /Deshabilita el boton de guardado deacuerdo al nombre de usuario
			Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
			loginButton.setDisable(true);

			// Se usa lambda para validacion y activar el boton
			password.textProperty().addListener((observable, oldValue, newValue) -> {
//								    ESTO es un error 
				if(!(username.getText().isEmpty() && apellidoPat.getText().isEmpty() && apellidoMat.getText().isEmpty()
							&& telefono.getText().isEmpty() && visitas.getText().isEmpty() && usuario.getText().isEmpty() && password.getText().isEmpty())){
					loginButton.setDisable(false);
				}
					
			});

			dialog.getDialogPane().setContent(grid);

			//Pone el foco en el field de username por defecto
			Platform.runLater(() -> username.requestFocus());

			// Accion del boton de guardado
			dialog.setResultConverter(dialogButton -> {
			    if (dialogButton == loginButtonType) {
			    	Paciente pp = new Paciente();
			    	pp.setNombre(username.getText());
			    	pp.setApellidPat(apellidoPat.getText());
			    	pp.setApellidoMat(apellidoMat.getText());
			    	pp.setVisitas(Long.parseLong(visitas.getText()));
			    	pp.setUsuario(usuario.getText());
			    	pp.setContraseña(password.getText());
			    	pp.setTelefono(telefono.getText());
			        return pp; 
			    }
			    return null;
			});

			Optional<Paciente> result = dialog.showAndWait();

			result.ifPresent(usernamePassword -> {
			    pacienteDao.create(result.get());
			    Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Paciente");
				alert.setHeaderText("");
				alert.setContentText("Se ha guardado "+ result.get().getNombre()+ " Exitosamente");
				alert.showAndWait();
			    tablePaciente.getItems().setAll(this.pacienteDao.findAll());
			});
		}
		
//		TODO esto es para actualizar
		else
		{
			// Esto crea Un nuevo dialogo
			Dialog<Paciente> dialog = new Dialog<>();
			dialog.setTitle("Agregar un nuevo Paciente");
			dialog.setHeaderText("Paciente");

			// Descomentar esto para agregar una imagen al dialogo
//								dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

			// Aqui se editan los tipos de botones.
			ButtonType loginButtonType = new ButtonType("Guardar", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

			// Creamos el espacio para los fields
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 150, 10, 10));

			TextField username = new TextField();
			username.setPromptText("Nombre");
			
			TextField apellidoPat = new TextField();
			apellidoPat.setPromptText("Apellido Paterno");
			
			TextField apellidoMat = new TextField();
			apellidoMat.setPromptText("Apellido Materno");
			
			TextField visitas = new TextField();
			visitas.setPromptText("Visitas");
			
			TextField telefono = new TextField();
			telefono.setPromptText("Telefono");
			
			TextField usuario = new TextField();
			usuario.setPromptText("Username");
			
			PasswordField password = new PasswordField();
			password.setPromptText("Password");

			grid.add(new Label("Nombre:"), 0, 0);
			grid.add(username, 1, 0);
			
			grid.add(new Label("Apellido Paterno:"), 0, 1);
			grid.add(apellidoPat, 1, 1);
			
			grid.add(new Label("Apellido Materno:"), 0, 2);
			grid.add(apellidoMat, 1, 2);
			
			grid.add(new Label("Telefono:"), 0, 3);
			grid.add(telefono, 1, 3);
			
			grid.add(new Label("Visitas:"), 0, 4);
			grid.add(visitas, 1, 4);
			
			grid.add(new Label("Usuario:"), 0, 5);
			grid.add(usuario, 1, 5);
			
			grid.add(new Label("Password:"), 0, 6);
			grid.add(password, 1, 6);
			
			visitas.setDisable(true);
			
			username.setText(p.getNombre());
			apellidoPat.setText(p.getApellidPat());
			apellidoMat.setText(p.getApellidoMat());
			telefono.setText(p.getTelefono());
			visitas.setText(p.getVisitas()+"");
			usuario.setText(p.getUsuario());
			password.setText(p.getContraseña());

			// Habilita /Deshabilita el boton de guardado deacuerdo al nombre de usuario
			Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
			loginButton.setDisable(false);
			

			// Se usa lambda para validacion y activar el boton
			password.textProperty().addListener((observable, oldValue, newValue) -> {
//					    ESTO es un error 
				loginButton.setDisable(false);
					
			});

			dialog.getDialogPane().setContent(grid);

			//Pone el foco en el field de username por defecto
			Platform.runLater(() -> username.requestFocus());

			// Accion del boton de guardado
			dialog.setResultConverter(dialogButton -> {
			    if (dialogButton == loginButtonType) {
			    	p.setNombre(username.getText());
			    	p.setApellidPat(apellidoPat.getText());
			    	p.setApellidoMat(apellidoMat.getText());
			    	p.setVisitas(Long.parseLong(visitas.getText()));
			    	p.setUsuario(usuario.getText());
			    	p.setContraseña(password.getText());
			    	p.setTelefono(telefono.getText());
			        return p; 
			    }
			    return null;
			});

			Optional<Paciente> result = dialog.showAndWait();

			result.ifPresent(usernamePassword -> {
			    pacienteDao.update(result.get());
			    
			    Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Paciente");
				alert.setHeaderText("");
				alert.setContentText("Paciente "+ result.get().getNombre()+ " Actualizado Exitosamente");
				alert.showAndWait();
				
			    tablePaciente.getItems().setAll(this.pacienteDao.findAll());
			});
		}
	}
	

}
