package utilities;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import exceptions.TreeException;

public class BSTree <E extends Comparable <? super E>> implements BSTreeADT <E> {

	private static final long serialVersionUID = 1L;
	private BSTreeNode <E> root;
    private int size;
    private int height;


    /**
     *  Default constructor for the BSTree class.  Creates an empty tree.
     */
    public BSTree() {
        this.size = 0;
        this.height = 0;
    }

    /**
     * The node at the root of the Binary Search Tree will be returned.
     *
     * @return node stored at the root of tree is returned
     * @throws TreeException if the root is empty.
     */
    @Override
    public BSTreeNode<E> getRoot() throws TreeException {
        if (root == null) {
            throw new TreeException("The root is empty.");
        }

        return root;

    }

    /**
     * Determines the row height of the tree and returns that value as an
     * integer value.
     *
     * @return the height of the tree.
     */
    @Override
    public int getHeight() {
        if(root == null) {
            return 0;
        }else{
            return root.getHeight();
        }
    }

    /**
     * The number of elements currently stored in the tree is counted and
     * the value is returned.
     *
     * @return number of elements currently stored in tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is currently empty.
     *
     * @return returns boolean true if the tree is empty otherwise false.
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Clears all elements currently stored in tree and makes the tree empty.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
        height = 0;

    }

    /**
     * Checks the current tree to see if the element passed in is stored in
     * the tree. If the element is found in the tree the method returns true
     * and if the element is not in the tree the method returns false.
     *
     * @param entry the element to find in the tree
     * @return returns boolean true if element is currently in the tree and
     * false if the element is not found in the tree
     * @throws TreeException if the tree is empty.
     */
    @Override
    public boolean contains(E entry) throws TreeException {
        if(root == null){
            throw new TreeException("The tree is empty.");
        }else{
            BSTreeNode<E> temp = root;
            while(temp != null){
                if(temp.getElement().compareTo(entry) == 0){
                    return true;
                }else if(temp.getElement().compareTo(entry) > 0){
                    temp = temp.getLeft();
                }else{
                    temp = temp.getRight();
                }
            }
        }
        return false;
    }

    /**
     * Retrieves a node from the tree given the object to search for.
     *
     * @param entry element object being searched
     * @return the node with the element located in tree, null if not found
     * @throws TreeException if the tree is empty
     */
    @Override
    public BSTreeNode<E> search(E entry) throws TreeException {
//        if(root == null){
//            throw new TreeException("The tree is empty.");
//        }else{

            BSTreeNode<E> temp = root;
            while(temp != null){
                if(temp.getElement().compareTo(entry) == 0){
                    return temp;
                }else if(temp.getElement().compareTo(entry) > 0){
                    temp = temp.getLeft();
                }else{
                    temp = temp.getRight();
                }
            }
//        }
        return null;
    }

    /**
     * Adds a new element to the tree according to the natural ordering
     * established by the Comparable implementation.
     *
     * @param newEntry the element being added to the tree
     * @return a boolean true if the element is added successfully else false
     * @throws NullPointerException if the element being added is null
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException {
        BSTreeNode<E> newNode = new BSTreeNode<>(newEntry);
        newNode.addRecord(newEntry);
        if (newEntry == null) {
            throw new NullPointerException("The element being added is null.");
        } else {
            if (root == null) {
                root = newNode;
                size++;
                height++;
                return true;
            } else {
                return addHelper(newEntry, root);
            }
        }

    }

    private boolean addHelper(E newEntry, BSTreeNode<E> root) {
        if (newEntry.compareTo(root.getElement()) < 0) {
            if (root.getLeft() == null) {
                root.setLeft(new BSTreeNode(newEntry));
                size++;
                return true;
            } else {
                return addHelper(newEntry, root.getLeft());
            }
        } else if (newEntry.compareTo(root.getElement()) > 0) {
            if (root.getRight() == null) {
                root.setRight(new BSTreeNode(newEntry));
                size++;
                return true;
            } else {
                return addHelper(newEntry, root.getRight());
            }
        } else {
            return false;
        }

    }


    /**
     * Generates an in-order iteration over the contents of the tree. Elements
     * are in their natural order.
     *
     * @return an iterator with the elements in the natural order
     */
    @Override
    public Iterator<E> inorderIterator() {
        Stack<BSTreeNode<E>> stack = new Stack<>();
        Queue<BSTreeNode<E>> queue = new LinkedList<BSTreeNode<E>>();
        BSTreeNode<E> current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.getLeft();
            }
            queue.add(stack.peek());
            current = stack.pop();
            current = current.getRight();
        }
        Iterator<E> it = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() throws NoSuchElementException {
                if(!hasNext()){
                    throw new NoSuchElementException("There are no more elements in the queue.");

                }
                return queue.remove().getElement();
            }
        };

        return it;
    }

    /**
     * Generates a pre-order iteration over the contents of the tree. Elements
     * are order in such a way as the root element is first.
     *
     * @return an iterator with the elements in a root element first order
     */
    @Override
    public Iterator preorderIterator() {
      if(root == null) return  null;
        Stack<BSTreeNode<E>> stack = new Stack<>();
        Queue<BSTreeNode<E>> queue = new LinkedList<BSTreeNode<E>>();
        BSTreeNode<E> current = root;
        stack.push(current);
        while(!stack.isEmpty()){
            current = stack.pop();
            queue.add(current);
            if(current.getRight() != null){
                stack.push(current.getRight());
            }
            if(current.getLeft() != null){
                stack.push(current.getLeft());
            }
        }
        Iterator<E> it = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() throws NoSuchElementException {
                if(!hasNext()){
                    throw new NoSuchElementException("There are no more elements in the queue.");

                }
                return queue.remove().getElement();
            }
        };

        return it;
  }

    /**
     * Generates a post-order iteration over the contents of the tree. Elements
     * are order in such a way as the root element is last.
     *
     * @return an iterator with the elements in a root element last order
     */
    @Override
    public Iterator postorderIterator() {
        // implement pre-order traversal
        if(root == null) return  null;
        Stack<BSTreeNode<E>> stack  = new Stack<>();
        Stack<BSTreeNode<E>> result  = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BSTreeNode<E> current = stack.peek();
            stack.pop();
            result.push(current);
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }
        Iterator<E> it = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !result.isEmpty();
            }

            @Override
            public E next() throws NoSuchElementException {
                if(!hasNext()){
                    throw new NoSuchElementException("There are no more elements in the queue.");

                }
                return result.pop().getElement();
            }
        };


        return it;
    }
}
