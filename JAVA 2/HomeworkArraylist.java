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
        
        System.out.printf("1. ");
        System.out.println(colours);

        //question 2 printing the collesction
        System.out.printf("2. ");
        for(String i : colours){
            System.out.printf(i + " ");
        }

        System.out.println();

        //question 3 insert an element into the array list at the first position.
        System.out.printf("3. ");
        colours.addFirst("brown");
        System.out.println(colours);

        //question 4 retrieve an element (at a specified index) from a given array list
        System.out.printf("4. ");
        System.out.println(colours.get(2));

        //question 5 update an array element by the given element.
        System.out.printf("5. ");
        colours.add(1, "indigo");
        System.out.println(colours);
        
        //question 6 remove the third element from an array list.
        System.out.printf("6. ");
        colours.remove(2);
        System.out.println(colours);

        //question 7 search for an element in an array list.
        System.out.printf("7. ");
        for(int i=0 ; i < colours.size(); i++){
            if (colours.get(i) == "pink"){
                System.out.println(i);
            }
        }

        // question 8 Write a Java program to sort a given array list.
        System.out.printf("8. ");
        Collections.sort(colours);
        System.out.println(colours);

        //question 9 copy one array list into another.
        System.out.printf("9. ");
        for(String i : colours){
            colours2.add(i);
        }
        System.out.println("colours2 = "+colours2);

        //question 10 shuffle elements in an array list.
        System.out.printf("10. ");
        Collections.shuffle(colours);
        System.out.println("shuffled colours = "+ colours);

        //question 11 reverse elements in an array list.
        System.out.printf("11. ");
        Collections.reverse(colours);
        System.out.println("reverse colours = "+colours);

        //question 12 extract a portion of an array list.
        System.out.printf("12. ");
        for (int i = 0; i < 4; i++ ){
            sublistColours.add(colours.get(i));
        }
        System.out.println("sublist colours = "+ sublistColours);

        //question 13  compare two array lists.
        System.out.printf("13. ");
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
        System.out.printf("14. ");
        Collections.swap(colours, 0, 2);
        System.out.println("Swapped colours = "+ colours);

        //question 15  join two array lists.
        System.out.printf("15. ");
        colours2.clear();
        colours2.addAll(colours);
        colours2.addAll(sublistColours);
        System.out.println("combination of colours and subcolours = "+colours2);

        //question 16 clone an array list to another array list.
        System.out.printf("16. ");
        ArrayList<String> clonedColours = (ArrayList<String>)colours.clone();
        System.out.println("clone colours = "+ clonedColours);

        //question 17 empty an array list.
        System.out.printf("17. ");
        clonedColours.clear();
        System.out.println("emptied clonedcolours = " +clonedColours);

        //question 18 test whether an array list is empty or not.
        System.out.printf("18. ");
        if (clonedColours.isEmpty()){
            System.out.println("empty arraylist");
        }else{
            System.out.println("arraylist not emty");
        }

        //question 19 trimming the capacity of an array list.
        System.out.print("19. ");
        colours.trimToSize();
        System.out.println(colours);

        //question 20 increase an array list size.
        System.out.print("20. ");
        colours.ensureCapacity(8);
        System.out.println(colours);

        //question 21 the second element of an ArrayList with the specified element.
        System.out.printf("21. ");
        colours.add(1, "new second");
        System.out.println(colours);

        // question 22 print all the elements of an ArrayList using the elements' position.
        System.out.printf("22. ");
        for(int i =0  ; i<colours.size(); i++){
            System.out.printf(colours.get(i) + " ");
        }
    }
}
