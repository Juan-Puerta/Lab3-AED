package collections;

import java.util.List;
import exceptions.*;

public class NodeRB<T extends Comparable<T>> {

	public static final int BLACK = 1;
	public static final int RED = 0;


	private NodeRB<T> rightSon;
	private NodeRB<T> leftSon;
	private NodeRB<T> father;

	private T date;
	private int color;
	
	public NodeRB(T date){
		this.date = date;
		color = RED;
		setRightSon( new NodeRB<T>( ) );
		setLeftSon( new NodeRB<T>( ) );
		father = null;
	}
	
	public NodeRB(){
		this.date = null;
		color = BLACK;
		father = null;
	}
	
	///////////////////////////////////////
	//PRIMARY METHODS
	///////////////////////////////////////
	
	public NodeRB<T> insert(NodeRB<T> node ) throws ElementExist{
		insertBST( node );
		Root r = new Root( null );
		node.insertRedRootCase( r );
		return r.answer;
	}
	
	public NodeRB<T> delete( ){
		NodeRB<T> aux = !sheetLeftSon( ) ? leftSon.getHigher( ) : this.getLess( );
		setDate( aux );
		Root r = new Root( null );
		aux.deleteRedBlack( r );
		return r.answer;
	}
	
	///////////////////////////////////////
	//INSERT'S CASES
	///////////////////////////////////////
	
	private void insertBST( NodeRB<T> node ) throws ElementExist{
		if( date.compareTo( node.getInfoNode( ) ) == 0 ){
			throw new ElementExist( "El elemento " + node.getInfoNode( ).toString( ) + " ya existe en el árbol" );
		}else if( date.compareTo( node.getInfoNode( ) ) < 0 ) {
			if( sheetRightSon( ) ){
				rightSon = node;
				node.setFather( this );
			}else {
				rightSon.insertBST( node );
			}
		}else {
			if( sheetLeftSon( ) ){
				leftSon = node;
				node.setFather( this );
			}else {
				leftSon.insertBST( node );
			}
		}
	}

	private NodeRB<T> insertRedRootCase( Root r ){
		if( father == null ){
			color = BLACK;
			r.answer = this;
		}else {
			insertCaseOne( r );
		}
		return r.answer;
	}

	private void insertCaseOne( Root r ){
		if( father.getColor( ) == RED )
			insertCaseTwo( r );
		else
		r.answer = null;
	}

	private void insertCaseTwo( Root r ){
		NodeRB<T> uncle = getUncle( );
		NodeRB<T> grandFather = father.getFather( );
		r.answer = null;
		
		if(!uncle.isSheet( ) && uncle.getColor( ) == RED){
			getFather( ).setColor( BLACK );
			uncle.setColor( BLACK );
			grandFather.setColor( RED );
			grandFather.insertRedRootCase( r );
		}else {
			insertCaseThreeLine( r );
		}
	}

	private void insertCaseThreeLine( Root r ){
		NodeRB<T> grandFather = father.getFather( );
		r.answer = null;
		
		if( father.isRightSon( this ) && grandFather.isLeftSon( father ) ){
			grandFather.setLeftSon( father.rotateLeft( ) );
			leftSon.insertCaseThreeTriangle( r );
		}else if( father.isLeftSon( this ) && grandFather.isRightSon( father ) ) {
			grandFather.setRightSon( father.rotateRight( ) );
			rightSon.insertCaseThreeTriangle( r );
		}else {
			insertCaseThreeTriangle( r );
		}
	}

	private void insertCaseThreeTriangle( Root r ){
		NodeRB<T> grandFather = father.getFather( );
	
		father.setColor( BLACK );
		grandFather.setColor( RED );
		
		if( father.isLeftSon( this ) && grandFather.isLeftSon( father ) ){
			if( grandFather.getFather( ) == null ) {
				grandFather.rotateRight( );
			}else if( grandFather.getFather( ).isRightSon( grandFather ) ) {
				grandFather.getFather( ).setRightSon( grandFather.rotateRight( ) );
			}else {
				grandFather.getFather( ).setLeftSon( grandFather.rotateRight( ) );
			}
		}else {
			if( grandFather.getFather( ) == null ) {
				grandFather.rotateLeft( );
			}else if( grandFather.getFather( ).isRightSon( grandFather ) ) {
				grandFather.getFather( ).setRightSon( grandFather.rotateLeft( ) );
			}else {
				grandFather.getFather( ).setLeftSon( grandFather.rotateLeft( ) );
			}
		}
		r.answer = father;
	}
	
	///////////////////////////////////////
	//DELETE'S CASES
	///////////////////////////////////////
	
