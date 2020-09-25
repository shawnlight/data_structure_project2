
/**
 * @author light
 * @version {2020 fall}
 *          binary search tree class
 * 
 */
public class BST {
    private Node root;
    private int nodeNum;

    /**
     * constructor
     * 
     */
    public BST() {
        root = null;
        nodeNum = 0;
    }


    /**
     * the insert function
     * 
     * @param rectangle
     *            the rectangle to be inserted
     */
    public void insert(Rectangle rectangle) {
        root = insertHelp(root, rectangle);
        nodeNum++;
    }


    /**
     * help function for insert function
     * by recursive call
     * 
     * @param root
     *            root of BST
     * @param rectangle
     *            rectangle to be inserted
     * @return
     */
    private Node insertHelp(Node root, Rectangle rectangle) {

        if (rectangle.notValid()) {
            reject(rectangle);
            nodeNum--;
            return null;
        }
        if (root == null) {
            Node node = new Node(rectangle);
            System.out.println("Rectangle accepted:(" + rectangle.getName()
                + ", " + rectangle.getXpos() + ", " + rectangle.getYpos() + ", "
                + rectangle.getWidth() + ", " + rectangle.getHeight() + ")");
            return node;
        }

        Rectangle rootRec = root.getRectangle();
        if (rootRec.getName().compareTo(rectangle.getName()) > 0) {
            root.left = insertHelp(root.left, rectangle);
        }

        else if (rootRec.getName().compareTo(rectangle.getName()) < 0) {
            root.right = insertHelp(root.right, rectangle);
        }

        else {
            if (sameDim(rootRec, rectangle)) {
                reject(rectangle);
                nodeNum--;
            }
            else {
                root.left = insertHelp(root.left, rectangle);
            }
        }

        return root;

    }


    /**
     * check if two rectangle dimension are the same
     * 
     * @param rec1
     *            rectangle 1
     * @param rec2
     *            rectangle 2
     * @return true
     *         if two rectangle have same dimension
     */
    private boolean sameDim(Rectangle rec1, Rectangle rec2) {
        return rec1.getXpos() == rec2.getXpos() && rec1.getYpos() == rec2
            .getYpos() && rec1.getHeight() == rec2.getHeight() && rec1
                .getWidth() == rec2.getWidth();
    }


    private void reject(Rectangle rectangle) {
        String name = rectangle.getName();
        int xpos = rectangle.getXpos();
        int ypos = rectangle.getYpos();
        int height = rectangle.getHeight();
        int width = rectangle.getWidth();
        System.out.println("Rectangle rejected:(" + name + ", " + xpos + ", "
            + ypos + ", " + width + ", " + height + ")");

    }


    /**
     * remove rectangle by name in BST
     * 
     * @param name
     *            rectangle name
     */
    public void remove(String name) {
        if (findOne(name)) {
            System.out.println("Rectangle rejected " + name);
            return;
        }

        root = removeNameHelp(root, name, null);
        nodeNum--;

    }


    /**
     * remove help function
     * 
     * @param root
     *            BST root
     * @param name
     *            rectangle name to be removed
     * @param rec
     *            null if remove by name
     *            not null if removed by dimension
     * @return root
     *         return root after removing the target node
     * 
     */
    private Node removeNameHelp(Node root, String name, Rectangle rec) {
        if (root == null) {
            return null;
        }

        if (root.getRectangle().getName().compareTo(name) > 0) {
            root.left = removeNameHelp(root.left, name, rec);
        }
        else if (root.getRectangle().getName().compareTo(name) < 0) {
            root.right = removeNameHelp(root.right, name, rec);
        }
        else {
            if (rec == null) {

                if (root.left == null) {
                    return root.right;
                }
                else if (root.right == null) {
                    return root.left;
                }
                else {
                    Node temp = getMax(root.left);
                    root.setRectangle(temp.getRectangle());
                    root.left = deleteMax(root.left);
                }
            }
            else {
                if (sameDim(rec, root.getRectangle())) {
                    if (root.left == null) {
                        return root.right;
                    }
                    else if (root.right == null) {
                        return root.left;
                    }
                    else {
                        Node temp = getMax(root.left);
                        root.setRectangle(temp.getRectangle());
                        root.left = deleteMax(root.left);
                    }

                }
                else {
                    root.left = removeNameHelp(root.left, name, rec);
                }
            }

        }
        return root;

    }


