import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// -------------------------------------------------------------------------
/**
 * Test the world class
 *
 * @author Ziqi Xiao
 * @version 2020 fall
 */
public class WorldTest extends student.TestCase {

    /**
     * get the output string of input file
     * 
     * @param path
     *            path of file
     * @return
     *         output string
     * @throws IOException
     *             IO exception for file reader
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }


    /**
     * setUp the condition.
     */
    public void setUp() {
        // Nothing to setup here. May not be true for your tests
    }


    /**
     * Test basic.
     * 
     * @throws Exception
     */
    public void testBasic() throws Exception {
        RectangleDB manager = new RectangleDB();
        assertNotNull(manager);
        String curPath = System.getProperty("user.dir");
        String filePath1 = curPath + "/src/intersection.txt";
        String[] args1 = new String[1];
        args1[0] = filePath1;
        RectangleDB.main(args1);
        assertFuzzyEquals(readFile(curPath + "/src/intersectionout.txt"),
            systemOut().getHistory());
    }

}