	private void deleteSons( ){
		rightSon = new NodeRB<T>( );
		leftSon = new NodeRB<T>( );
	}

	private void deleteRedBlack( Root r ){
		NodeRB<T> son = !sheetRightSon( ) ? rightSon : leftSon;
	
		int deleteColor = getColor();
		int colorSon = son.getColor();
		
		setDate( son );
		deleteSons( );
		
		if( colorSon == RED ){
			r.answer = this;
			return;
		}else if( colorSon == BLACK && deleteColor == RED ) {
			r.answer = this;
			setColor( BLACK );
		}else {
			deleteCaseOne( r );
		}
	}

	private void deleteCaseOne( Root r ){
		if( father != null ) {
			this.deleteCaseTwo( r );
		}else {
			r.answer = null;
		}
	}

	private void deleteCaseTwo( Root r ){
		NodeRB<T> brother = getBrother( );
	
		if( brother.color == RED ){
			father.color = RED;
			brother.color = BLACK;
		
			r.answer = brother;
			
			NodeRB<T> grandFather = father.father;
			if( father.isRightSon( this ) ){
				if( grandFather != null ){
					if( grandFather.isRightSon( father ) ) {
						grandFather.setRightSon( father.rotateRight( ) );
					}else {
						grandFather.setLeftSon( father.rotateRight( ) );
					}
				}else {
					father.rotateRight( );
				}
			}else {
				if( grandFather != null ){
					if( grandFather.isRightSon( father ) ) {
						grandFather.setRightSon( father.rotateLeft( ) );
					}else {
						grandFather.setLeftSon( father.rotateLeft( ) );
					}
				}else {
					father.rotateLeft( );
				}
			}
	}
		deleteCaseThree( r );
	}

	private void deleteCaseThree( Root r ){
		NodeRB<T> hermano = getBrother( );
		
		if( father.color == BLACK && hermano.color == BLACK && hermano.blackSons( ) ){
			hermano.setColor( RED );
			father.deleteCaseOne( r );
		}else {
			deleteCaseFour( r );
		}
	}

	private void deleteCaseFour( Root r ){
		NodeRB<T> brother = getBrother( );
		
		if( father.color == RED && brother.color == BLACK && brother.blackSons( ) ){
			brother.setColor( RED );
			father.setColor( BLACK );
		}else {
			deleteCaseFive( r );
		}
	}

	private void deleteCaseFive( Root r ){
		NodeRB<T> brother = getBrother( );
	
	if( father.isLeftSon( this ) && brother.color == BLACK && !brother.blackLeftSon( ) && brother.blackRightSon( ) ){
		brother.color = RED;
		brother.leftSon.color = BLACK;
		father.setRightSon( brother.rotateRight( ) );
	}else if( father.isRightSon( this ) && brother.color == BLACK && !brother.blackRightSon( ) && brother.blackLeftSon( ) ) {
		brother.color = RED;
		brother.rightSon.color = BLACK;
		father.setLeftSon( brother.rotateLeft( ) );
	}
	deleteCaseSix( r );
	}

	private void deleteCaseSix( Root r ){
	
		NodeRB<T> brother = getBrother( );
		
		brother.color = father.color;
		father.color = BLACK;
		NodeRB<T> grandFather = father.father;
		
		r.answer = brother;
		
		if( father.isLeftSon( this ) ){
			brother.rightSon.color = BLACK;
		
			if( grandFather != null ){
				if( grandFather.isRightSon( father ) ) {
					grandFather.setRightSon( father.rotateLeft( ) );
				}else {
					grandFather.setLeftSon( father.rotateLeft( ) );
				}
			}else {
				father.rotateLeft( );
			}
		}
		else {
			brother.leftSon.color = BLACK;
		
			if( grandFather != null ) {
				if( grandFather.isRightSon( father ) ) {
					grandFather.setRightSon( father.rotateRight( ) );
				}else {
					grandFather.setLeftSon( father.rotateRight( ) );
				}
			}else {
				father.rotateRight( );
			}
		}
	}
	
	///////////////////////////////////////
	//ROTATIONS
	///////////////////////////////////////
	
	private NodeRB<T> rotateLeft( ){
		if( sheetRightSon( ) ) {
			return this;
		}else {
			NodeRB<T> aux = rightSon;
			setRightSon( aux.getLeftSon( ) );
			aux.setFather( father );
			aux.setLeftSon( this );
			return aux;
		}
	}

