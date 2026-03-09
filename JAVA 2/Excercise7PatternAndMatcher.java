
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excercise7PatternAndMatcher {
    public static void main(String[] args) {
        Pattern myPattern = Pattern.compile("[word dull beef shit]", Pattern.CASE_INSENSITIVE);
        // not we can also check "[a-z]" , "[1-9]", "word", "n+", can also be used to check if particular email
        //belong to institution or other checks
        Matcher matcher = myPattern.matcher("text to find myword");

        boolean matchFound = matcher.find();

        if(matchFound){
            System.out.println("Match found!");
        }else{
            System.out.println("Match Not Found!");
        }
    }
}

//h/w pattern of ict univerity email