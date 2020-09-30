
/**
 * Rectangle class
 * 
 * @author light
 * @version {2020 fall}
 *
 */
public class Rectangle implements Comparable<Rectangle> {
    private String name;
    private int Xpos;
    private int Ypos;
    private int width;
    private int height;

    /**
     * constructor
     * 
     * @param name
     *            rectangle name
     * @param xpos
     *            rectangle x position
     * @param ypos
     *            rectangle y position
     * @param width
     *            rectangle width
     * @param height
     *            rectangle height
     */
    public Rectangle(String name, int xpos, int ypos, int width, int height) {
        this.name = name;
        Xpos = xpos;
        Ypos = ypos;
        this.width = width;
        this.height = height;
    }


    public Rectangle(String name) {
        this.name = name;
    }


    public Rectangle(int x, int y, int w, int h) {
        Xpos = x;
        Ypos = y;
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
        return Xpos;
    }


    /**
     * y position getter
     * 
     * @return y position
     *         y position of rectangle
     */
    public int getYpos() {
        return Ypos;
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
        return height <= 0 || width <= 0 || Xpos < 0 || Ypos < 0 || Xpos > 1023
            || Ypos > 1023 || Xpos + width > 1024 || Ypos + height > 1024
            || !Character.isLetter(name.charAt(0));
    }


    /**
     * check if the rectangle intersect with given dimension
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param w
     *            width
     * @param h
     *            height
     * @return true
     *         if the rectangle intersect with given dimension
     */
    public boolean intersect(int x, int y, int w, int h) {
        int xmin = Math.max(Xpos, x);
        int xmax1 = Xpos + width;
        int xmax2 = x + w;
        int xmax = Math.min(xmax1, xmax2);
        if (xmax > xmin) {
            int ymin = Math.max(Ypos, y);
            int ymax1 = Ypos + height;
            int ymax2 = y + h;
            int ymax = Math.min(ymax1, ymax2);
            if (ymax > ymin) {
                return true;
            }

        }
        return false;
    }


    public boolean sameDim(Rectangle rec) {
        return rec.getXpos() == Xpos && rec.getYpos() == Ypos && rec
            .getWidth() == width && rec.getHeight() == height;
    }


    public void printRectangle() {
        System.out.println("(" + name + ", " + Xpos + ", " + Ypos + ", " + width
            + ", " + height + ")");
    }


    public boolean equals(Rectangle rec) {
        return rec.getName().equals(name) && rec.getXpos() == Xpos && rec
            .getYpos() == Ypos && rec.getWidth() == width && rec
                .getHeight() == height;
    }


    @Override
    public int compareTo(Rectangle o) {
        // TODO Auto-generated method stub
        return name.compareTo(o.getName());

    }

}
