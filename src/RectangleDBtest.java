import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author {Ziqi Xiao}
 * @version {2020 fall}
 */
public class RectangleDBtest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


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
     * Get code coverage of the class declaration.
     * 
     * @throws IOException
     */
    public void testRInit() throws IOException {
        String curPath = System.getProperty("user.dir");
        String filePath = curPath + "/src/input.txt";
        String[] args = new String[1];
        args[0] = filePath;
        RectangleDB.main(args);
        assertFuzzyEquals(readFile(curPath + "/src/output.txt"), systemOut()
            .getHistory());

    }
}
