package interfaces;

import exceptions.*;

public interface IRBTree<T> {

	void insert(T date) throws ElementExist;
	void delete(T date) throws ElementDontExist;
	T search(T date);
	
}
