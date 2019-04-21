package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SampleController {
	
	private Button consulta;
	private Button graficas;
	private Button salir;
	
	public void initialize() {
		
	}
	
	public void consulta(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Consulta.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void graficas(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Graficas.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salir(Event event) {
		Alert alert = new Alert(AlertType.INFORMATION," GRACIAS POR USAR NUESTRA APLICACIÓN ", ButtonType.OK);
		alert.setHeaderText("Hasta Pronto");
		alert.showAndWait();	
		System.exit(0);
	}
	
}
