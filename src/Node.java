/**
 * Stub for Node class
 * 
 * @author light
 * @version {2020 fall}
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


    /**
     * left child getter
     * 
     * @return Node<T>
     *         left node
     */
    public Node<T> getLeft() {
        return left;
    }


    /**
     * left child setter
     * 
     * @param leftnode
     *            set the left child
     */
    public void setLeft(Node<T> leftnode) {
        this.left = leftnode;
    }


    /**
     * right child getter
     * 
     * @return Node<T>
     *         right node
     */
    public Node<T> getRight() {
        return right;
    }


    /**
     * right child setter
     * 
     * @param rightnode
     *            set the right child
     */
    public void setRight(Node<T> rightnode) {
        this.right = rightnode;
    }


    /**
     * node value getter
     * 
     * @return T
     *         get the node value
     */
    public T getValue() {
        return value;
    }


    /**
     * node value setter
     * 
     * @param parameter
     *            set the node value
     */
    public void setValue(T parameter) {
        this.value = parameter;
    }


    /**
     * check if two node are equal
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        }
        Node<T> node = (Node<T>)o;
        return node.value.equals(this.value);
    }

}
