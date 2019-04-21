package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class GraficasController {

	private DatePicker inicio;
	private DatePicker fin;
	private CheckBox divisas;
	private CheckBox acciones;
	private Button cargar;
	private Button volver;
	private AreaChart grafico;
	
	
	public void initialize() {
		
	}
	
	public void cargarDatos() {
		
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
