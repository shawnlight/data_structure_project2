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
