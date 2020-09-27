import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// -------------------------------------------------------------------------

/**
 * the parser class
 *
 * @author Ziqi Xiao
 * @version 2020 fall
 */
public class Parser {
    private World myWorld;

    /**
     * the parser constructor
     *
     * @param world
     *            the world database
     * 
     */

    public Parser(World world) {
        this.myWorld = world;
    }


    /**
     * the parser constructor
     * 
     * @param theFile
     *            File locate at specific path
     *
     * @return boolean
     *         return true if the file is read
     * 
     */
    public boolean readCmdFile(File theFile) throws IOException {
        Scanner sc = new Scanner(theFile);
        while (sc.hasNext()) { // While the scanner has information to read
            String cmd = sc.next(); // Read the next term
            if (cmd.equals("insert")) {
                String nameString = sc.nextLine().trim().replaceAll("\\s{1,}",
                    " ");
                String[] input = nameString.split(" ");
                myWorld.insert(input[0], Integer.parseInt(input[1]), Integer
                    .parseInt(input[2]), Integer.parseInt(input[3]), Integer
                        .parseInt(input[4]));

            }

            else if (cmd.equals("remove")) {
                String nameString = sc.nextLine().trim().replaceAll("\\s{1,}",
                    " ");
                char first = nameString.charAt(0);
                if (Character.isDigit(first)) {
                    String[] region = nameString.split(" ");
                    myWorld.remove(Integer.parseInt(region[0]), Integer
                        .parseInt(region[1]), Integer.parseInt(region[2]),
                        Integer.parseInt(region[3]));

                }

                else {
                    myWorld.remove(nameString);
                }
            }
            else if (cmd.equals("search")) {
                String nameString = sc.nextLine().trim().replaceAll("\\s{1,}",
                    " ");
                myWorld.search(nameString);
            }
            else if (cmd.equals("regionsearch")) {
                String nameString = sc.nextLine().trim().replaceAll("\\s{1,}",
                    " ");
                String[] region = nameString.split(" ");
                myWorld.regionsearch(Integer.parseInt(region[0]), Integer
                    .parseInt(region[1]), Integer.parseInt(region[2]), Integer
                        .parseInt(region[3]));

            }
            else if (cmd.equals("intersections")) {
                myWorld.intersections();
            }
            else if (cmd.equals("dump")) {
                myWorld.dump();
            }
            else {
                System.out.println("Unrecognized input: |" + cmd + "|");
            }

        }
        sc.close();
        return true;
    }

}
