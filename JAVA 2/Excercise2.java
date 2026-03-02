import java.util.ArrayList;
import java.util.Collections;

public class Excercise2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<Integer> ();

        numbs.add(1);
        numbs.add(5);
        numbs.add(7);
        numbs.add(3);
        numbs.add(8);
        numbs.add(9);
        numbs.add(2);

        Collections.sort(numbs);
        for(int i : numbs){
            System.out.printf(i+ " ");
        }


    }
}
