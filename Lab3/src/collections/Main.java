package collections;

import java.util.List;

import exceptions.ElementDontExist;
import exceptions.ElementExist;

public class Main {

	public static void main(String[] args) throws ElementExist, ElementDontExist {
		// TODO Auto-generated method stub
		RebBlackTree<Integer> integerTree = new RebBlackTree<Integer>();
		integerTree.insert(10);
		integerTree.insert(5);
		integerTree.insert(15);
		integerTree.insert(3);
		integerTree.insert(8);
		integerTree.insert(12);
		integerTree.insert(17);
//		integerTree.insert(20);
//		integerTree.insert(22);
		
		integerTree.delete(3);
//		integerTree.delete(8);
		
		integerTree.preorden(integerTree.getRoot());
		
	}

}
