import java.util.ArrayList;
import java.util.Collections;

public class HomeworkArraylist{
    public static void main(String[] args) {
        //question 1 creating array list of colours and printing collection
        ArrayList<String> colours = new ArrayList<String>();
        ArrayList<String> colours2 = new ArrayList<String>();
        ArrayList<String> sublistColours = new ArrayList<String>();

        colours.add("blue");
        colours.add("red");
        colours.add("green");
        colours.add("yellow");
        colours.add("pink");
        colours.add("violet");
        
        System.out.println(colours);

        for(String i : colours){
            System.out.printf(i + " ");
        }

        System.out.println();

        //question 3 insert an element into the array list at the first position.
        colours.addFirst("brown");

        //question 4 retrieve an element (at a specified index) from a given array list
        System.out.println(colours.get(2));

        //question 5 update an array element by the given element.
        colours.add(1, "indigo");
        
        //question 6 remove the third element from an array list.
        colours.remove(2);

        //question 7 search for an element in an array list.
        for(int i=0 ; i < colours.size(); i++){
            if (colours.get(i) == "pink"){
                System.out.println(i);
            }
        }

        // question 8 Write a Java program to sort a given array list.
        Collections.sort(colours);
        System.out.println(colours);

        //question 9 copy one array list into another.
        for(String i : colours){
            colours2.add(i);
        }
        System.out.println("colours2 = "+colours2);

        //question 10 shuffle elements in an array list.
        Collections.shuffle(colours);
        System.out.println("shuffled colours = "+ colours);

        //question 11 reverse elements in an array list.
        Collections.reverse(colours);
        System.out.println("reverse colours = "+colours);

        //question 12 extract a portion of an array list.
        for (int i = 0; i < 4; i++ ){
            sublistColours.add(colours.get(i));
        }
        System.out.println("sublist colours = "+ sublistColours);

        //question 13  compare two array lists.
        int common = 0;
        for (String i : colours){
            for(String j : sublistColours){
                if(i == j){
                    common+=1;
                }
            }
        }
        System.out.println("Number of common elemens in colours and subcolours = " + common);

        //question 14 two elements in an array list.
        Collections.swap(colours, 0, 2);
        System.out.println("Swapped colours = "+ colours);

        //question 15  join two array lists.
        colours2.clear();
        colours2.addAll(colours);
        colours2.addAll(sublistColours);
        System.out.println("combination of colours and subcolours = "+colours2);

        //question 16 clone an array list to another array list.
        ArrayList<String> clonedColours = (ArrayList<String>)colours.clone();
        System.out.println("clone colours = "+ clonedColours);

        //question 17 empty an array list.
        clonedColours.clear();
        System.out.println("emptied clonedcolours = " +clonedColours);

        //question 18 test whether an array list is empty or not.
        if (clonedColours.isEmpty()){
            System.out.println("empty arraylist");
        }else{
            System.out.println("arraylist not emty");
        }

        //question 19 trimming the capacity of an array list.
        colours.trimToSize();

        //question 20 increase an array list size.
        colours.ensureCapacity(8);

        //question 21 the second element of an ArrayList with the specified element.
        colours.add(1, "new second");

        // question 22 print all the elements of an ArrayList using the elements' position.
        for(int i =0  ; i<colours.size(); i++){
            System.out.printf(colours.get(i) + " ");
        }
    }
}
