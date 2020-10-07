/**
 * Pair class for intersections
 * 
 * @author light
 * @version {2020 fall}
 *
 */
public class Pair {
    private Rectangle rec1;
    private Rectangle rec2;

    /**
     * constructor
     * 
     * @param recOne
     *            rectangle 1
     * @param recTwo
     *            rectangle 2
     */
    public Pair(Rectangle recOne, Rectangle recTwo) {
        this.rec1 = recOne;
        this.rec2 = recTwo;
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
        return (pair.rec1.equals(rec1) && pair.rec2.equals(rec2)) || (pair.rec2
            .equals(rec1) && pair.rec1.equals(rec2));
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


//    /**
//     * rectangle 1 getter
//     * 
//     * @return rec1
//     *         return rectangle 1
//     */
//    public Rectangle getRec1() {
//        return rec1;
//    }
//
//
//    /**
//     * rectangle 2 getter
//     * 
//     * @return rec2
//     *         return rectangle 2
//     */
//    public Rectangle getRec2() {
//        return rec2;
//    }

}