    /**
     * get the node with max value
     * 
     * @param root
     *            BST root
     * @return root
     *         the root with max value
     */
    private Node getMax(Node root) {
        if (root.right == null) {
            return root;
        }

        return getMax(root.right);
    }


    /**
     * remove the node with max value
     * 
     * @param root
     *            BST root
     * @return root
     *         after remove the node with max value
     */
    private Node deleteMax(Node root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        return root;
    }


    /**
     * check if exist rectangle with given name(at least one)
     * 
     * @param name
     *            find by name
     * @return true
     *         if find one target
     */
    private boolean findOne(String name) {
        return findOneHelp(root, name) == null;
    }


    /**
     * findOne help function
     * 
     * @param root
     *            BST root
     * @param name
     *            target name
     * @return Node
     *         return the target node with given name
     */
    private Node findOneHelp(Node root, String name) {
        if (root == null) {
            return null;
        }
        if (root.getRectangle().getName().compareTo(name) > 0) {
            return findOneHelp(root.left, name);
        }
        else if (root.getRectangle().getName().compareTo(name) == 0) {
            return root;
        }
        else {
            return findOneHelp(root.right, name);
        }
    }


    /**
     * remove the rectangle with given dimension
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
        MyList<Rectangle> list = new MyList<Rectangle>(Rectangle.class, 10);
        findByDim(x, y, w, h, root, list);
        if (list.getSize() == 0) {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
        else {
            root = removeNameHelp(root, list.get(0).getName(), list.get(0));
            nodeNum--;
        }
    }


    /**
     * find the rectangle in BST with given dimension
     * and store in the list
     * 
     * @param x
     *            s position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     * @param root
     *            BST root
     * @param list
     *            list to store the right rectangle
     */
    private void findByDim(
        int x,
        int y,
        int w,
        int h,
        Node root,
        MyList<Rectangle> list) {
        if (root == null) {
            return;
        }

        Rectangle rec = root.getRectangle();
        int xpos = rec.getXpos();
        int ypos = rec.getYpos();
        int width = rec.getWidth();
        int height = rec.getHeight();
        findByDim(x, y, w, h, root.left, list);
        if (x == xpos && y == ypos && w == width && h == height) {
            list.add(root.getRectangle());
            return;
        }
        findByDim(x, y, w, h, root.right, list);

    }


    /**
     * search rectangle by name
     * 
     * @param name
     *            target name
     */
    public void search(String name) {

        MyList<Rectangle> searchList = new MyList<Rectangle>(Rectangle.class,
            10);
        searchHelp(root, name, searchList);
        if (searchList.getSize() == 0) {
            System.out.println("Rectangle not found: " + name);
        }
        else {
            for (int i = 0; i < searchList.getSize(); ++i) {
                Rectangle rec = searchList.get(i);
                StringBuilder str = new StringBuilder("Rectangle found: ");
                str.append("(");
                str.append(rec.getName());
                str.append(", ");
                str.append(rec.getXpos());
                str.append(", ");
                str.append(rec.getYpos());
                str.append(", ");
                str.append(rec.getWidth());
                str.append(", ");
                str.append(rec.getHeight());
                str.append(")");
                System.out.println(str);

            }
        }
    }


    /**
     * help function for search, store the right rectangle
     * into the list
     * 
     * @param root
     *            BST root
     * @param name
     *            target name
     * @param searchList
     *            list to store the qualified value
     */
    private void searchHelp(
        Node root,
        String name,
        MyList<Rectangle> searchList) {
        if (root == null) {
            return;
        }
        if (root.getRectangle().getName().compareTo(name) > 0) {
            searchHelp(root.left, name, searchList);
        }
        else if (root.getRectangle().getName().compareTo(name) == 0) {
            searchList.add(root.getRectangle());
            searchHelp(root.left, name, searchList);
            return;
        }
        else {
            searchHelp(root.right, name, searchList);
        }

    }


