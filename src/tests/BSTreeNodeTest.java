package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.BSTreeNode;

public class BSTreeNodeTest {
    private BSTreeNode<Integer> left;
    private BSTreeNode<Integer> right;
    private BSTreeNode node;
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;

    public BSTreeNodeTest() {
    }

    @Before
    public void setUpBeforeClass() throws Exception {
        this.one = 1;
        this.two = 2;
        this.three = 3;
        this.four = 4;
        this.five = 5;
        this.node = new BSTreeNode();
        this.left = new BSTreeNode();
        this.right = new BSTreeNode();
    }

    @After
    public void tearDownAfterClass() throws Exception {
        this.node = null;
        this.left = null;
        this.right = null;
    }

    @Test
    public void testBSTreeNodeNoArgumentConstractor() {
        boolean expected = true;
        this.node = new BSTreeNode();
        boolean actual = this.node != null;
        Assert.assertEquals("Construction failed", expected, actual);
    }

    @Test
    public void testBSTreeEConstractor() {
        boolean expected = true;
        this.node = new BSTreeNode(this.one);
        boolean actual = this.node.getElement() == this.one;
        Assert.assertEquals("Construction failed", expected, actual);
    }

    @Test
    public void testBSTreeNodeEConstractorWithLeftAndRight() {
        boolean expected = true;
        this.left = new BSTreeNode(this.two);
        this.right = new BSTreeNode(this.three);
        this.node = new BSTreeNode(this.one, this.left, this.right);
        boolean actual = this.node != null;
        Assert.assertEquals("Construction failed", expected, actual);
    }

    @Test
    public void testAddNull() {
        boolean expected = true;
        this.node = new BSTreeNode(this.one);
        this.left = null;
        boolean actual = !this.node.add(this.left);
        Assert.assertEquals("Test for Adding Null value failed", expected, actual);
    }

    @Test
    public void testAddNullLeft() {
        boolean expected = true;
        this.node = new BSTreeNode(this.two);
        this.left = new BSTreeNode(this.one);
        boolean actual = this.node.add(this.left) && this.node.getLeft().equals(this.left);
        Assert.assertEquals("Test for Adding left node failed", expected, actual);
    }

    @Test
    public void testAddLeft() {
        this.node = new BSTreeNode(this.three);
        this.left = new BSTreeNode(this.two);
        this.node.add(this.left);
        BSTreeNode<Integer> newNode = new BSTreeNode(this.one);
        this.node.add(newNode);
        int expected = (Integer)newNode.getElement();
        int actual = (Integer)this.node.getLeft().getLeft().getElement();
        Assert.assertEquals("Test for Adding left node failed", (long)expected, (long)actual);
    }

    @Test
    public void testAddNullRight() {
        boolean expected = true;
        this.node = new BSTreeNode(this.one);
        this.right = new BSTreeNode(this.two);
        boolean actual = this.node.add(this.right) && this.node.getRight().equals(this.right);
        Assert.assertEquals("Test for Adding right node failed", expected, actual);
    }

    @Test
    public void testAddRight() {
        this.node = new BSTreeNode(this.one);
        this.right = new BSTreeNode(this.three);
        this.node.add(this.right);
        BSTreeNode<Integer> newNode = new BSTreeNode(this.two);
        this.node.add(newNode);
        int expected = (Integer)newNode.getElement();
        int actual = (Integer)this.node.getRight().getLeft().getElement();
        Assert.assertEquals("Test for Adding right node failed", (long)expected, (long)actual);
    }

    @Test
    public void testGetElement() {
        boolean expected = true;
        this.node = new BSTreeNode(this.one);
        boolean actual = this.node.getElement().equals(this.one);
        Assert.assertEquals("Test for getElement failed", expected, actual);
    }

    @Test
    public void testSetElement() {
        int expected = this.one;
        this.node = new BSTreeNode();
        this.node.setElement(this.one);
        int actual = (Integer)this.node.getElement();
        Assert.assertEquals("Test for setElement failed", (long)expected, (long)actual);
    }

    @Test
    public void testGetLeft() {
        boolean expected = true;
        this.left = new BSTreeNode(this.one);
        this.right = new BSTreeNode(this.three);
        this.node = new BSTreeNode(this.two, this.left, this.right);
        boolean actual = this.node.getLeft().equals(this.left);
        Assert.assertEquals("Test for getLeft failed", expected, actual);
    }

    @Test
    public void testSetLeft() {
        boolean expected = true;
        this.left = new BSTreeNode(this.one);
        this.node = new BSTreeNode(this.two);
        this.node.setLeft(this.left);
        boolean actual = this.node.getLeft().equals(this.left);
        Assert.assertEquals("Test for setLeft failed", expected, actual);
    }

    @Test
    public void testGetRight() {
        boolean expected = true;
        this.left = new BSTreeNode(this.one);
        this.right = new BSTreeNode(this.three);
        this.node = new BSTreeNode(this.two, this.left, this.right);
        boolean actual = this.node.getRight().equals(this.right);
        Assert.assertEquals("Test for getRight failed", expected, actual);
    }

    @Test
    public void testSetRight() {
        boolean expected = true;
        this.right = new BSTreeNode(this.three);
        this.node = new BSTreeNode(this.two);
        this.node.setRight(this.right);
        boolean actual = this.node.getRight().equals(this.right);
        Assert.assertEquals("Test for setLeft failed", expected, actual);
    }

    @Test
    public void testHasLeft() {
        boolean expected = false;
        this.node = new BSTreeNode(this.two);
        boolean actual = this.node.hasLeft();
        Assert.assertEquals("Test for hasLeft failed", expected, actual);
    }

    @Test
    public void testHasRight() {
        boolean expected = true;
        this.node = new BSTreeNode(this.two);
        this.right = new BSTreeNode(this.three);
        this.node.setRight(this.right);
        boolean actual = this.node.hasRight();
        Assert.assertEquals("Test for hasRight failed", expected, actual);
    }

    @Test
    public void testIsLeaf() {
        boolean expected = true;
        this.node = new BSTreeNode(this.two);
        boolean actual = this.node.isLeaf();
        Assert.assertEquals("Test for isLeaf failed", expected, actual);
    }

    @Test
    public void testGetHeight() {
        this.left = new BSTreeNode(this.one);
        this.right = new BSTreeNode(this.three);
        this.node = new BSTreeNode(this.two, this.left, this.right);
        BSTreeNode<Integer> newNode = new BSTreeNode(this.four);
        this.node.add(newNode);
        int expected = 3;
        int actual = this.node.getHeight();
        Assert.assertEquals("Test for getHeight failed", (long)expected, (long)actual);
    }
}
