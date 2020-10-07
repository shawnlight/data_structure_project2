
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
            list.get(i).printRectangle();
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
        if (root.getValue().intersect(x, y, w, h)) {
            list.add(root.getValue());
        }
        regionsearchHelp(root.getLeft(), x, y, w, h, list);
        regionsearchHelp(root.getRight(), x, y, w, h, list);

    }


    /**
     * print the intersection pairs
     */
    public void intersections() {
        MyList<Rectangle> recList = new MyList<Rectangle>();
        MyList<Pair> pairList = new MyList<Pair>();
        traverseAdd(bst.getRoot(), recList);
        for (int i = 0; i < recList.getSize(); ++i) {
            intersectionHelp(bst.getRoot(), recList.get(i), pairList);
        }
        MyList<Pair> finaPairList = new MyList<Pair>();

        int j = 0;
        while (j < pairList.getSize()) {
            int i = j + 1;
            Pair cur = pairList.get(j);
            for (; i < pairList.getSize(); i++) {
                if (cur.samePair(pairList.get(i))) {
                    break;
                }
            }
            if (i == pairList.getSize()) {
                finaPairList.add(cur);
            }
            j++;

        }

        System.out.println("Intersection pairs:");
        for (int k = 0; k < finaPairList.getSize(); ++k) {
            finaPairList.get(k).printPair();
        }
    }


    /**
     * intersection help function
     * 
     * @param root
     *            BST root
     * @param rec
     *            rectangle to compare with
     * @param list
     *            list to collect the pair
     */
    public void intersectionHelp(
        Node<Rectangle> root,
        Rectangle rec,
        MyList<Pair> list) {
        if (root == null) {
            return;
        }
        int xpos = rec.getXpos();
        int ypos = rec.getYpos();
        int width = rec.getWidth();
        int height = rec.getHeight();
        boolean intersect = root.getValue().intersect(xpos, ypos, width, height)
            && !root.getValue().equals(rec);
        if (intersect) {
            Pair pair = new Pair(root.getValue(), rec);
            list.add(pair);
        }
        intersectionHelp(root.getLeft(), rec, list);
        intersectionHelp(root.getRight(), rec, list);
    }


    /**
     * traverse the tree and add int the list
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
        // sudo rectangle for search
        Rectangle rec = new Rectangle(name);
        MyList<Rectangle> list = bst.search(rec);
        if (list.getSize() == 0) {
            System.out.println("Rectangle not found: " + name);
            return;
        }
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.print("Rectangle found: ");
            list.get(i).printRectangle();
        }

    }


    /**
     * print the rectangle in in-order sequence and depth
     */
    public void dump() {
        System.out.println("BST dump:");
        if (bst.getSize() == 0) {
            System.out.println("Node has depth 0, Value (null)");
        }
        else {
            dumpHelp(bst.getRoot(), 0);
        }
        System.out.println("BST size is: " + bst.getSize());

    }


    /**
     * traverse the tree in in-order sequence
     * 
     * @param root
     *            BST root
     * @param depth
     *            depth of the node
     */
    private void dumpHelp(Node<Rectangle> root, int depth) {
        if (root == null) {
            return;
        }

        dumpHelp(root.getLeft(), depth + 1);
        System.out.print("Node has depth " + depth + ", Value ");
        root.getValue().printRectangle();
        dumpHelp(root.getRight(), depth + 1);
    }

}
