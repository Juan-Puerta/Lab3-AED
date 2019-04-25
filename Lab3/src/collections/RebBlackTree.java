package collections;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

import exceptions.*;
import interfaces.IRBTree;
import world.Badge;

public class RebBlackTree<T extends Comparable<T>> implements IRBTree<T>,Serializable{

	private NodeRB<T> root;
	private Badge[] theBadges;
	
	public RebBlackTree(){
		root = null;
		theBadges = new Badge[5000000];
	}
	
	
	public Badge[] getTheBadges() {
		return theBadges;
	}


	public void setTheBadges(Badge[] theBadges) {
		this.theBadges = theBadges;
	}


	public void insert(T date) throws ElementExist {
		NodeRB<T> node = new NodeRB<T>( date );

		NodeRB<T> r2 = null;

		if( root == null ){
			root = node;
			root.setColor( NodeRB.BLACK );
		}else {
		r2 = root.insert( node );
		}
	
		root = r2 != null && r2.getFather() == null ? r2 : root;
	}

	public void delete( T date ) throws ElementDontExist {
		if( root == null ) {
			throw new ElementDontExist( "El árbol se encuentra vacio" );
		}
		if( root.getInfoNode().compareTo( date ) == 0 && root.sheetRightSon() && root.sheetLeftSon()) {
			root = null;
		}else {
			NodeRB<T> r2 = root.getNode( date ).delete( );
			root = r2 != null && r2.getFather( ) == null ? r2 : root;
		}
	}

	public void preorden(NodeRB<T> root){
		
		if(root != null) {
			System.out.print(root.getDate()+""+root.getColor()+", ");
			if(root.getLeftSon() != null) {
				preorden(root.getLeftSon());
			}
			if(root.getRightSon() != null) {
				preorden(root.getRightSon());
			}
		}
		
	}

	public boolean exist(T date){
		return root != null ? root.exist(date) : false;
	}

	public boolean search(NodeRB<T> node, T value) {
	    
		if (node == null) {
			return false;
		}
		
		int cmp = value.compareTo(node.getDate());
	
		if (cmp < 0) {
			return search(node.getLeftSon(), value);
		}
		if (cmp > 0) {
			return search(node.getRightSon(), value);
		}
		return true;
	}

	public NodeRB<T> getRoot(){
		return root;
	}

	public int getWeight(){
		return root == null ? 0 : root.getWeight();
	}

	public int getHeight(){
		return root == null ? 0 : root.getHeight();
	}

	public T getLess(){
		return root == null ? null : root.getLess().getInfoNode();
	}

	public T getHigher(){
		return root == null ? null : root.getHigher( ).getInfoNode( );
	}

	public void setRoot(NodeRB<T> date) {
		this.root = date;
	}
	
	
	
}
