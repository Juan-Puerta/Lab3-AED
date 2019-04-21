package world;

import java.util.LinkedList;

import collections.AvlTree;
import collections.NodeAVL;
import collections.RebBlackTree;

public class Bank {
	
	private AvlTree<Action> theActions;
	private RebBlackTree<Badge> theBadges;
	private Bitcoin theBitcoins;
	
	public Bank() {
		super();
	}

	public AvlTree<Action> getTheActions() {
		return theActions;
	}

	public void setTheActions(AvlTree<Action> theActions) {
		this.theActions = theActions;
	}

	public RebBlackTree<Badge> getTheBadges() {
		return theBadges;
	}

	public void setTheBadges(RebBlackTree<Badge> theBadges) {
		this.theBadges = theBadges;
	}

	public Bitcoin getTheBitcoins() {
		return theBitcoins;
	}

	public void setTheBitcoins(Bitcoin theBitcoins) {
		this.theBitcoins = theBitcoins;
	}

	
	
	
}
