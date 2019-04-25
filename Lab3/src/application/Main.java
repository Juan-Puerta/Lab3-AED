package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exceptions.ElementExist;
import javafx.application.Application;
import javafx.stage.Stage;
import world.*;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Bank theBank;
	
	public Main() throws IOException {
		theBank = new Bank();
//		try {
			readTxt("data/BTCUSD prices.txt");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			if(theBank.getTheActionAAPL() == null || theBank.getTheActionMSFT() == null || theBank.getTheActionUS30() == null || 
//			theBank.getTheActionUSSPX500() == null || theBank.getTheActionWTI() == null ||  theBank.getTheBadgeEURUSD() == null || 
//			theBank.getTheBadgeGBPCAD() == null ||  theBank.getTheBadgeUSDJPY() == null ||  theBank.getTheBadgeXAUUSD() == null || 
//			theBank.getTheBitcoin() == null) {
//				theBank.deserialize();
//			}
//		}catch(Exception e){
//			System.out.println("hola");
//		}
//		System.out.println(theBank.getTheActionUSSPX500().getRoot().getValue().getPrice());
		System.out.println(theBank.getTheBitcoin().getDate());
	}
	
	public Bank getTheBank() {
		return theBank;
	}

	public void setTheBank(Bank theBank) {
		this.theBank = theBank;
	}
	
	public void readTxt(String linkTxt) throws IOException {
		String line;
		FileReader f = new FileReader(linkTxt);
		BufferedReader b = new BufferedReader(f);
		while((line = b.readLine()) != null) {
			String lineNew = line.replaceFirst(",", "");
			String[] infoBank = lineNew.split(" ");
//			System.out.println("nada");
			if(infoBank[0].equalsIgnoreCase("#US30")) {
				System.out.println(infoBank[3]);
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));	
				theBank.getTheActionUS30().insert(theAction);
			}else if(infoBank[0].equalsIgnoreCase("#USSPX500")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionUSSPX500().insert(theAction);
			}else if(infoBank[0].equalsIgnoreCase("#AAPL")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionAAPL().insert(theAction);
			}else if(infoBank[0].equalsIgnoreCase("#MSFT")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionMSFT().insert(theAction);
			}else if(infoBank[0].equalsIgnoreCase("#WTI")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionWTI().insert(theAction);
			}else if(infoBank[0].equalsIgnoreCase("XAUUSD")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeXAUUSD().insert(theBadge);
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(infoBank[0].equalsIgnoreCase("EURUSD")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeEURUSD().insert(theBadge);
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(infoBank[0].equalsIgnoreCase("GBPCAD")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeGBPCAD().insert(theBadge);
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(infoBank[0].equalsIgnoreCase("USDJPY")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeUSDJPY().insert(theBadge);
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Bitcoin theBitcoin = new Bitcoin(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.addBitCoin(theBitcoin);
			}
			
		}
		try {
			theBank.serializable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date parseDate(String[] info) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String parseConvert = info[1]+" "+info[2].replace(",","");
		Date dateToReturn = null;
		try {
			dateToReturn = format.parse(parseConvert);
		}catch(ParseException ex) {
			System.out.println(ex);
		}
		return dateToReturn;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("BOLSA DE VALORES DE COLOMBIA");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		Main theMain = new Main();
	}
}
