package utilities;

import java.io.Serializable;

/**
 * Class Description: This class is BSTree Node uses to store the data in the
 * tree.
 * @author Weilong Mao, Hoa Le, Chris Wang, Hu Peng
 * @param <E> the type of the data stored in the node
 */

public class BSTreeNode<E extends Comparable<? super E>> implements Serializable {
	/**
	 *  the serial version UID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * the data stored in the node
	 */

	private E element;
	/**
	 * the left child and right child of the node
	 */
	private BSTreeNode<E> left, right;

	/**
	 * the constructor of the BSTreeNode
	 */

	public BSTreeNode() {
		this(null);
	}

	/**
	 * the constructor of the BSTreeNode
	 * @param element the data stored in the node
	 */
	public BSTreeNode(E element) {
		this(element, null, null);
	}

	/**
	 * the constructor of the BSTreeNode
	 * @param element the data stored in the node
	 * @param left 		the left child of the node
	 * @param right	the right child of the node
	 */
	public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	/**
	 * The method uses to add the data to the tree
	 * @param newNode the data to be added
	 * @return the node that is added
	 */

	public boolean add(BSTreeNode<E> newNode) {
		if (newNode == null) {
			return false;
		}

		if (newNode.getElement().compareTo(this.element) <= 0) {
			if (left == null) {
				left = newNode;
			} else {
				left.add(newNode);
			}
		} else if (newNode.getElement().compareTo(this.element) > 0) {
			if (right == null) {
				right = newNode;
			} else {
				right.add(newNode);
			}
		}
		return true;
	}

	/**
	 * The method uses to get the data stored in the node
	 * @return the data stored in the node
	 */

	public E getElement() {
		return element;
	}

	/**
	 * The method uses to set the data stored in the node
	 * @param element 		the data to be set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * The method uses to get the left child of the node
	 * @return the left child of the node
	 */

	public BSTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * The method uses to set the left child of the node
	 * @param left 		the left child to be set
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * The method uses to get the right child of the node
	 * @return	the right child of the node
	 */
	public BSTreeNode<E> getRight() {
		return right;
	}

	/**
	 * The method uses to set the right child of the node
	 * @param right	the right child to be set
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

	/**
	 * The method uses to check if the tree has left child
	 * @return true if the tree has left child, otherwise false
	 */

	public boolean hasLeft() {
		return left != null;
	}

	/**
	 * The method uses to check if the tree has right child
	 * @return 		true if the tree has right child, otherwise false
	 */
	public boolean hasRight() {
		return right != null;
	}

	/**
	 * The method uses to check if the node is a leaf
	 * @return true if the node is a leaf, otherwise false
	 */
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

	/**
	 * The method uses to get height of the tree
	 * @return the height of the tree
	 */

	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;
		if (this.left != null) {
			leftHeight = this.left.getHeight();
		}
		if (this.right != null) {
			rightHeight = this.right.getHeight();
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
