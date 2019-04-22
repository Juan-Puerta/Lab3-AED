package application;

import java.io.File;
import java.io.IOException;

import collections.NodeAVL;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GraficasController {

	@FXML private DatePicker inicio;
	@FXML private DatePicker fin;
	@FXML private RadioButton divisas;
	@FXML private RadioButton acciones;
	@FXML private Button cargar;
	@FXML private Button volver;
	@FXML private AreaChart grafico;
	@FXML private ChoiceBox box;
	
 
	public void initialize() {
		
		divisas.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				box.getItems().clear();
				box.getItems().add("GBPCAD");
				box.getItems().add("EURUSD");
				box.getItems().add("USDJPY");
				if(acciones.isSelected()) {
					acciones.setSelected(false);
				}
				
			}
		});
			
		acciones.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				box.getItems().clear();
				box.getItems().add("XAUUSD");
				box.getItems().add("WTI");
				box.getItems().add("BTCUSD");
				box.getItems().add("USSPX500");
				box.getItems().add("US30");
			
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
