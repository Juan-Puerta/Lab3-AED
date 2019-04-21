package world;

import java.util.LinkedList;

import collections.AvlTree;
import collections.NodeAVL;
import collections.RebBlackTree;

public class Bank {
	
	private AvlTree<Action> theActions;
	private RebBlackTree<Badge> theBadges;
	private LinkedList<Bitcoin> theBitcoins;
	
	public Bank(AvlTree<Action> theActions, RebBlackTree<Badge> theBadges, LinkedList<Bitcoin> theBitcoins) {
		super();
		this.theActions = theActions;
		this.theBadges = theBadges;
		this.theBitcoins = theBitcoins;
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

	public LinkedList<Bitcoin> getTheBitcoins() {
		return theBitcoins;
	}

	public void setTheBitcoins(LinkedList<Bitcoin> theBitcoins) {
		this.theBitcoins = theBitcoins;
	}

	
	
	
}
