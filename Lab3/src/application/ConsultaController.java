package application;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class ConsultaController {

	private DatePicker inicio;
	private DatePicker fin;
	private CheckBox divisas;
	private CheckBox acciones;
	private Button cargar;
	private Button pAltos;
	private Button pBajos;
	private Button periodosMayores;
	private Button volver;
	
	public void initialize() {
		
	}
	
	public void cargarDatos() {
		
	}
	
	public void precioMasAlto() {
		
	}
	
	public void precioMasBajo() {
		
	}
	
	public void periodosMayores() {
	
	}
	
	public void volver(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