    /**
     * search the rectangle by dimension
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
    public void regionSearch(int x, int y, int w, int h) {
        if (w <= 0 || h <= 0) {
            return;
        }
        MyList<Rectangle> searchList = new MyList<Rectangle>(Rectangle.class,
            10);
        regionSearchHelp(x, y, w, h, root, searchList);
        if (searchList.getSize() == 0) {
            return;
        }

        StringBuilder str = new StringBuilder(
            "Rectangles intersecting region (");
        str.append(x);
        str.append(", ");
        str.append(y);
        str.append(", ");
        str.append(w);
        str.append(", ");
        str.append(h);
        str.append("):\n");
        for (int i = 0; i < searchList.getSize(); ++i) {
            Rectangle rec = searchList.get(i);
            str.append("(");
            str.append(rec.getName());
            str.append(", ");
            str.append(rec.getXpos());
            str.append(", ");
            str.append(rec.getYpos());
            str.append(", ");
            str.append(rec.getWidth());
            str.append(", ");
            str.append(rec.getHeight());
            str.append(")\n");

        }
        System.out.print(str);

    }


    /**
     * region search help function
     * store the right value into the list
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     * @param root
     *            BST root
     * @param list
     *            list to store the qualified rectangle
     */
    private void regionSearchHelp(
        int x,
        int y,
        int w,
        int h,
        Node root,
        MyList<Rectangle> list) {
        if (root == null) {
            return;
        }

        if (root.getRectangle().intersect(x, y, w, h)) {
            list.add(root.getRectangle());
        }
        regionSearchHelp(x, y, w, h, root.left, list);
        regionSearchHelp(x, y, w, h, root.right, list);

    }


    /**
     * output the intersection pairs in BST
     */
    public void intersections() {
        MyList<Node> nodeList = new MyList<Node>(Node.class, 10);
        MyList<Pair> pairList = new MyList<Pair>(Pair.class, 10);
        traverseAdd(root, nodeList);
        for (int i = 0; i < nodeList.getSize(); ++i) {
            intersectionHelp(root, nodeList.get(i).getRectangle(), pairList);
        }
        MyList<Pair> finaPairList = new MyList<Pair>(Pair.class, 10);

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
     * traverse and store all the node in BST to the list
     * 
     * @param root
     *            BST root
     * @param list
     *            list to store each node
     */
    private void traverseAdd(Node root, MyList<Node> list) {
        if (root == null) {
            return;
        }
        traverseAdd(root.left, list);
        list.add(root);
        traverseAdd(root.right, list);

    }


    /**
     * intersection help function
     * 
     * @param root
     *            BST root
     * @param rec
     *            rectangle to compare with
     * @param list
     *            list to store the intersection pairs
     */
    private void intersectionHelp(Node root, Rectangle rec, MyList<Pair> list) {
        if (root == null) {
            return;
        }
        int xpos = rec.getXpos();
        int ypos = rec.getYpos();
        int width = rec.getWidth();
        int height = rec.getHeight();
        if (root.getRectangle().intersect(xpos, ypos, width, height) && !root
            .getRectangle().sameRec(rec)) {
            Pair pair = new Pair(root.getRectangle(), rec);
            list.add(pair);
        }
        intersectionHelp(root.left, rec, list);
        intersectionHelp(root.right, rec, list);

    }


    /**
     * traverse the BST with in-order method
     * 
     * @param root
     *            BST root
     * @param depth
     *            node depth
     */
    private void traverse(Node root, int depth) {
        if (root == null) {
            return;
        }

        traverse(root.left, depth + 1);
        StringBuilder info = new StringBuilder("Node has depth ");
        info.append(depth);
        info.append(", Value (");
        info.append(root.getRectangle().getName());
        info.append(", ");
        info.append(root.getRectangle().getXpos());
        info.append(", ");
        info.append(root.getRectangle().getYpos());
        info.append(", ");
        info.append(root.getRectangle().getWidth());
        info.append(", ");
        info.append(root.getRectangle().getHeight());
        info.append(")");
        System.out.println(info);
        traverse(root.right, depth + 1);
    }


    /**
     * print each node with in-order method and its depth
     */
    public void dump() {
        System.out.println("BST dump:");
        if (nodeNum == 0) {
            System.out.println("Node has depth 0, Value (null)");
        }
        else {
            traverse(root, 0);
        }
        System.out.println("BST size is: " + nodeNum);

    }

}
