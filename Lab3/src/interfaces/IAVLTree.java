package interfaces;

import collections.*;

public interface IAVLTree<T extends Comparable<T>>{

	void insert(T date);
	void delete(T date);
	T search(T date, NodeAVL<T> root);
	
}
