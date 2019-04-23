package world;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;

import collections.AvlTree;
import collections.NodeAVL;
import collections.RebBlackTree;

public class Bank {
	
	//Actions
	private AvlTree<Action> theActionUS30;
	private AvlTree<Action> theActionUSSPX500;
	private AvlTree<Action> theActionAAPL;
	private AvlTree<Action> theActionMSFT;
	private AvlTree<Action> theActionWTI;
	
	//Badges
	private RebBlackTree<Badge> theBadgeXAUUSD;
	private RebBlackTree<Badge> theBadgeEURUSD;
	private RebBlackTree<Badge> theBadgeGBPCAD;
	private RebBlackTree<Badge> theBadgeUSDJPY;
	
	//Bitcoin
	private Bitcoin theBitcoin;
	
	public Bank() {
		theActionUS30 = new AvlTree<Action>();
		theActionUSSPX500 = new AvlTree<Action>();
		theActionAAPL = new AvlTree<Action>();
		theActionMSFT = new AvlTree<Action>();
		theActionWTI = new AvlTree<Action>();
		
		theBadgeXAUUSD = new RebBlackTree<Badge>();
		theBadgeEURUSD = new RebBlackTree<Badge>();
		theBadgeGBPCAD = new RebBlackTree<Badge>();
		theBadgeUSDJPY = new RebBlackTree<Badge>();
		
		theBitcoin = null;
	}

	public void addBitCoin(Bitcoin newBitcoin) {
		
		if(theBitcoin == null) {
			theBitcoin = newBitcoin;
		}else {
			newBitcoin.setNext(theBitcoin);
			theBitcoin = newBitcoin;
		}
		
	}
	
	public Bitcoin search(Date date) {
		
		if(date != null) {
			
			boolean found = false;
			Bitcoin aux = theBitcoin;
			
			while(theBitcoin != null && !found) {
				
				if(aux.getDate().compareTo(date) == 0) {
					found = true;
				}else {
					aux = aux.getNext();
				}
				
			}
			return aux;
		}else {
			return null;
		}
		
	}
	
	public AvlTree<Action> getTheActionUS30() {
		return theActionUS30;
	}

	public void setTheActionUS30(AvlTree<Action> theActionUS30) {
		this.theActionUS30 = theActionUS30;
	}

	public AvlTree<Action> getTheActionUSSPX500() {
		return theActionUSSPX500;
	}

	public void setTheActionUSSPX500(AvlTree<Action> theActionUSSPX500) {
		this.theActionUSSPX500 = theActionUSSPX500;
	}

	public AvlTree<Action> getTheActionAAPL() {
		return theActionAAPL;
	}

	public void setTheActionAAPL(AvlTree<Action> theActionAAPL) {
		this.theActionAAPL = theActionAAPL;
	}

	public AvlTree<Action> getTheActionMSFT() {
		return theActionMSFT;
	}

	public void setTheActionMSFT(AvlTree<Action> theActionMSFT) {
		this.theActionMSFT = theActionMSFT;
	}

	public AvlTree<Action> getTheActionWTI() {
		return theActionWTI;
	}

	public void setTheActionWTI(AvlTree<Action> theActionWTI) {
		this.theActionWTI = theActionWTI;
	}

	public RebBlackTree<Badge> getTheBadgeXAUUSD() {
		return theBadgeXAUUSD;
	}

	public void setTheBadgeXAUUSD(RebBlackTree<Badge> theBadgeXAUUSD) {
		this.theBadgeXAUUSD = theBadgeXAUUSD;
	}

	public RebBlackTree<Badge> getTheBadgeEURUSD() {
		return theBadgeEURUSD;
	}

	public void setTheBadgeEURUSD(RebBlackTree<Badge> theBadgeEURUSD) {
		this.theBadgeEURUSD = theBadgeEURUSD;
	}

	public RebBlackTree<Badge> getTheBadgeGBPCAD() {
		return theBadgeGBPCAD;
	}

	public void setTheBadgeGBPCAD(RebBlackTree<Badge> theBadgeGBPCAD) {
		this.theBadgeGBPCAD = theBadgeGBPCAD;
	}

	public RebBlackTree<Badge> getTheBadgeUSDJPY() {
		return theBadgeUSDJPY;
	}

	public void setTheBadgeUSDJPY(RebBlackTree<Badge> theBadgeUSDJPY) {
		this.theBadgeUSDJPY = theBadgeUSDJPY;
	}

