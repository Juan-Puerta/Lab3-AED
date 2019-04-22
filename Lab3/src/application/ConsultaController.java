package application;

import java.io.File;
import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ConsultaController {

	@FXML private DatePicker inicio;
	@FXML private DatePicker fin;
	@FXML private RadioButton divisas;
	@FXML private RadioButton acciones;
	@FXML private Button cargar;
	@FXML private Button pAltos;
	@FXML private Button pBajos;
	@FXML private Button periodosMayores;
	@FXML private Button volver;
	
	public void initialize() {
		divisas.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if(acciones.isSelected()) {
					acciones.setSelected(false);
				}
				
			}
		});
			
		acciones.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if(divisas.isSelected()) {
					divisas.setSelected(false);
				}
			}
		});		 
	}
	
	public void cargarDatos() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar base de datos");

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All txt", "*.*"));

        File imgFile = fileChooser.showOpenDialog(null);

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
