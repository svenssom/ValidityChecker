package arbetsprov.omegapoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Test class for ValidityChecker
 * Add all checks, run on null input first
 * Then test all lines in test_input
 * print and clear error log between each line.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<ValidityCheck> vcs = new ArrayList<>();
        vcs.add(new NullCheck());
        vcs.add(new SocialSecurityCheck());
        vcs.add(new RegNrCheck());
        ValidityChecker vc = new ValidityChecker(vcs);
        vc.check();
        try (Scanner sc = new Scanner(new File("testInput/test_input"))){
            while (sc.hasNextLine()){
                vc.setInput(sc.nextLine());
                vc.check();
                vc.printErrorLog();
                vc.clearLog();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
