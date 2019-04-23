package world;

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
}
