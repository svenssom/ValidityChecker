package arbetsprov.omegapoint;

/**
 * ValidityCheck to check if input is a swedish social security number.
 * Acceptable formats: yymmdd-xxxx, yyyymmdd-xxxx, yymmddxxxx, yyyymmddxxxx
 * Accepts people born years 1900-2099.
 * check returns true if the formatting and control value is correct
 */
public class SocialSecurityCheck extends ValidityCheck {
    @Override
    public boolean check(String input) {
        if(input == null)
            return false;
        // Check input format, ensure the date is possible
        if (input.matches("(19|20)?\\d{2}(0[1-9]|1[0-2])([0-2][1-9]|3[0-1])-?\\d{4}")) {
            input = input.replace("-", "");
            int controlValue = Integer.parseInt(input.substring(input.length() - 1));
            // Remove unnecessary first two digits if present
            if (input.length() == 12)
                input = input.substring(2);
            int controlSum = calculateControlSum(input);

            return controlSum == controlValue;
        }
        return false;
    }

    /*
     * Calculate control value.
     * input format yymmddxxxx
     */
    private int calculateControlSum(String input){
        if (input.length()!=10)
            return -1;
        int controlSum = 0;
        for (int i = 0; i < input.length()-1; i++) {
            int a = Integer.parseInt(input.substring(i, i + 1));
            if (i%2==0) {
                a=a*2;
                if (String.valueOf(a).length()>1){
                    a = a - 9;
                }
            }
            controlSum+=a;
        }
        controlSum = controlSum%10;
        controlSum = 10 - controlSum;
        controlSum = controlSum%10;
        return controlSum;
    }

    @Override
    public String toString() { return "SocialSecurityCheck"; }

}
