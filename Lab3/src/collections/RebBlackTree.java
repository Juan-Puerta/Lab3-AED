package collections;

import java.util.LinkedList;
import java.util.List;
import exceptions.*;
import interfaces.IRBTree;

public class RebBlackTree<T extends Comparable<T>> implements IRBTree<T>{

	private NodeRB<T> root;

	public RebBlackTree(){
		root = null;
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

	public List<T> preorden(){
		List<T> preorden = new LinkedList<T>( );
		if( root != null ) {
			root.preOrden( preorden );
		}
		return preorden;
	}

	public boolean exist(T date){
		return root != null ? root.exist(date) : false;
	}

	public T search(T date){
		try{
			return root != null ? root.getNode(date).getInfoNode() : null;
		}catch( ElementDontExist e ) {
			return null;
		}
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
	
}
