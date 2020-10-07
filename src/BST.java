/**
 * Stub for binary search tree class
 * 
 * @author light
 * @version {2020 fall}
 * @param <T>
 *            the generic type; extends Comparable
 */

public class BST<T extends Comparable<T>> {

    /** The root. */
    protected Node<T> root;

    /** The size. */
    private int size;

    /**
     * Instantiates a new Binary Search Tree.
     */
    public BST() {
        root = null;
        size = 0;
    }


    /**
     * BST root getter
     * 
     * @return Node<T>
     *         return the root of BST
     */
    public Node<T> getRoot() {
        return root;
    }


    /**
     * BST size getter
     * 
     * @return size
     * 
     *         return the size of BST
     * 
     */
    public int getSize() {
        return size;
    }


    /**
     * BST insert function
     * 
     * @param e
     *            insert comparable
     */
    public void insert(Comparable<T> e) {
        root = insertHelp(root, e);
        size++;
    }


    /**
     * help function for BST insertion
     * 
     * @param rt
     *            current root of BST
     * @param e
     *            insert help comparable
     * @return Node<T>
     *         recursive node for help function
     */
    @SuppressWarnings("unchecked")
    private Node<T> insertHelp(Node<T> rt, Comparable<T> e) {
        if (rt == null) {
            return new Node<T>((T)e);
        }

        else if (rt.getValue().compareTo((T)e) >= 0) {
            rt.setLeft(insertHelp(rt.getLeft(), e));
        }
        else {
            rt.setRight(insertHelp(rt.getRight(), e));
        }
        return rt;

    }


    /**
     * BST search function
     * 
     * @param e
     *            search comparable
     * @return
     *         search list
     */
    public MyList<T> search(Comparable<T> e) {
        MyList<T> list = new MyList<T>();
        searchHelp(root, e, list);
        return list;
    }


    /**
     * BST search help function
     * 
     * @param rt
     *            current BST root
     * @param e
     *            comparable
     * @param list
     *            list to store the search element
     */
    @SuppressWarnings("unchecked")
    private void searchHelp(Node<T> rt, Comparable<T> e, MyList<T> list) {
        if (rt == null) {
            return;
        }

        if (rt.getValue().compareTo((T)e) > 0) {
            searchHelp(rt.getLeft(), e, list);
        }
        else if (rt.getValue().compareTo((T)e) < 0) {
            searchHelp(rt.getRight(), e, list);
        }

        else {
            list.add(rt.getValue());
            searchHelp(rt.getLeft(), e, list);
            return;
        }
    }


    /**
     * BST remove function
     * 
     * @param e
     *            comparable
     * @param ref
     *            reference for dimension remove
     */
    public void remove(Comparable<T> e, Node<T> ref) {
        if (search(e).getSize() == 0) {
            return;
        }
        root = removeHelp(root, e, ref);
        size--;
    }


    /**
     * @param rt
     *            BST root
     * @param e
     *            comparable
     * @param ref
     *            reference for dimension remove
     * 
     * @return Node<T>
     *         recursive node
     */
    @SuppressWarnings("unchecked")
    private Node<T> removeHelp(Node<T> rt, Comparable<T> e, Node<T> ref) {
        if (rt == null) {
            return null;
        }

        if (rt.getValue().compareTo((T)e) > 0) {
            rt.setLeft(removeHelp(rt.getLeft(), e, ref));
        }
        else if (rt.getValue().compareTo((T)e) < 0) {
            rt.setRight(removeHelp(rt.getRight(), e, ref));
        }
        else {
            if (ref == null) {
                if (rt.getLeft() == null) {
                    return rt.getRight();
                }
                else if (rt.getRight() == null) {
                    return rt.getLeft();
                }
                else {
                    Node<T> temp = getMax(rt.getLeft());
                    rt.setValue(temp.getValue());
                    rt.setLeft(deleteMax(rt.getLeft()));

                }
            }
            else {
                if (ref.equals(rt)) {
                    if (rt.getLeft() == null) {
                        return rt.getRight();
                    }
                    else if (rt.getRight() == null) {
                        return rt.getLeft();
                    }
                    else {
                        Node<T> temp = getMax(rt.getLeft());
                        rt.setValue(temp.getValue());
                        rt.setLeft(deleteMax(rt.getLeft()));

                    }
                }
                else {
                    rt.setLeft(removeHelp(rt.getLeft(), e, ref));
                }
            }
        }
        return rt;

    }


    /**
     * @param rt
     *            BST node
     * @return Node<T>
     *         max value Node in BST
     */
    private Node<T> getMax(Node<T> rt) {
        if (rt.getRight() == null) {
            return rt;
        }

        return getMax(rt.getRight());
    }


    /**
     * @param rt
     *            BST node
     * @return Node<T>
     *         node with max value
     */
    private Node<T> deleteMax(Node<T> rt) {
        if (rt.getRight() == null) {
            return rt.getLeft();
        }
        rt.setRight(deleteMax(rt.getRight()));
        return rt;
    }

}
