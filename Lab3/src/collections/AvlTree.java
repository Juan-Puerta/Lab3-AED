package collections;

import interfaces.IAVLTree;
import world.Action;

public class AvlTree<T extends Comparable<T>> implements IAVLTree<T>{

	public NodeAVL<T> root;
	private int nodeCount = 0;
	
	public int height() {
		if (root == null) return 0;
		return root.height;
	}
	
	public int size() {
		return nodeCount;
	}
		
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public boolean search(T value) {
		return search(root, value);
	}

	private boolean search(NodeAVL<T> node, T value) {
			    
		if (node == null) {
			return false;
		}
		
		int cmp = value.compareTo(node.value);
	
		if (cmp < 0) {
			return search(node.left, value);
		}
		if (cmp > 0) {
			return search(node.right, value);
		}
		return true;
	}
		
	@Override
	public boolean insert(T value) {
		if (value == null) {
			return false;
		}
		if (!search(root, value)) {
			root = insert(root, value);
			nodeCount++;
			return true;
		}
		return false;
	}
		
	private NodeAVL<T> insert(NodeAVL<T> node, T value) {
			
		if (node == null) {
			return new NodeAVL<T>(value);
		}
		int cmp = value.compareTo(node.value);
			
		if (cmp < 0) {
			node.left = insert(node.left, value);
		}else {
			node.right = insert(node.right, value);
		}
		update(node);
		return balance(node);
	}
		
	private void update(NodeAVL<T> node) {	    
		int leftNodeHeight  = (node.left  == null) ? -1 : node.left.height;
		int rightNodeHeight = (node.right == null) ? -1 : node.right.height;
			
		node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
		node.bf = rightNodeHeight - leftNodeHeight;
	}
		
	private NodeAVL<T> balance(NodeAVL<T> node) {
		
		if (node.bf == -2) {
			if (node.left.bf <= 0) {
				return leftLeftCase(node);
			}else {
				return leftRightCase(node);
			}
		}else if(node.bf == +2) {
			if (node.right.bf >= 0) {
				return rightRightCase(node);
			}else {
				return rightLeftCase(node);
			}
		}
		return node;
	}
		
	private NodeAVL<T> leftLeftCase(NodeAVL<T> node) {
		return rightRotation(node);
	}
		
	private NodeAVL<T> leftRightCase(NodeAVL<T> node) {
		node.left = leftRotation(node.left);
		return leftLeftCase(node);
	}
		
	private NodeAVL<T> rightRightCase(NodeAVL<T> node) {
		return leftRotation(node);
	}
		
	private NodeAVL<T> rightLeftCase(NodeAVL<T> node) {
		node.right = rightRotation(node.right);
		return rightRightCase(node);
	}
		
	private NodeAVL<T> leftRotation(NodeAVL<T> node) {
		NodeAVL<T> newParent = node.right;
		node.right = newParent.left;
		newParent.left = node;
		update(node);
		update(newParent);
		return newParent;
	}
		
	private NodeAVL<T> rightRotation(NodeAVL<T> node) {
		NodeAVL<T> newParent = node.left;
		node.left = newParent.right;
		newParent.right = node;
		update(node);
		update(newParent);
		return newParent;
	}
	
	@Override
	public boolean delete(T elem) {
		
		if (elem == null) return false;
		
		if (search(root, elem)) {
			root = remove(root, elem);
			nodeCount--;
			return true;
		}
		return false;
	}
		
	private NodeAVL<T> remove(NodeAVL<T> node, T elem) {
			    
		if (node == null) return null;
		int cmp = elem.compareTo(node.value);
		
		if (cmp < 0) {
			node.left = remove(node.left, elem);
		}else if(cmp > 0) {
			node.right = remove(node.right, elem);
		} else {
			if (node.left == null) {
				return node.right;
			}else if(node.right == null) {
				return node.left;
			}else {
				if (node.left.height > node.right.height) { 
					T successorValue = findMax(node.left);
					node.value = successorValue;
					node.left = remove(node.left, successorValue);
				}else {
					T successorValue = findMin(node.right);
					node.value = successorValue;    
					node.right = remove(node.right, successorValue);
				}
			}
		}
		update(node);
		return balance(node);
		
	}
		
			
	private T findMin(NodeAVL<T> node) {
		while(node.left != null) 
			node = node.left;
		return node.value;
	}
		
	private T findMax(NodeAVL<T> node) {
		while(node.right != null) 
			node = node.right;
		return node.value;
	}
		
//	public java.util.Iterator<T> iterator () {
//		
//		final int expectedNodeCount = nodeCount;
//		final java.util.Stack<NodeAVL<T>> stack = new java.util.Stack<>();
//		stack.push(root);
//		
//		return new java.util.Iterator<T> () {
//			NodeAVL<T> trav = root;
//			@Override 
//			public boolean hasNext() {
//				if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();        
//				return root != null && !stack.isEmpty();
//			}
//			@Override 
//			public T next () {
//			        
//				if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
//		
//				while(trav != null && trav.left != null) {
//					stack.push(trav.left);
//					trav = trav.left;
//				}
//			        
//				NodeAVL<T> node = stack.pop();
//			        
//				if (node.right != null) {
//					stack.push(node.right);
//					trav = node.right;
//				}
//			        
//				return node.value;
//			}
//			@Override 
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}      
//		};
//	}
		
	public void preOrden(NodeAVL<T> root) {
		if(root != null) {
			System.out.print(root.getValue()+", ");
			preOrden(root.getLeft());
			preOrden(root.getRight());
		}
	}
	
		
	public NodeAVL<T> getRoot() {
		return root;
	}
		

		
		
	public void setRoot(NodeAVL<T> value) {
		this.root = value;
	}

	public boolean validateBSTInvarient(NodeAVL<T> node) {
		if (node == null) return true;
			T val = node.value;
			boolean isValid = true;
			if (node.left  != null) isValid = isValid && node.left.value.compareTo(val)  < 0;
			if (node.right != null) isValid = isValid && node.right.value.compareTo(val) > 0;
			return isValid && validateBSTInvarient(node.left) && validateBSTInvarient(node.right);
	}
	

}
