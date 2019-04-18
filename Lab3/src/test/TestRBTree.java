package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.RebBlackTree;
import exceptions.ElementDontExist;
import exceptions.ElementExist;

class TestRBTree {

	private RebBlackTree<Integer> integerTree;
	private RebBlackTree<String> stringTree;
	private RebBlackTree<Double> doubleTree;
	
	private void stageOne() throws ElementExist {
		integerTree = new RebBlackTree<Integer>();
		integerTree.insert(10);
		integerTree.insert(5);
		integerTree.insert(15);
		integerTree.insert(3);
		integerTree.insert(8);
		integerTree.insert(12);
		integerTree.insert(17);
	}
	
	private void stageTwo() throws ElementExist {
		stringTree = new RebBlackTree<String>();
		stringTree.insert("m");
		stringTree.insert("f");
		stringTree.insert("r");
		stringTree.insert("c");
		stringTree.insert("e");
		stringTree.insert("o");
		stringTree.insert("z");
	}
	
	private void stageThree() throws ElementExist {
		doubleTree = new RebBlackTree<Double>();
		doubleTree.insert(10.0);
		doubleTree.insert(5.0);
		doubleTree.insert(15.0);
		doubleTree.insert(3.0);
		doubleTree.insert(8.0);
		doubleTree.insert(12.0);
		doubleTree.insert(17.0);
	}

	@Test
	public void testInsertStageOne() throws ElementExist {
		stageOne();
		integerTree.insert(20);
		assertEquals(true, integerTree.search(integerTree.getRoot(), 20));
		integerTree.insert(22);
		assertEquals(true, integerTree.search(integerTree.getRoot(), 22));
	}
	
	@Test
	public void testInsertStageTwo() throws ElementExist {
		stageTwo();
		stringTree.insert("a");
		assertEquals(true, stringTree.search(stringTree.getRoot(), "a"));
		stringTree.insert("q");
		assertEquals(true, stringTree.search(stringTree.getRoot(), "q"));
	}

	@Test
	public void testInsertStageThree() throws ElementExist {
		stageThree();
		doubleTree.insert(20.0);
		assertEquals(true, doubleTree.search(doubleTree.getRoot(), 20.0));
		doubleTree.insert(22.0);
		assertEquals(true, doubleTree.search(doubleTree.getRoot(), 22.0));
	}
	
	@Test
	public void testDeleteStageOne() throws ElementExist, ElementDontExist {
		stageOne();
		integerTree.delete(10);
		assertEquals(8, (int)integerTree.getRoot().getDate());
		integerTree.delete(8);
		assertEquals(5, (int)integerTree.getRoot().getDate());
	}
	
	@Test
	public void testDeleteStageTwo() throws ElementExist, ElementDontExist {
		stageTwo();
		stringTree.delete("m");
		assertEquals("f", ""+stringTree.getRoot().getDate());
		stringTree.delete("f");
		assertEquals("e", ""+stringTree.getRoot().getDate());
	}
	
	@Test
	public void testDeleteStageThree() throws ElementExist, ElementDontExist {
		stageThree();
		doubleTree.delete(10.0);
		assertEquals(8.0, (double)doubleTree.getRoot().getDate());
		doubleTree.delete(8.0);
		assertEquals(5.0, (double)doubleTree.getRoot().getDate());
	}
	
	@Test
	public void testSearchStageOne() throws ElementExist, ElementDontExist {
		stageOne();
		integerTree.insert(333);
		assertTrue(integerTree.search(integerTree.getRoot(),333));
//		integerTree.delete(3);
//		assertNull(integerTree.search(integerTree.getRoot(),3));
	}
	
	@Test
	public void testSearchStageTwo() throws ElementExist, ElementDontExist {
		stageTwo();
		stringTree.insert("a");
		assertTrue(stringTree.search(stringTree.getRoot(),"a"));
//		stringTree.delete("o");
//		assertFalse(stringTree.search(stringTree.getRoot(),"o"));
	}
	
	@Test
	public void testSearchStageThree() throws ElementExist, ElementDontExist {
		stageThree();
		doubleTree.insert(333.0);
		assertTrue(doubleTree.search(doubleTree.getRoot(),333.0));
//		doubleTree.delete(15.0);
//		assertFalse(doubleTree.search(doubleTree.getRoot(),15.0));
	}
	
}
