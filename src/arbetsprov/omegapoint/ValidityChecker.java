package arbetsprov.omegapoint;

import java.util.Collection;
import java.util.LinkedList;

/**
 * ValidityChecker
 * checks: ValidityChecks to be performed
 * input: String to check
 * errorlog: log for failed checks, logs input and check when a check fails.
 */

public class ValidityChecker {

    private LinkedList<ValidityCheck> checks;
    private String input;
    private LinkedList<String> errorlog;

    public ValidityChecker(Collection<ValidityCheck> vcs){
        checks = new LinkedList<>(vcs);
        errorlog = new LinkedList<>();
    }
    public ValidityChecker(ValidityCheck vc){
        checks = new LinkedList<>();
        checks.add(vc);
        errorlog = new LinkedList<>();
    }
    public ValidityChecker(Collection<ValidityCheck> vcs, String s){
        checks = new LinkedList<>(vcs);
        input = s;
    }

    // Set input value. Replaces old value.
    public void setInput(String s){
        input = s;
    }

    // Set ValidityChecks. Replaces old checks.
    public void setChecks(Collection<ValidityCheck> vcs){ checks = new LinkedList<>(vcs); }

    /*
     * check performs all validityChecks on the input.
     * any errors are stored in the errorlog
     * returns false if any check fails
     */
    public boolean check(String s){
        boolean res=true;
        for (ValidityCheck c : checks){
            if (!c.check(s)){
                errorlog.add( s + " : Failed " + c );
                res=false;
            }
            res = c.check(s) && res;
        }
        return res;
    }
    // perform check on pre-set input
    public boolean check(){ return check(input); }

    // print errorlog. Does NOT erase the log.
    public void printErrorLog(){
        for (String e : errorlog) {
            System.out.println(e);
        }
    }

    // Clear errorlog.
    public void clearLog(){ errorlog.clear(); }

}
