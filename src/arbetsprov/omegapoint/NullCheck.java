package arbetsprov.omegapoint;

/**
 * ValidityCheck to check if input is null.
 * check returns false if input is null.
 */
public class NullCheck extends ValidityCheck{
    @Override
    public boolean check(String input) {
        return input != null;
    }

    public String toString(){ return "NullCheck"; }
}
