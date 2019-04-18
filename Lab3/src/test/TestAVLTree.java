package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.AvlTree;

class TestAVLTree {

	private AvlTree<Integer> integerTree;
	private AvlTree<String> stringTree;
	private AvlTree<Double> doubleTree;
	
	private void stageOne() {
		integerTree = new AvlTree<Integer>();
		integerTree.insert(10);
		integerTree.insert(5);
		integerTree.insert(15);
		integerTree.insert(3);
		integerTree.insert(8);
		integerTree.insert(12);
		integerTree.insert(17);
	}
	
	private void stageTwo() {
		stringTree = new AvlTree<String>();
		stringTree.insert("m");
		stringTree.insert("f");
		stringTree.insert("r");
		stringTree.insert("c");
		stringTree.insert("e");
		stringTree.insert("o");
		stringTree.insert("z");
	}
	
	private void stageThree() {
		doubleTree = new AvlTree<Double>();
		doubleTree.insert(10.0);
		doubleTree.insert(5.0);
		doubleTree.insert(15.0);
		doubleTree.insert(3.0);
		doubleTree.insert(8.0);
		doubleTree.insert(12.0);
		doubleTree.insert(17.0);
	}

	@Test
	public void testInsertStageOne() {
		stageOne();
		integerTree.insert(1);
		integerTree.insert(-1);
		assertEquals(10, (int)integerTree.getRoot().getValue());
		assertEquals(true, (boolean)integerTree.search(1));
		assertEquals(true, (boolean)integerTree.search(-1));
	}
	
	@Test
	public void testInsertStageTwo() {
		stageTwo();
		stringTree.insert("a");
		stringTree.insert("b");
		assertEquals("m", ""+stringTree.getRoot().getValue());
		assertEquals(true, stringTree.search("a"));
		assertEquals(true, stringTree.search("b"));
	}
	
	@Test
	public void testInsertStageThree() {
		stageThree();
		doubleTree.insert(1.0);
		doubleTree.insert(-1.0);
		assertEquals(10.0, (double)doubleTree.getRoot().getValue());
		assertEquals(true, doubleTree.search(1.0));
		assertEquals(true, doubleTree.search(-1.0));
	}
	
	@Test
	public void testDeleteStageOne() {
		stageOne();
		integerTree.delete(10);
		assertEquals(12, (int)integerTree.getRoot().getValue());
		integerTree.delete(12);
		assertEquals(15, (int)integerTree.getRoot().getValue());
		assertEquals(5, integerTree.size());
	}
	
	@Test
	public void testDeleteStageTwo() {
		stageTwo();
		stringTree.delete("m");
		assertEquals("o", ""+stringTree.getRoot().getValue());
		stringTree.delete("o");
		assertEquals("r", ""+stringTree.getRoot().getValue());
		assertEquals(5, stringTree.size());
	}
	
	@Test
	public void testDeleteStageThree() {
		stageThree();
		doubleTree.delete(10.0);
		assertEquals(12.0, (double)doubleTree.getRoot().getValue());
		doubleTree.delete(12.0);
		assertEquals(15.0, (double)doubleTree.getRoot().getValue());
		assertEquals(5, doubleTree.size());
	}
	
	@Test
	public void testSearchStageOne() {
		stageOne();
		integerTree.insert(333);
		assertTrue(integerTree.search(333));
		integerTree.delete(3);
		assertFalse(integerTree.search(3));
	}
	
	@Test
	public void testSearchStageTwo() {
		stageTwo();
		stringTree.insert("a");
		assertTrue(stringTree.search("a"));
		stringTree.delete("o");
		assertFalse(stringTree.search("o"));
	}
	
	@Test
	public void testSearchStageThree() {
		stageThree();
		doubleTree.insert(333.0);
		assertTrue(doubleTree.search(333.0));
		doubleTree.delete(15.0);
		assertFalse(doubleTree.search(15.0));
	}
	
}
