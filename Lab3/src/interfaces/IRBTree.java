package interfaces;

import collections.NodeRB;
import exceptions.*;

public interface IRBTree<T extends Comparable<T>> {

	void insert(T date) throws ElementExist;
	void delete(T date) throws ElementDontExist;
	boolean search(NodeRB<T> node, T value);
	
}
