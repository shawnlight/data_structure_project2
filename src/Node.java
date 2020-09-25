
/**
 * Node class for BST
 * 
 * @author light
 * @version {2020 fall}
 *
 */
public class Node {

    private Rectangle rectangle;
    Node left;
    Node right;

    /**
     * constructor
     * 
     * @param rectangle
     *            the rectangle in the node
     */
    public Node(Rectangle rectangle) {
        this.rectangle = rectangle;
        left = right = null;
    }


    /**
     * getter function
     * 
     * @return rectangle
     *         the rectangle in the node
     */
    public Rectangle getRectangle() {
        return rectangle;
    }


    /**
     * setter function
     * 
     * @param rectangle
     *            set the rectangle
     */
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

}
