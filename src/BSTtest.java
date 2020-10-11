import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the BST function (you should throw this away for your project)
 *
 * @author CS3114 staff
 * @version August, 2018
 */
public class BSTTest extends TestCase {

    /**
     * setUp the condition.
     */
    public void setUp() {
        // Nothing to setup here. May not be true for your tests
    }


    /**
     * Test basic.
     */
    public void testBasic() {
        BST<Integer> bst1 = new BST<Integer>();
        assertNotNull(bst1);
        bst1.insert(1);
        bst1.insert(2);
        bst1.insert(3);
        bst1.insert(4);
        bst1.insert(1);
        MyList<Integer> list1 = bst1.search(1);
        assertEquals(list1.getSize(), 2);
        assertEquals(bst1.getSize(), 5);
        bst1.remove(2, null);
        assertEquals(bst1.getSize(), 4);
        bst1.remove(999, null);
        assertEquals(bst1.getSize(), 4);
        bst1.dump();
        bst1.remove(1, null);
        bst1.dump();
        bst1.remove(1, null);
        bst1.remove(3, null);
        bst1.remove(4, null);
        assertEquals(bst1.getSize(), 0);
        
    }

}
