package arbetsprov.omegapoint;

/**
 * ValidityCheck to check if input is a valid swedish car registration number.
 * check returns true if the string is correctly formatted as a swedish car registration number. (Three letters followed by three numbers, case insensitive)
 * TODO: Check for illegal letter combinations banned by transportstyrelsen.
 */
public class RegNrCheck extends ValidityCheck {

    @Override
    public boolean check(String input) {
        if (input == null)
            return false;
        return input.matches("\\w{3}\\d{3}");
    }

    public String toString(){ return "RegNrCheck"; }
}
