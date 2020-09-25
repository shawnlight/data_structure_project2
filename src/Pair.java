/**
 * Pair class for intersections
 * 
 * @author light
 * @version {2020 fall}
 *
 */
public class Pair {
    public Rectangle rec1;
    public Rectangle rec2;

    /**
     * constructor
     * 
     * @param rec1
     *            rectangle 1
     * @param rec2
     *            rectangle 2
     */
    public Pair(Rectangle rec1, Rectangle rec2) {
        this.rec1 = rec1;
        this.rec2 = rec2;
    }


    /**
     * check if two pairs are the same
     * 
     * @param pair
     *            pair to compare with
     * @return true
     *         if two pair are the same
     */
    public boolean samePair(Pair pair) {
        return (pair.rec1.sameRec(rec1) && pair.rec2.sameRec(rec2))
            || (pair.rec2.sameRec(rec1) && pair.rec1.sameRec(rec2));
    }


    /**
     * print the pair
     */
    public void printPair() {
        StringBuilder str = new StringBuilder("(");
        str.append(rec1.getName());
        str.append(", ");
        str.append(rec1.getXpos());
        str.append(", ");
        str.append(rec1.getYpos());
        str.append(", ");
        str.append(rec1.getWidth());
        str.append(", ");
        str.append(rec1.getHeight());
        str.append(") : (");
        str.append(rec2.getName());
        str.append(", ");
        str.append(rec2.getXpos());
        str.append(", ");
        str.append(rec2.getYpos());
        str.append(", ");
        str.append(rec2.getWidth());
        str.append(", ");
        str.append(rec2.getHeight());
        str.append(")");
        System.out.println(str);
    }

}
