package collections;

import interfaces.IAVLTree;

public class AvlTree<T extends Comparable<T>> implements IAVLTree<T> {

	private NodeAVL<T> root;
	
	public AvlTree() {
		// TODO Auto-generated constructor stub
		this.root = null;
	}
	
	/////////////////////////////////////////////////
	//PRIMARY METHODS
	/////////////////////////////////////////////////
	
	@Override
	public void insert(T date) {
		// TODO Auto-generated method stub
		NodeAVL<T> newElement = new NodeAVL<T>(date);
		if(root == null) {
			root = newElement;
		}else {
			root = insertAVL(newElement, root);
		}
	}

	@Override
	public void delete(T date) {
		// TODO Auto-generated method stub
		root = deleteAVL(date, root);
	}

	@Override
	public T search(T date, NodeAVL<T> root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return null;
		}else if(root.getDate().compareTo(date) == 0) {
			return root.getDate();
		}else if(root.getDate().compareTo(date) < 0) {
			return search(date, root.getRightSon());
		}else {
			return search(date, root.getLeftSon());
		}
	}
	
	/////////////////////////////////////////////////
	//DELETE'S CASES
	/////////////////////////////////////////////////
	
	private NodeAVL<T> deleteAVL(T date, NodeAVL<T> root){
		
		if(root == null) {
			return null;
		}else {
			if(root.getDate().compareTo(date) < 0) {
				root.setRightSon(deleteAVL(date, root.getRightSon()));
			}else if(root.getDate().compareTo(date) > 0) {
				root.setLeftSon(deleteAVL(date, root.getLeftSon()));
			}else if(root.getLeftSon() == null) {
				root = root.getRightSon();
			}else if(root.getRightSon() == null) {
				root = root.getLeftSon();
			}else if(getFE(root.getLeftSon()) > getFE(root.getRightSon())) {
				root = rotateRight(root);
				root.setLeftSon(deleteAVL(date, root.getLeftSon()));
			}else {
				root = rotateLeft(root);
				root.setRightSon(deleteAVL(date, root.getRightSon()));
			}
			
			if(root != null) {
				root.setFeNode(getFE(root.getLeftSon()) + getFE(root.getRightSon() ));
			}
		}
		return root;
	}

	/////////////////////////////////////////////////
	//INSERT'S CASES
	/////////////////////////////////////////////////
	
	private NodeAVL<T> insertAVL(NodeAVL<T> elemInsert, NodeAVL<T> subTree){
		
		NodeAVL<T> newFather = subTree;
		if(elemInsert.getDate().compareTo(subTree.getDate()) <0) {
			if(subTree.getLeftSon() == null) {
				subTree.setLeftSon(elemInsert);
			}else {
				subTree.setLeftSon(insertAVL(elemInsert, subTree.getLeftSon()));
				if(getFE(subTree.getLeftSon())-getFE(subTree.getRightSon()) == 2) {
					if(elemInsert.getDate().compareTo(subTree.getLeftSon().getDate()) < 0) {
						newFather = rotateLeft(subTree);
					}else {
						newFather = rotateDobleLeft(subTree);
					}
				}
			}
		}else if(elemInsert.getDate().compareTo(subTree.getDate()) > 0){
			if(subTree.getRightSon() == null) {
				subTree.setRightSon(elemInsert);
			}else {
				subTree.setRightSon(insertAVL(elemInsert, subTree.getRightSon()));
				if(getFE(subTree.getRightSon())-getFE(subTree.getLeftSon()) == 2) {
					if(elemInsert.getDate().compareTo(subTree.getRightSon().getDate()) > 0) {
						newFather = rotateRight(subTree);
					}else {
						newFather = rotateDobleRight(subTree);
					}
				}
			}
		}else {
			System.out.println("Nodo duplicado");
		}
		if((subTree.getLeftSon() == null) && (subTree.getRightSon() != null)) {
			subTree.setFeNode(subTree.getRightSon().getFeNode()+1);
		}else if((subTree.getLeftSon() != null) && (subTree.getRightSon() == null)) {
			subTree.setFeNode(subTree.getLeftSon().getFeNode()+1);
		}else {
			subTree.setFeNode(Math.max(getFE(subTree.getLeftSon()), getFE(subTree.getRightSon()))+1);
		}
		return newFather;
	}
	
	/////////////////////////////////////////////////
	//CALCULATE "FACTOR DE EQUILIBRIO"
	/////////////////////////////////////////////////
	
	public int getFE(NodeAVL<T> x) {
		if(x == null) {
			return -1;
		}else {
			return x.getFeNode();
		}
	}
	
	/////////////////////////////////////////////////
	//ROTATIONS
	/////////////////////////////////////////////////
	
	public NodeAVL<T> rotateLeft(NodeAVL<T> x){
		NodeAVL<T> auxAvl = x.getLeftSon();
		x.setLeftSon(auxAvl.getRightSon());
		auxAvl.setRightSon(x);
		x.setFeNode(Math.max(getFE(x.getLeftSon()), getFE(x.getRightSon()))+1 );
		auxAvl.setFeNode(Math.max(getFE(auxAvl.getLeftSon()), getFE(auxAvl.getRightSon()))+1 );
		return auxAvl;
	}
	
	public NodeAVL<T> rotateRight(NodeAVL<T> x){
		NodeAVL<T> auxAvl = x.getRightSon();
		x.setRightSon(auxAvl.getLeftSon());
		auxAvl.setLeftSon(x);
		x.setFeNode(Math.max(getFE(x.getLeftSon()), getFE(x.getRightSon()))+1 );
		auxAvl.setFeNode(Math.max(getFE(auxAvl.getLeftSon()), getFE(auxAvl.getRightSon()))+1 );
		return auxAvl;
	}
	
	public NodeAVL<T> rotateDobleLeft(NodeAVL<T> x){
		NodeAVL<T> aux;
		x.setLeftSon(rotateRight(x.getLeftSon()));
		aux = rotateLeft(x);
		return aux;
	}
	
	public NodeAVL<T> rotateDobleRight(NodeAVL<T> x){
		NodeAVL<T> aux;
		x.setRightSon(rotateLeft(x.getRightSon()));
		aux = rotateRight(x);
		return aux;
	}
	
	/////////////////////////////////////////////////
	//GETS AND SETS
	/////////////////////////////////////////////////

	public NodeAVL<T> getRoot() {
		return root;
	}

	public void setRoot(NodeAVL<T> root) {
		this.root = root;
	}
	

}