	public Bitcoin getTheBitcoin() {
		return theBitcoin;
	}

	public void setTheBitcoin(Bitcoin theBitcoin) {
		this.theBitcoin = theBitcoin;
	}	
	
	
	public void serializE() throws Exception{
		
		ObjectOutputStream serializeAAPL = new ObjectOutputStream(new FileOutputStream("Datas/dataAAPL.txt"));
		serializeAAPL.writeObject(theActionAAPL.getRoot());
		ObjectOutputStream serializeBITCOIN = new ObjectOutputStream(new FileOutputStream("Datas/dataBITCOIN.txt"));
		serializeBITCOIN.writeObject(theBitcoin);
		ObjectOutputStream serializeEURUSD = new ObjectOutputStream(new FileOutputStream("Datas/dataEURUSD.txt"));
		serializeEURUSD.writeObject(theBadgeEURUSD.getRoot());
		ObjectOutputStream serializeGBPCAD = new ObjectOutputStream(new FileOutputStream("Datas/dataGBPCAD.txt"));
		serializeGBPCAD.writeObject(theBadgeGBPCAD.getRoot());
		ObjectOutputStream serializeMSFT = new ObjectOutputStream(new FileOutputStream("Datas/dataMSFT.txt"));
		serializeMSFT.writeObject(theActionMSFT.getRoot());
		ObjectOutputStream serializeUS30 = new ObjectOutputStream(new FileOutputStream("Datas/dataUS30.txt"));
		serializeUS30.writeObject(theActionUS30);
		ObjectOutputStream serializeUSDJPY = new ObjectOutputStream(new FileOutputStream("Datas/dataUSDJPY.txt"));
		serializeUSDJPY.writeObject(theBadgeUSDJPY);
		ObjectOutputStream serializeUSSPX500 = new ObjectOutputStream(new FileOutputStream("Datas/dataUSSPX500.txt"));
		serializeUSSPX500.writeObject(theActionUSSPX500);
		ObjectOutputStream serializeWTI = new ObjectOutputStream(new FileOutputStream("Datas/dataWTI.txt"));
		serializeWTI.writeObject(theActionWTI);
		ObjectOutputStream serializeXAUUSD = new ObjectOutputStream(new FileOutputStream("Datas/dataXAUUSD.txt"));
		serializeXAUUSD.writeObject(theBadgeXAUUSD);
		
		serializeAAPL.close();
		serializeBITCOIN.close();
		serializeEURUSD.close();
		serializeGBPCAD.close();
		serializeMSFT.close();
		serializeUS30.close();
		serializeUSDJPY.close();
		serializeUSSPX500.close();
		serializeWTI.close();
		serializeXAUUSD.close();
		
	}


	
	public void deserialize() throws Exception {
		
		ObjectInputStream unserializeAAPL = new ObjectInputStream(new FileInputStream("Datas/dataAAPL.txt"));
		theActionAAPL.setRoot((Action) unserializeAAPL.readObject());
		ObjectInputStream unserializeBITCOIN = new ObjectInputStream(new FileInputStream("Datas/dataBITCOIN.txt"));
		ObjectInputStream unserializeEURUSD = new ObjectInputStream(new FileInputStream("Datas/dataEURUSD.txt"));
		ObjectInputStream unserializeGBPCAD = new ObjectInputStream(new FileInputStream("Datas/dataGBPCAD.txt"));
		ObjectInputStream unserializeMSFT = new ObjectInputStream(new FileInputStream("Datas/dataMSFT.txt"));
		ObjectInputStream unserializeUS30 = new ObjectInputStream(new FileInputStream("Datas/dataUS30.txt"));
		ObjectInputStream unserializeUSDJPY = new ObjectInputStream(new FileInputStream("Datas/dataUSDJPY.txt"));
		ObjectInputStream unserializeUSSPX500 = new ObjectInputStream(new FileInputStream("Datas/dataUSSPX500.txt"));
		ObjectInputStream unserializeWTI = new ObjectInputStream(new FileInputStream("Datas/dataWTI.txt"));
		ObjectInputStream unserializeXAUUSD = new ObjectInputStream(new FileInputStream("Datas/dataXAUUSD.txt"));
		
		
		elBalence = (BalanceGeneral) deserializarObjecto.readObject();
		deserializarObjecto.close();
		
	}
}
