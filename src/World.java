
/**
 * world data base class
 * 
 * @author light
 * @version {2020 fall}
 */
public class World {
    private BST<Rectangle> bst;

    /**
     * constructor
     */
    public World() {
        bst = new BST<Rectangle>();
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
        if (rec.notValid()) {
            System.out.println("Rectangle rejected:(" + name + ", " + x + ", "
                + y + ", " + w + ", " + h + ")");
            return;
        }
        MyList<Rectangle> list = bst.search(rec);
        for (int i = 0; i < list.getSize(); ++i) {
            if (list.get(i).equals(rec)) {
                System.out.println("Rectangle rejected:(" + name + ", " + x
                    + ", " + y + ", " + w + ", " + h + ")");
                return;
            }
        }
        bst.insert(rec);
        System.out.println("Rectangle accepted:(" + name + ", " + x + ", " + y
            + ", " + w + ", " + h + ")");

    }


    /**
     * remove the rectangle with given name in database
     * 
     * @param name
     *            target name
     */
    public void remove(String name) {
        Rectangle rec = new Rectangle(name);
        MyList<Rectangle> list = bst.search(rec);
        if (list.getSize() == 0) {
            System.out.println("Rectangle rejected " + name);
            return;
        }

        bst.remove(rec, null);

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
        MyList<Rectangle> list = new MyList<Rectangle>();
        removeByDimHelp(bst.getRoot(), x, y, w, h, list);
        if (list.getSize() == 0) {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w
                + ", " + h + ")");
            return;
        }
        Node<Rectangle> ref = new Node<Rectangle>(list.get(0));
        bst.remove(list.get(0), ref);
    }


    /**
     * remove help function
     * 
     * @param root
     *            BST root
     * @param x
     *            x position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     * @param list
     *            list to collect the remove element
     */
    private void removeByDimHelp(
        Node<Rectangle> root,
        int x,
        int y,
        int w,
        int h,
        MyList<Rectangle> list) {
        if (root == null) {
            return;
        }
        Rectangle rec = new Rectangle(x, y, w, h);
        if (root.getValue().sameDim(rec)) {
            list.add(root.getValue());
        }
        removeByDimHelp(root.getLeft(), x, y, w, h, list);
        removeByDimHelp(root.getRight(), x, y, w, h, list);

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
        if (w <= 0 || h <= 0) {
            return;
        }
        MyList<Rectangle> list = new MyList<Rectangle>();
        regionsearchHelp(bst.getRoot(), x, y, w, h, list);
        if (list.getSize() == 0) {
            return;
        }
        System.out.println("Rectangles intersecting region (" + x + ", " + y
            + ", " + w + ", " + h + "):");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i).toString());
        }

    }


    /**
     * region search help function
     * 
     * @param root
     *            BST root
     * @param x
     *            x position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     * @param list
     *            list to collect the remove element
     */
    private void regionsearchHelp(
        Node<Rectangle> root,
        int x,
        int y,
        int w,
        int h,
        MyList<Rectangle> list) {
        if (root == null) {
            return;
        }
        Rectangle rec = new Rectangle(x, y, w, h);
        if (root.getValue().intersect(rec)) {
            list.add(root.getValue());
        }
        regionsearchHelp(root.getLeft(), x, y, w, h, list);
        regionsearchHelp(root.getRight(), x, y, w, h, list);

    }


    /**
     * print the intersection pairs
     */
    public void intersections() {

        // dfs method
        MyList<Rectangle> recList = new MyList<Rectangle>();
        MyList<Pair> pairList = new MyList<Pair>();
        traverseAdd(bst.getRoot(), recList);
        dfs(recList, pairList, 0);
        System.out.println("Intersection pairs:");
        for (int k = 0; k < pairList.getSize(); ++k) {
            pairList.get(k).printPair();
        }
    }


    /**
     * depth first search help function
     * 
     * @param recList
     *            rectangle list
     * @param pairList
     *            rectangle pair list
     * @param start
     *            start index for search
     */
    public void dfs(
        MyList<Rectangle> recList,
        MyList<Pair> pairList,
        int start) {
        int len = recList.getSize();
        if (len == 0) {
            return;
        }

        if (start >= len) {
            return;
        }

        for (int i = start + 1; i < len; i++) {
            if (recList.get(start).intersect(recList.get(i))) {
                pairList.add(new Pair(recList.get(start), recList.get(i)));
            }

        }
        dfs(recList, pairList, start + 1);
    }


    /**
     * traverse the tree and add into the list
     * 
     * @param root
     *            BST root
     * @param list
     *            list the add all elements
     */
    private void traverseAdd(Node<Rectangle> root, MyList<Rectangle> list) {
        if (root == null) {
            return;
        }
        traverseAdd(root.getLeft(), list);
        list.add(root.getValue());
        traverseAdd(root.getRight(), list);
    }


    /**
     * search the rectangle with given name
     * 
     * @param name
     *            target name
     */
    public void search(String name) {
        // sudo-rectangle for search
        Rectangle rec = new Rectangle(name);
        MyList<Rectangle> list = bst.search(rec);
        if (list.getSize() == 0) {
            System.out.println("Rectangle not found: " + name);
            return;
        }
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.print("Rectangle found: ");
            System.out.println(list.get(i).toString());
        }

    }


    /**
     * print the rectangle in in-order sequence and depth
     */
    public void dump() {
        bst.dump();
    }

}
