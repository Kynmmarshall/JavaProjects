import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework_ICTU_Email_Validation {
    public static void main(String[] args) {
        // Correct email regex pattern (no extra quotes, single backslash)
        Pattern myPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@ictuniversity.edu.cm", Pattern.CASE_INSENSITIVE);
        // Example email to test
        String email = "khjkjj@ictuniverity.edu.cm";
        Matcher matcher = myPattern.matcher(email);

        boolean matchFound = matcher.matches();

        if (matchFound) {
            System.out.println("Valid email address!");
        } else {
            System.out.println("Invalid email address!");
        }
    }
}
