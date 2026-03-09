
import java.util.HashSet;

public class Exercise6HashsetInteger {
    public static void main(String[] args) {
        HashSet <Integer> numbers = new HashSet<Integer>();

        numbers.add(2);
        numbers.add(23);
        numbers.add(16);
        numbers.add(2);
        numbers.add(6);
        numbers.add(17);
        numbers.add(27);
        numbers.add(31);
        numbers.add(9);
        numbers.add(8);

        for (int i = 0; i<=100 ; i++){
            if(numbers.contains(i)){
            System.out.println(i + " is in the set");
            }
            else{
              System.out.println(i + " is not in the set");
            }
        }
        System.out.println(numbers);

    }
}
