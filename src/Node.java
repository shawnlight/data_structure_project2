/**
 * Stub for Node class
 * 
 * @author CS Staff
 * @param <T>
 *            the generic type; extends Comparable
 */

public class Node<T extends Comparable<T>> {

    private Node<T> left;
    private Node<T> right;
    private T value;

    /**
     * Instantiates a new node.
     *
     * @param value
     *            the value
     */
    public Node(T value) {
        this.value = value;
        left = null;
        right = null;
    }
    

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    public boolean equals(Node<T> node) {
       return value.equals(node.getValue()); 
    }
    
    
}
