package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  This is the LinkedStack class that implements the StackInterface. 
 * 
 *  @author maitripathak
 *  @version Oct 16, 2023
 * @param <T> 
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    //~ Fields ................................................................
    
    private int size;
    private Node topNode;
    
    //~ Constructors ..........................................................
    
    /**
     * This is the constructor that helps make a new LinkedStack
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * This method gets the size of the LinkedStack.
     * @return the size of the LinkedStack.
     */
    public int size() {
        return size;
    }
    
    /**
     * This method checks to see if the stack is empty.
     * @return a boolean showing if the stack is empty or not. 
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    
    /**
     * This method clears the LinkedStack.
     * {@inheritDoc}
     */
    @Override
    public void clear()
    {
        topNode = null;
        size = 0;

    }

    /**
     * This returns the data that is at the top of the LinkedStack.
     * @return the data at the top of the LinkedStack.
     * {@inheritDoc}
     */
    @Override
    public T peek()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * This removes the top node.
     * @return the top node.
     * {@inheritDoc}
     */
    @Override
    public T pop()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T topData = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return topData;
    }

    /**
     * This method adds an entry to the top of the stack.
     * @param anEntry is the entry.
     * {@inheritDoc}
     */
    @Override
    public void push(T anEntry)
    {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        size++;

    }
    
    /**
     * This is the toString method that returns a string of the list. 
     * @return a string of the list.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node currentNode = topNode;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            if (currentNode.getNextNode() != null) {
                sb.append(", ");
            }
            currentNode = currentNode.getNextNode();
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Node class
     */
    private class Node {
        private T data;
        private Node next;
        
        /**
         * Creates a new node
         * @param data is a T parameter
         * @param next is a Node parameter
         */
        public Node(T data, Node next) {
            //this.data = data;
            //this.next = next;
            this(data); 
            this.setNextNode(next); 
        }
        
        /**
         * This sets the next node
         * @param node is a Node parameter
         */
        public void setNextNode(Node node) {
            this.next = node;
        }
        
        /**
         * Second constructor for this.
         * @param data is a T parameter
         */
        public Node(T data) {
            this.data = data;
        }
        
        /**
         * This gets the next node
         * @return the next node
         */
        public Node getNextNode() {
            return next;
        }
        
        /**
         * This gets the data in the node
         * @return the data in the node
         */
        public T getData() {
            return data;
        }
    }
}
