package com.isw.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isw.dao.OperadorDao;
import com.isw.model.Operador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class OperadorController implements Initializable{
	
	@FXML private TextField txtNombre;
	@FXML private TextField txtApaterno;
	@FXML private TextField txtAmaterno;
	@FXML private TextField txtUsuario;
	@FXML private PasswordField txtPassword;
	@FXML private TableView<Operador> tableOperador;
	@FXML private TableColumn<Operador, Long> id;
	@FXML private TableColumn<Operador, String> nombre;
	@FXML private TableColumn<Operador, String> paterno;
	@FXML private TableColumn<Operador, String> materno;
	@FXML private TableColumn<Operador, String> usuario;
	@FXML private Button modificarButton;
	@FXML private Button borrarButton;
	@FXML private Button agregarButton;
	
	private Operador modificar;
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/isw/spring/springMain.xml");;
	private OperadorDao operadorDao = (OperadorDao) appContext.getBean("operadorDao");


	
//	TODO esto inicializa la tabla
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		
        id.setCellValueFactory(new PropertyValueFactory<Operador, Long>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<Operador, String>("nombre"));
        paterno.setCellValueFactory(new PropertyValueFactory<Operador, String>("apllidoP"));
        materno.setCellValueFactory(new PropertyValueFactory<Operador, String>("apellidoM"));
        usuario.setCellValueFactory(new PropertyValueFactory<Operador, String>("usuario"));
        tableOperador.getItems().setAll(this.operadorDao.findAll());
        
        modificarButton.setDisable(true);
        borrarButton.setDisable(true);
        
        hideShow(1);
	}
	
 
    
//    TODO metodo para agregar un nuevo registro
	@FXML
    protected void handleAddOperatorButtonAction(ActionEvent event) throws IOException {
		
		Operador operador = new Operador();
		operador.setNombre(txtNombre.getText());
		operador.setApllidoP(txtApaterno.getText());
		operador.setApellidoM(txtAmaterno.getText());
		operador.setUsuario(txtUsuario.getText());
		operador.setPass(txtPassword.getText());
		operadorDao.create(operador);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Operador");
		alert.setHeaderText("");
		alert.setContentText("Operador "+ operador.getNombre()+ " Guardado Exitosamente");
		alert.showAndWait();
		
		hideShow(1);
		
    }
	
//	TODO medtodo para actualizar un registro
	@FXML
	protected void handleChangeOperatorButtonAction(ActionEvent event){
		
		hideShow(1);
	}
	
//	TODO metodo para borrar un registro
	@FXML
	protected void handleDeleteOperatorButtonAction(ActionEvent event){
		Operador operador = this.modificar;
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Operador");
		alert.setHeaderText(" Borrar registro " + operador.getNombre());
		alert.setContentText("¿Estas seguro que quieres borrar esto ?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			
			if(this.operadorDao.delete(operador)){
				Alert ok = new Alert(AlertType.INFORMATION);
				ok.setTitle("Operador");
				ok.setHeaderText("");
				ok.setContentText("Se ha borrado "+ operador.getNombre()+ " Exitosamente");
				ok.showAndWait();
			}
			else{
				Alert fail = new Alert(AlertType.ERROR);
				fail.setTitle("Operador");
				fail.setHeaderText("");
				fail.setContentText("No se ha podido borrar "+ operador.getNombre()+ " Por razones de seguridad");
				fail.showAndWait();
			}
			
		}
		
		tableOperador.getItems().setAll(this.operadorDao.findAll());
		hideShow(1);
	}
	
//	TODO accion para habilitar campos
	@FXML
	protected void handleNewButtonAction(ActionEvent event){
		hideShow(2);
		modificarButton.setDisable(true);
		borrarButton.setDisable(true);
		
		
	}
	
//	TODO Evento click en una fila
	@FXML 
	protected void handleMouseClick(MouseEvent arg0) {
		hideShow(2);
		modificar= tableOperador.getSelectionModel().getSelectedItem();
		if(modificar != null){
			txtNombre.setText(modificar.getNombre());
			txtApaterno.setText(modificar.getApllidoP());
			txtAmaterno.setText(modificar.getApellidoM());
			txtUsuario.setText(modificar.getUsuario());
			
			modificarButton.setDisable(false);
	        borrarButton.setDisable(false);
	        
	        
	        agregarButton.setDisable(true);
		}
	    
		
	}
	
	
//	TODO muestra y oculta campos
	public void hideShow(int i){
		switch (i) {
		case 1:
				txtNombre.setDisable(true);
				txtApaterno.setDisable(true);
				txtAmaterno.setDisable(true);
				txtUsuario.setDisable(true);
				txtPassword.setDisable(true);
				txtNombre.setText("");
				txtApaterno.setText("");
				txtAmaterno.clear();
				txtUsuario.clear();
				agregarButton.setDisable(true);
				borrarButton.setDisable(true);
				modificarButton.setDisable(true);
			
			break;
			
		case 2:
				txtNombre.setDisable(false);
				txtApaterno.setDisable(false);
				txtAmaterno.setDisable(false);
				txtUsuario.setDisable(false);
				txtPassword.setDisable(false);
				txtNombre.setText("");
				txtApaterno.setText("");
				txtAmaterno.clear();
				txtUsuario.clear();
				agregarButton.setDisable(false);
				borrarButton.setDisable(false);
				modificarButton.setDisable(false);
				

		}
	}



	public static ApplicationContext getAppContext() {
		return appContext;
	}



	public static void setAppContext(ApplicationContext appContext) {
		OperadorController.appContext = appContext;
	}



	public OperadorDao getOperadorDao() {
		return operadorDao;
	}



	public void setOperadorDao(OperadorDao operadorDao) {
		this.operadorDao = operadorDao;
	}
	
	
}
