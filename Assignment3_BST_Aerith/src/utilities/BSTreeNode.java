package utilities;

import java.io.Serializable;

public class BSTreeNode<E extends Comparable<? super E>> implements Serializable {

	private static final long serialVersionUID = 1L;

	private E element;

	private BSTreeNode<E> left, right;

	public BSTreeNode() {
		this(null);
	}

	public BSTreeNode(E element) {
		this(element, null, null);
	}

	public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

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

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public BSTreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	public BSTreeNode<E> getRight() {
		return right;
	}

	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

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