	private NodeRB<T> rotateRight( ){
		if( sheetLeftSon( ) ) {
			return this;
		}else {
			NodeRB<T> aux = leftSon;
			setLeftSon( aux.getRightSon( ) );
			aux.setFather( father );
			aux.setRightSon( this );
			return aux;
		}
	}
	
	///////////////////////////////////////
	//GETS
	///////////////////////////////////////
	
	public NodeRB<T> getFather( ){
		return father;
	}

	public NodeRB<T> getUncle( ){
		
		if(father == null || father.father == null){
			return null;
		}else {
			if(father.father.isRightSon(father)) {
				return father.father.leftSon;
			}else {
				return father.father.rightSon;
			}
		}

	}


	public int getColor(){
		return color;
	}


	public NodeRB<T> getRightSon( ){
		return rightSon;
	}


	public boolean isRightSon( NodeRB<T> node ){
		return rightSon == node;
	}


	public NodeRB<T> getLeftSon( ){
		return leftSon;
	}

	public boolean isLeftSon( NodeRB<T> node ){
		return leftSon == node;
	}

	public boolean sheetRightSon( ){
		return rightSon.date == null;
	}

	public boolean sheetLeftSon( ){
		return leftSon.date == null;
	}

	public NodeRB<T> getHigher( ){
		return sheetRightSon( ) ? this : rightSon.getHigher( );
	}

	public NodeRB<T> getLess( ){
		return sheetLeftSon( ) ? this : leftSon.getLess( );
	}

	public void preOrden( List<T> preorden ){
		preorden.add( date );
		if( !sheetLeftSon( ) )
			leftSon.preOrden( preorden );
		if( !sheetRightSon( ) )
			rightSon.preOrden( preorden );
	}

	public boolean isSheet( ){
		return date == null;
	}


	public int getWeight( ){
		return isSheet( ) ? 0 : 1 + rightSon.getWeight( ) + leftSon.getWeight( );
	}


	public void getSheets( List<NodeRB<T>> sheets ){
		if(isSheet( )) {
			sheets.add(this);
		}else {
			if(!sheetRightSon()) {
				rightSon.getSheets(sheets);
			}
			if( !sheetLeftSon()) {
				leftSon.getSheets(sheets);
			}
		}
	}

	public int getHeight( ){
		if( isSheet( ) ) {
			return 0;
		}
		int a1 = leftSon.getHeight( );
		int a2 = rightSon.getHeight( );
		return ( a1 >= a2 ) ? a1 + 1 : a2 + 1;
	}

	public boolean exist( T e ){
		try{
			getNode( e );
			return true;
		}catch(ElementDontExist e1) {
			return false;
		}
	}

	public NodeRB<T> getNode( T date ) throws ElementDontExist{
		int comp = date.compareTo( this.date );
		if( comp == 0 ) {
			return this;
		}else if( comp < 0 ) {
			if( !sheetLeftSon( ) ) {
				return leftSon.getNode( date );
			}else {
				throw new ElementDontExist( "El elemento buscado no existe" );
			}
		}else {
			if( !sheetRightSon( ) ) {
				return rightSon.getNode( date );
			}else {
				throw new ElementDontExist( "El elemento buscado no existe" );
			}
		}
	}

	public T getInfoNode(){
		return date;
	}

	public boolean blackRightSon( ){
		return rightSon.color == BLACK;
	}
	
	public boolean blackLeftSon( ){
		return leftSon.color == BLACK;
	}
	
	public boolean blackSons( ){
		return blackRightSon( ) && blackLeftSon( );
	}
	
	public NodeRB<T> getBrother( ){
		if( father == null )
			return null;
		else
			return father.isRightSon( this ) ? father.leftSon : father.rightSon;
	}
	
	///////////////////////////////////////
	//SETS
	///////////////////////////////////////
	
	private void setFather( NodeRB<T> father ){
		this.father = father;
	}

	public void setColor( int color ){
		this.color = color;
	}

	private void setRightSon( NodeRB<T> son ){
		if( son != null )
		son.setFather( this );
		rightSon = son;
	}


	private void setLeftSon( NodeRB<T> son ){
		if( son != null )
		son.setFather( this );
		leftSon = son;
	}

	private void setDate(NodeRB<T> node){
		if(node.date != null){
			T aux = date;
			date = node.date;
			node.date = aux;
		}else {
			date = null;
			color = BLACK;
			rightSon = leftSon = null;
		}
	}
	
	
	///////////////////////////////////////
	//PRIVATE CLASS
	///////////////////////////////////////
	
	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}


	private class Root{

		private NodeRB<T> answer;
		
		private Root( NodeRB<T> answer ){
			this.answer = answer;
		}
	}
	
}
