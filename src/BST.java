/**
 * Stub for binary search tree class
 * 
 * @author {Your Name Here}
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


    public Node<T> getRoot() {
        return root;
    }


    public int getSize() {
        return size;
    }


    public void insert(Comparable<T> e) {
        root = insertHelp(root, e);
        size++;
    }


    private Node<T> insertHelp(Node<T> root, Comparable<T> e) {
        if (root == null) {
            return new Node((T)e);
        }

        else if (root.getValue().compareTo((T)e) >= 0) {
            root.setLeft(insertHelp(root.getLeft(), e));
        }
        else {
            root.setRight(insertHelp(root.getRight(), e));
        }
        return root;

    }


    public MyList<T> search(Comparable<T> e) {
        MyList<T> list = new MyList<T>();
        searchHelp(root, e, list);
        return list;
    }


    private void searchHelp(Node<T> root, Comparable<T> e, MyList<T> list) {
        if (root == null) {
            return;
        }

        if (root.getValue().compareTo((T)e) > 0) {
            searchHelp(root.getLeft(), e, list);
        }
        else if (root.getValue().compareTo((T)e) < 0) {
            searchHelp(root.getRight(), e, list);
        }

        else {
            list.add(root.getValue());
            searchHelp(root.getLeft(), e, list);
            return;
        }
    }


    public void remove(Comparable<T> e, Node<T> ref) {
        if (search(e).getSize() == 0) {
            return;
        }
        root = removeHelp(root, e, ref);
        size--;
    }


    private Node<T> removeHelp(Node<T> root, Comparable<T> e, Node<T> ref) {
        if (root == null) {
            return null;
        }

        if (root.getValue().compareTo((T)e) > 0) {
            root.setLeft(removeHelp(root.getLeft(), e, ref));
        }
        else if (root.getValue().compareTo((T)e) < 0) {
            root.setRight(removeHelp(root.getRight(), e, ref));
        }
        else {
            if (ref == null) {
                if (root.getLeft() == null) {
                    return root.getRight();
                }
                else if (root.getRight() == null) {
                    return root.getLeft();
                }
                else {
                    Node<T> temp = getMax(root.getLeft());
                    root.setValue(temp.getValue());
                    root.setLeft(deleteMax(root.getLeft()));

                }
            }
            else {
                if(ref.equals(root)) {
                    if (root.getLeft() == null) {
                        return root.getRight();
                    }
                    else if (root.getRight() == null) {
                        return root.getLeft();
                    }
                    else {
                        Node<T> temp = getMax(root.getLeft());
                        root.setValue(temp.getValue());
                        root.setLeft(deleteMax(root.getLeft()));

                    }
                }
                else {
                    root.setLeft(removeHelp(root.getLeft(), e, ref));
                }
            }
        }
        return root;

    }


    private Node<T> getMax(Node<T> root) {
        if (root.getRight() == null) {
            return root;
        }

        return getMax(root.getRight());
    }


    private Node<T> deleteMax(Node<T> root) {
        if (root.getRight() == null) {
            return root.getLeft();
        }
        root.setRight(deleteMax(root.getRight()));
        return root;
    }

}
