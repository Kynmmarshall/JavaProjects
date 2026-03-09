
import java.util.HashMap;


public class Excercise4Hashmap {
    public static void main(String[] args) {
        
        HashMap<String,String> Capital = new HashMap<>();
        Capital.put("Cameroon", "Yaounde");
        Capital.put("Nigeria", "Lagos");
        Capital.put("France", "Paris");
        Capital.put("USA", "Washington DC");

        System.out.println(Capital.get("Cameroon"));

        for (String i: Capital.keySet()){
            System.out.printf(i + " ");
        }
        System.out.println();
        for (String i: Capital.values()){
            System.out.printf(i + " ");
        }
    }
}
