
import java.util.Collections;
import java.util.LinkedList;


public class Excercise3Linkedlist {
    public static void main(String[] args) {
        
        LinkedList<Integer> list = new LinkedList<Integer> ();

        list.add(3);
        list.add(23);
        list.add(64);
        list.add(12);
        list.add(9);
        list.addFirst(34);
        list.addLast(14);

        Collections.sort(list);
        
        for (int i : list){
            System.out.printf(i + " ");
        }


    }
}
