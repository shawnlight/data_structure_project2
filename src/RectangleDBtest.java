import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class RectangleDBTest extends TestCase {

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
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testRInit() throws Exception {
        RectangleDB manager = new RectangleDB();
        assertNotNull(manager);
        String curPath = System.getProperty("user.dir");
        String filePath1 = curPath + "/src/complexcase.txt";
        String[] args1 = new String[1];
        args1[0] = filePath1;
        RectangleDB.main(args1);
        assertFuzzyEquals(readFile(curPath + "/src/complexout.txt"), systemOut()
            .getHistory());

    }
}
