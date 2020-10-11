
/**
 * Rectangle class
 * 
 * @author light
 * @version {2020 fall}
 *
 */
public class Rectangle implements Comparable<Rectangle> {
    private String name;
    private int xpos;
    private int ypos;
    private int width;
    private int height;

    /**
     * constructor with name and dimension
     * 
     * @param n
     *            rectangle name
     * @param x
     *            rectangle x position
     * @param y
     *            rectangle y position
     * @param w
     *            rectangle width
     * @param h
     *            rectangle height
     */
    public Rectangle(String n, int x, int y, int w, int h) {
        this.name = n;
        xpos = x;
        ypos = y;
        this.width = w;
        this.height = h;
    }


    /**
     * constructor with name
     * 
     * @param name
     *            rectangle name
     */
    public Rectangle(String name) {
        this.name = name;
    }


    /**
     * constructor for dimension
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
    public Rectangle(int x, int y, int w, int h) {
        xpos = x;
        ypos = y;
        this.width = w;
        this.height = h;
    }


    /**
     * name getter
     * 
     * @return name
     *         name of rectangle
     */
    public String getName() {
        return name;
    }


    /**
     * x position getter
     * 
     * @return x position
     *         x position of rectangle
     */
    public int getXpos() {
        return xpos;
    }


    /**
     * y position getter
     * 
     * @return y position
     *         y position of rectangle
     */
    public int getYpos() {
        return ypos;
    }


    /**
     * width getter
     * 
     * @return width
     *         width of rectangle
     */
    public int getWidth() {
        return width;
    }


    /**
     * height getter
     * 
     * @return height
     *         height of rectangle
     */
    public int getHeight() {
        return height;
    }


    /**
     * set the rectangle with given name
     * 
     * @param name
     *            name for setting
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * check if the rectangle is valid
     * 
     * @return true
     *         if the rectangle is valid
     */
    public boolean notValid() {
        return height <= 0 || width <= 0 || xpos < 0 || ypos < 0 || xpos > 1023
            || ypos > 1023 || xpos + width > 1024 || ypos + height > 1024
            || !Character.isLetter(name.charAt(0));
    }


    /**
     * check if two rectangle intersect
     * 
     * @param rec
     *            rectangle to compare with
     * @return true
     *         if two intersect
     * 
     */
    public boolean intersect(Rectangle rec) {
        int x = rec.getXpos();
        int y = rec.getYpos();
        int w = rec.getWidth();
        int h = rec.getHeight();
        int xmin = Math.max(xpos, x);
        int xmax1 = xpos + width;
        int xmax2 = x + w;
        int xmax = Math.min(xmax1, xmax2);
        if (xmax > xmin) {
            int ymin = Math.max(ypos, y);
            int ymax1 = ypos + height;
            int ymax2 = y + h;
            int ymax = Math.min(ymax1, ymax2);
            if (ymax > ymin) {
                return true;
            }

        }
        return false;
    }


    /**
     * check two rectangle have the same dimension
     * 
     * @param rec
     *            rectangle to compare with
     * @return true
     *         if two rectangle have same dimension
     * 
     */
    public boolean sameDim(Rectangle rec) {
        return rec.getXpos() == xpos && rec.getYpos() == ypos && rec
            .getWidth() == width && rec.getHeight() == height;
    }


    /**
     * override the toString method
     */
    @Override
    public String toString() {
        return "(" + name + ", " + xpos + ", " + ypos + ", " + width + ", "
            + height + ")";
    }


    /**
     * check if two rectangle are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle rec = (Rectangle)o;
        return rec.getName().equals(name) && rec.getXpos() == xpos && rec
            .getYpos() == ypos && rec.getWidth() == width && rec
                .getHeight() == height;
    }


    /**
     * compare method to for rectangle
     *
     */
    @Override
    public int compareTo(Rectangle o) {
        return name.compareTo(o.getName());

    }

}
