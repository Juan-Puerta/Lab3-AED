package application;
import java.io.BufferedReader;
import java.io.File;
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

	public Main() throws Exception {
		theBank = new Bank();
		
//		readTxt("data/#US30 prices.txt");
		
		if(new File("Datas/dataAAPL").length() > 0) {
			theBank.deserializeAAPL();
		}
		if(new File("Datas/dataMSFT").length() > 0) {
			theBank.deserializeMSFT();
		}
		if(theBank.getTheActionUS30().getRoot() == null) {
			theBank.deserializeUS30();
		}
		if(theBank.getTheActionUSSPX500().getRoot() == null) {
			theBank.deserializeUSDPX500();
		}
		if(theBank.getTheActionWTI().getRoot() == null) {
			System.out.println("Caca");
			theBank.deserializeWTI();
		}
		if(theBank.getTheBadgeEURUSD().getRoot() == null) {
			theBank.deserializeEURUSD();
		}
		if(theBank.getTheBadgeGBPCAD().getRoot() == null) {
			theBank.deserializeGBPCAD();
		}
		if(theBank.getTheBadgeUSDJPY().getRoot() == null) {
			theBank.deserializeUSDJPY();
		}
		if(theBank.getTheBadgeXAUUSD().getRoot() == null) {
			theBank.deserializeXAUUSAD();
		}
		if(new File("Datas/dataBITCOIN").length() > 0) {
			theBank.deserializeBITCOIN();
		}
//		System.out.println("Caca");
//		System.out.println(theBank.getTheActionUS30().getRoot().getValue().getPrice());
//		System.out.println(theBank.getTheBadgeEURUSD().getRoot().getDate().getPrice());
		System.out.println(theBank.getTheActionUS30().getTheActions()[0].getPrice());
		
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
		int i = 0;
		while((line = b.readLine()) != null) {
			String lineNew = line.replaceFirst(",", "");
			String[] infoBank = lineNew.split(" ");
			System.out.println(i);
			if(infoBank[0].equalsIgnoreCase("#US30")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));	
				theBank.getTheActionUS30().insert(theAction);
				theBank.getTheActionUS30().getTheActions()[i] = theAction;
//				theBank.serializableUS30();
			}else if(infoBank[0].equalsIgnoreCase("#USSPX500")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionUSSPX500().insert(theAction);
				theBank.getTheActionUSSPX500().getTheActions()[i] = theAction;
//				theBank.serializableUSSPX500();
			}else if(infoBank[0].equalsIgnoreCase("#AAPL")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionAAPL().insert(theAction);
				theBank.getTheActionAAPL().getTheActions()[i] = theAction;
//				theBank.serializableAAPL();
			}else if(infoBank[0].equalsIgnoreCase("#MSFT")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionMSFT().insert(theAction);
				theBank.getTheActionMSFT().getTheActions()[i] = theAction;
//				theBank.serializableMSFT();
			}else if(infoBank[0].equalsIgnoreCase("WTI")) {
				Action theAction = new Action(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.getTheActionWTI().insert(theAction);
				theBank.getTheActionWTI().getTheActions()[i] = theAction;
//				theBank.serializableWTI();
			}else if(infoBank[0].equalsIgnoreCase("XAUUSD")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeXAUUSD().insert(theBadge);
					theBank.getTheBadgeXAUUSD().getTheBadges()[i] = theBadge;
//					theBank.serializableXAUUSD();
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(infoBank[0].equalsIgnoreCase("EURUSD")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeEURUSD().insert(theBadge);
					theBank.getTheBadgeEURUSD().getTheBadges()[i] = theBadge;
//					theBank.serializableEURUSD();
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(infoBank[0].equalsIgnoreCase("GBPCAD")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeGBPCAD().insert(theBadge);
					theBank.getTheBadgeGBPCAD().getTheBadges()[i] = theBadge;
//					theBank.serializableGBPCAD();
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(infoBank[0].equalsIgnoreCase("USDJPY")) {
				Badge theBadge = new Badge(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				try {
					theBank.getTheBadgeUSDJPY().insert(theBadge);
					theBank.getTheBadgeUSDJPY().getTheBadges()[i] = theBadge;
//					theBank.serializableUSDJPY();
				} catch (ElementExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Bitcoin theBitcoin = new Bitcoin(infoBank[0], parseDate(infoBank), Double.parseDouble(infoBank[3]));
				theBank.addBitCoin(theBitcoin);
//				theBank.serializableBITCOIN();
			}
			i++;
		}
		theBank.serializableUS30();
	
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
		try {
			Main theMain = new Main();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
