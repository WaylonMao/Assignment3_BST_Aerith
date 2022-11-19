/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.TreeException;
import utilities.BSTree;
import utilities.BSTreeNode;
import utilities.Iterator;

/**
 * @author levan
 *
 */
public class BSTreeTests {

	// Attributes
	private BSTree<Integer> tree;
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer four;
	private Integer five;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		// create a tree
		tree = new BSTree<Integer>();
		one = new Integer(1);
		two = new Integer(2);
		three = new Integer(3);
		four = new Integer(4);
		five = new Integer(5);


	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public  void tearDownAfterClass() throws Exception {
		// delete the tree
		tree = null;


	}

	/**
	 * Test method for {@link utilities.BSTree#BSTree()}.
	 */
	@Test
	public void testBSTree() {
		boolean expected = true;
		tree = new BSTree<Integer>();
		boolean actual = tree != null;
		assertEquals("Construction is built incorrectly",expected, true);
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot()}.
	 */
	@Test
	public void testGetRoot()  {
		BSTreeNode<Integer> expected = new BSTreeNode<>(1);
		tree.add(one);
		tree.add(two);
		tree.add(three);
		tree.add(four);
		tree.add(five);

		BSTreeNode<Integer> actual = null;
		try{
			actual = tree.getRoot();
		} catch (TreeException e) {
			e.printStackTrace();

		}
		assertEquals("The root implemented incorrectly",expected.getElement(), actual.getElement());

		// test when root is null
		tree = new BSTree<Integer>();
		try{
			actual = tree.getRoot();
		} catch (TreeException e) {
			System.out.println("The root is empty.");

		}


	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	public void testGetHeight() {
		int expected = 3;
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);
		int actual = tree.getHeight();
		assertEquals("The getHeigh method implemented incorrectly",expected, actual);


	}

	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	public void testSize() {
		int expected = 5;
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);
		int actual = tree.size();
		assertEquals("The size method is incorrectly",expected, actual);

	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		boolean expected = true;
		boolean actual = tree.isEmpty();
		assertEquals("The isEmpty method is incorrectly",expected, actual);

	}

	/**
	 * Test method for {@link utilities.BSTree#clear()}.
	 */
	@Test
	public void testClear() {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);
		tree.clear();
		boolean expected = true;
		boolean actual = tree.isEmpty();
		assertEquals("The clear method is incorrectly",expected, actual);

	}

	/**
	 * Test method for {@link utilities.BSTree#contains(java.lang.Comparable)}.
	 */
	@Test
	public void testContains() throws TreeException {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);
		boolean expected = true;
		boolean actual = tree.contains(five);
		assertEquals("The contains method is incorrectly",expected, actual);

	}

	/**
	 * Test method for {@link utilities.BSTree#search(java.lang.Comparable)}.
	 */
	@Test
	public void testSearch() {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);
		BSTreeNode<Integer> expected = new BSTreeNode<>(5);
		BSTreeNode<Integer> actual = null;
		try{
			actual = tree.search(five);
		} catch (TreeException e) {
			e.printStackTrace();

		}
		assertEquals("The search method is incorrectly",expected.getElement(), actual.getElement());

	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() throws TreeException {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);
		boolean expected = true;
		boolean actual = tree.contains(five);
		assertEquals("The add method is incorrectly",expected, actual);
		// test size
		int expectedSize = 5;
		int actualSize = tree.size();
		assertEquals("The add method is incorrectly",expectedSize, actualSize);
		// test when the element is already in the tree
		expected = true;
		actual = tree.contains(five);
		assertEquals("The add method is incorrectly",expected, actual);




	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	public void testInorderIterator() {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);

		// test inorderIterator
		Iterator<Integer> iterator = tree.inorderIterator();
		int expected = 1;
		int actual = iterator.next();
		assertEquals("The inorderIterator method is incorrectly",expected, actual);
		expected = 2;
		actual = iterator.next();
		assertEquals("The inorderIterator method is incorrectly",expected, actual);
		expected = 3;
		actual = iterator.next();
		assertEquals("The inorderIterator method is incorrectly",expected, actual);
		expected = 4;
		actual = iterator.next();
		assertEquals("The inorderIterator method is incorrectly",expected, actual);
		expected = 5;
		actual = iterator.next();
		assertEquals("The inorderIterator method is incorrectly",expected, actual);


	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	public void testPreorderIterator() {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);

		// test preorderIterator
		Iterator<Integer> iterator = tree.preorderIterator();
		int expected = 2;
		int actual = iterator.next();
		assertEquals("The preorderIterator method is incorrectly",expected, actual);
		expected = 1;
		actual = iterator.next();
		assertEquals("The preorderIterator method is incorrectly",expected, actual);
		expected = 4;
		actual = iterator.next();
		assertEquals("The preorderIterator method is incorrectly",expected, actual);
		expected = 3;
		actual = iterator.next();
		assertEquals("The preorderIterator method is incorrectly",expected, actual);
		expected = 5;
		actual = iterator.next();
		assertEquals("The preorderIterator method is incorrectly",expected, actual);

	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	public void testPostorderIterator() {
		tree.add(two);
		tree.add(four);
		tree.add(one);
		tree.add(three);
		tree.add(five);

		// test postorderIterator
		Iterator<Integer> iterator = tree.postorderIterator();
		int expected = 1;
		int actual = iterator.next();
		assertEquals("The postorderIterator method is incorrectly",expected, actual);
		expected = 3;
		actual = iterator.next();
		assertEquals("The postorderIterator method is incorrectly",expected, actual);
		expected = 5;
		actual = iterator.next();
		assertEquals("The postorderIterator method is incorrectly",expected, actual);
		expected = 4;
		actual = iterator.next();
		assertEquals("The postorderIterator method is incorrectly",expected, actual);
		expected = 2;
		actual = iterator.next();
		assertEquals("The postorderIterator method is incorrectly",expected, actual);

	}

}
