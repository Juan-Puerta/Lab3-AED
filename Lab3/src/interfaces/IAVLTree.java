package interfaces;

import collections.*;

public interface IAVLTree<T extends Comparable<T>>{

	boolean insert(T date);
	boolean delete(T date);
	boolean search(T date);
	
}
