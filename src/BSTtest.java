import student.TestCase;

/**
 * unit test for BST class
 * 
 * @author light
 * @version {2020 fall}
 * 
 */
public class BSTtest extends TestCase {
    /**
     * test the BST class
     */
    public void testInsert() {
        System.out.println("##############not valid case################");
        BST bstTest = new BST();
        Rectangle recValid1 = new Rectangle("a",1,0,2,4);
        Rectangle recNotValid1 = new Rectangle("_a",1,0,2,4);
        Rectangle recNotValid2 = new Rectangle("a",1,0,2,0);
        bstTest.dump();
        bstTest.insert(recValid1);
        bstTest.dump();
        bstTest.insert(recNotValid1);
        bstTest.dump();
        bstTest.insert(recNotValid2);
        bstTest.dump();
        
        
        
        System.out.println("##############simple case################");
        BST bst = new BST();
        bst.dump();
        Rectangle rec1 = new Rectangle("a",1,0,2,4);
        Rectangle rec2 = new Rectangle("b",4,3,6,1);
        Rectangle rec3 = new Rectangle("c",2,4,123,6);
        Rectangle rec4 = new Rectangle("c",2,4,123,6);
        Rectangle rec5 = new Rectangle("a",2,4,123,6);
        bst.insert(rec1);
        bst.insert(rec2);
        bst.insert(rec3);
        bst.dump();
        bst.insert(rec4);
        bst.dump();
        bst.insert(rec5);
        bst.dump();
        bst.remove("a");
        bst.dump();
        bst.remove("light");
        bst.remove("a");
        bst.remove("b");
        bst.remove("c");
        bst.dump();
        bst.remove("c");
        bst.insert(rec1);
        bst.insert(rec2);
        bst.insert(rec3);
        bst.insert(rec5);
        bst.dump();
        bst.search("a");
        bst.search("b");
        bst.search("d");
        bst.insert(rec1);
        bst.insert(rec2);
        bst.insert(rec3);
        bst.insert(rec5);
        bst.dump();
        bst.remove(2,4,123,7);
        bst.remove(2,4,123,6);
        bst.dump();
        bst.remove(2,4,123,6);
        bst.dump();
        bst.remove(1,0,2,3);
        bst.remove(1,0,2,4);
        bst.dump();
        bst.remove(4,3,6,1);
        bst.dump();
        bst.remove(4,3,6,1);
        bst.dump();
        System.out.println("##############complex case################");
        System.out.println("##############insert################");
        BST bst1 = new BST();
        bst1.dump();
        Rectangle recA1 = new Rectangle("a",1,0,2,4);
        Rectangle recA2 = new Rectangle("a",1,1,2,4);
        Rectangle recA3 = new Rectangle("a",1,2,2,4);
        Rectangle recB = new Rectangle("b",4,3,6,1);
        Rectangle recC = new Rectangle("c",2,4,123,6);
        Rectangle recD = new Rectangle("d",2,4,124,6);
        Rectangle recE1 = new Rectangle("e",2,4,125,6);
        Rectangle recE2 = new Rectangle("e",1,4,125,6);
        Rectangle recF = new Rectangle("f",2,4,126,6);
        Rectangle recG = new Rectangle("g",2,4,127,6);
        Rectangle recH = new Rectangle("h",2,4,128,6);
        Rectangle recX1 = new Rectangle("x",2,4,129,6);
        Rectangle recX2 = new Rectangle("x",2,4,123,7);
        Rectangle recX3 = new Rectangle("x",2,4,123,8);
        Rectangle recY = new Rectangle("y",2,4,123,9);
        bst1.insert(recG);
        bst1.insert(recD);
        bst1.insert(recA1);
        bst1.insert(recA2);
        bst1.insert(recA3);
        bst1.insert(recE1);
        bst1.insert(recE2);
        bst1.insert(recF);
        bst1.insert(recB);
        bst1.insert(recC);     
        bst1.insert(recX1);
        bst1.insert(recH);
        bst1.insert(recX2);
        bst1.insert(recX3);
        bst1.insert(recY);
        bst1.dump();
        System.out.println("##############search################");
        bst1.search("A");
        bst1.search("a");
        bst1.search("b");
        bst1.search("x");
        bst1.search("x");
        bst1.search("y");
        System.out.println("##############remove################");
        bst1.remove("light");
        bst1.remove("a");
        bst1.dump();
        bst1.remove("d");
        bst1.dump();
        bst1.remove(1,2,2,3);
        bst1.remove(1,2,2,4);
        bst1.dump();
        bst1.remove(2,4,125,6);
        bst1.dump();
        bst1.remove(2,4,129,6);
        bst1.dump();
        bst1.remove("x");
        bst1.dump();
        bst1.remove("g");
        bst1.dump();
        bst1.remove("a");
        bst1.remove("a");
        bst1.remove(1,1,2,4);
        bst1.remove("b");
        bst1.remove("c");
        bst1.remove("e");
        bst1.remove("f");
        bst1.remove("h");
        bst1.remove("x");
        bst1.remove("y");
        bst1.dump();
        bst1.remove("a");
        bst1.remove(1,2,3,4);
        bst1.dump();
        System.out.println("##############intersect && region search################");
        BST bst2 = new BST();
        Rectangle recI = new Rectangle("a",0,0,10,10);
        Rectangle recII = new Rectangle("b",10,0,20,20);
        Rectangle recIII= new Rectangle("c",9,9,2,2);
        bst2.insert(recI);
        bst2.insert(recII);
        bst2.insert(recIII);
        bst2.dump();
        bst2.regionSearch(100, 100, 1, 1);
        bst2.regionSearch(0, 0, 1, 1);
        bst2.regionSearch(0, 0, 9, 9);
        bst2.regionSearch(0, 0, 10, 10);
        bst2.regionSearch(5, 0, 10, 5);
        bst2.regionSearch(9, 10, 1, 1);
        bst2.regionSearch(9, 9, 2, 2);
        bst2.intersections();
        Rectangle recIV= new Rectangle("d",9,0,3,3);
        bst2.insert(recIV);
        bst2.intersections();
        
        
        
        
        
                
        
        
        
        
        
        
        
        
    }
}
