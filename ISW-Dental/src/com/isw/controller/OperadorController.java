package com.isw.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isw.dao.OperadorDao;
import com.isw.model.Operador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	@FXML private TextField txtPassword;
	@FXML private TableView<Operador> tableOperador;
	@FXML private TableColumn<Operador, Long> id;
	@FXML private TableColumn<Operador, String> nombre;
	@FXML private TableColumn<Operador, String> paterno;
	@FXML private TableColumn<Operador, String> materno;
	@FXML private TableColumn<Operador, String> usuario;
	@FXML private Button modificarButton;
	@FXML private Button borrarButton;
	
	private Operador modificar;
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/isw/spring/springMain.xml");;
	private OperadorDao operadorDao = (OperadorDao) appContext.getBean("operadorDao");

	public OperadorController() {
		System.out.println("System");
	}
	
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
	}
	
 
    
    
	@FXML
    protected void handleAddOperatorButtonAction(ActionEvent event) throws IOException {
		
		Operador operador = new Operador();
		operador.setNombre(txtNombre.getText());
		operador.setApllidoP(txtApaterno.getText());
		operador.setApellidoM(txtAmaterno.getText());
		operador.setUsuario(txtUsuario.getText());
		operadorDao.create(operador);
		
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.clear();
		txtUsuario.clear();
		modificarButton.setDisable(true);
        borrarButton.setDisable(true);
		
    }
	
	@FXML
	protected void handleChangeOperatorButtonAction(ActionEvent event){
		
		
	}
	
	@FXML
	protected void handleDeleteOperatorButtonAction(ActionEvent event){
		
	}
	
	
	@FXML 
	protected void handleMouseClick(MouseEvent arg0) {
	    modificar= tableOperador.getSelectionModel().getSelectedItem();
	    txtNombre.setText(modificar.getNombre());
		txtApaterno.setText(modificar.getApllidoP());
		txtAmaterno.setText(modificar.getApellidoM());
		txtUsuario.setText(modificar.getUsuario());
		
		modificarButton.setDisable(false);
        borrarButton.setDisable(false);
		
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
