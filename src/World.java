
/**
 * world data base class
 * 
 * @author light
 * @version {2020 fall}
 */
public class World {
    private BST bst;

    /**
     * constructor
     */
    public World() {
        bst = new BST();
    }


    /**
     * insert the rectangle into the database
     * 
     * @param name
     *            rectangle name
     * @param x
     *            rectangle x position
     * @param y
     *            rectangle y position
     * @param w
     *            width
     * @param h
     *            height
     */
    public void insert(String name, int x, int y, int w, int h) {
        Rectangle rec = new Rectangle(name, x, y, w, h);
        bst.insert(rec);

    }


    /**
     * remove the rectangle with given name in database
     * 
     * @param name
     *            target name
     */
    public void remove(String name) {
        bst.remove(name);
    }


    /**
     * remove the rectangle in data base with given dimension
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     */
    public void remove(int x, int y, int w, int h) {
        bst.remove(x, y, w, h);
    }


    /**
     * search the rectangle in the given dimension
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     */
    public void regionsearch(int x, int y, int w, int h) {
        bst.regionSearch(x, y, w, h);
    }


    /**
     * print the intersection pairs
     */
    public void intersections() {
        bst.intersections();
    }


    /**
     * search the rectangle with given name
     * 
     * @param name
     *            target name
     */
    public void search(String name) {
        bst.search(name);
    }


    /**
     * print the rectangle in in-order sequence and depth
     */
    public void dump() {
        bst.dump();
    }

}
