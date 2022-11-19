package utilities;

import java.io.Serializable;
import java.util.LinkedList;

public class BSTreeNode<E> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  E element;

    private BSTreeNode<E> left, right;

    LinkedList<E> list = new LinkedList<E>();

    public void addRecord(E element) {
        this.list.add( element);
    }

    public int getSize() {
        return list.size();
    }

    /**
     * Get information about the element stored in this node.
     *
     */
    public LinkedList<E> getList() {
        return list;
    }


    public BSTreeNode(){
        this(null);
    }

    public BSTreeNode(E element){
       this(element, null, null);
    }

    public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
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

    public int getNumberNodes() {
       int numberNodes = 0;
       return numberNodes;
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

    public int getHeight(BSTreeNode<E> node) {
        int height = 0;
        return height;
    }


}
