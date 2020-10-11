import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the rectangle class
 *
 * @author Ziqi Xiao
 * @version 2020 fall
 */
public class RectangleTest extends TestCase {

    /**
     * setUp the condition.
     */
    public void setUp() {
        // Nothing to setup here. May not be true for your tests
    }


    /**
     * Test basic.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testBasic() {
        Rectangle rec1 = new Rectangle("a", 1, 1, 0, 1);
        Rectangle rec2 = new Rectangle("_a", 1, 1, 0, 1);
        Rectangle rec3 = new Rectangle("a", 1, 1, 1, 1);
        Rectangle rec4 = new Rectangle("a", 1, 1, 1, 1);
        Rectangle rec5 = new Rectangle("b", 1, 1, 1, 1);
        Rectangle rec6 = new Rectangle("c", 1, 1, 1, 1);
        Rectangle rec7 = new Rectangle("d", 1, 1, 1, 1);
        assertEquals(rec1.notValid(), true);
        assertEquals(rec2.notValid(), true);
        assertEquals(rec3.equals(rec4), true);
        rec4.setName("__1");
        assertEquals(rec4.notValid(), true);
        assertEquals(rec5.equals(rec6), false);
        assertEquals(rec6.sameDim(rec7), true);
        assertEquals(rec6.intersect(rec3), true);
        assertEquals(rec6.equals("a"), false);

    }

}
