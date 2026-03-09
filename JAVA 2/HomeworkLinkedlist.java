import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class HomeworkLinkedlist {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        LinkedList<String> colours2 = new LinkedList<>();
        LinkedList<String> colours3 = new LinkedList<>();

        // Initial population for demonstration
        colours.add("Red");
        colours.add("Green");
        colours.add("Blue");
        colours.add("Yellow");
        colours.add("Orange");
        colours.add("Blue"); // Duplicate for occurrence examples
        System.out.println("Initial linked list: " + colours + "\n");

        // 1. Append the specified element to the end
        colours.add("Purple");
        System.out.println("1. After appending 'Purple': " + colours);
        System.out.println();

        // 2. Iterate through all elements
        System.out.print("2. Iterating all elements: ");
        for (String colour : colours) {
            System.out.print(colour + " ");
        }
        System.out.println();
        System.out.println();

        // 3. Iterate starting from a specified position (index 2)
        System.out.print("3. Iterating from index 2: ");
        for (int i = 2; i < colours.size(); i++) {
            System.out.print(colours.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // 4. Iterate in reverse order
        System.out.print("4. Reverse order: ");
        for (int i = colours.size() - 1; i >= 0; i--) {
            System.out.print(colours.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // 5. Insert element at specified position (index 2)
        colours.add(2, "Cyan");
        System.out.println("5. After inserting 'Cyan' at index 2: " + colours);
        System.out.println();

        // 6. Insert at first and last positions
        colours.addFirst("Pink");
        colours.addLast("Brown");
        System.out.println("6. After addFirst('Pink') and addLast('Brown'): " + colours);
        System.out.println();

        // 7. Insert at front
        colours.addFirst("Black");
        System.out.println("7. After addFirst('Black'): " + colours);
        System.out.println();

        // 8. Insert at end
        colours.addLast("White");
        System.out.println("8. After addLast('White'): " + colours);
        System.out.println();

        // 9. Insert some elements at specified position (index 3)
        LinkedList<String> newColors = new LinkedList<>();
        newColors.add("Magenta");
        newColors.add("Turquoise");
        colours.addAll(3, newColors);
        System.out.println("9. After adding [Magenta, Turquoise] at index 3: " + colours);
        System.out.println();

        // 10. First and last occurrence of specified element ("Blue")
        int firstBlue = colours.indexOf("Blue");
        int lastBlue = colours.lastIndexOf("Blue");
        System.out.println("10. First occurrence of 'Blue': " + firstBlue + ", Last occurrence: " + lastBlue);
        System.out.println();

        // 11. Display elements and their positions
        System.out.println("11. Elements and positions:");
        for (int i = 0; i < colours.size(); i++) {
            System.out.println("    Position " + i + ": " + colours.get(i));
        }
        System.out.println();

        // 12. Remove specified element ("Green")
        colours.remove("Green");
        System.out.println("12. After removing 'Green': " + colours);
        System.out.println();

        // 13. Remove first and last elements
        colours.removeFirst();
        colours.removeLast();
        System.out.println("13. After removing first and last: " + colours);
        System.out.println();

        // 14. Remove all elements (clear)
        colours2.addAll(colours); // save a copy for later
        colours.clear();
        System.out.println("14. After clearing colours: " + colours);
        // Restore colours from colours2 for remaining tasks
        colours.addAll(colours2);
        System.out.println("    Restored colours: " + colours);
        System.out.println();

        // 15. Swap two elements (swap index 1 and 3)
        Collections.swap(colours, 1, 3);
        System.out.println("15. After swapping index 1 and 3: " + colours);
        System.out.println();

        // 16. Shuffle elements
        Collections.shuffle(colours);
        System.out.println("16. After shuffling: " + colours);
        System.out.println();

        // 17. Join two linked lists
        LinkedList<String> moreColours = new LinkedList<>();
        moreColours.add("Indigo");
        moreColours.add("Violet");
        colours.addAll(moreColours);
        System.out.println("17. After joining with [Indigo, Violet]: " + colours);
        System.out.println();

        // 18. Copy linked list to another linked list
        LinkedList<String> copyColours = new LinkedList<>(colours);
        System.out.println("18. Copy of colours: " + copyColours);
        System.out.println();

        // 19. Remove and return first element
        String first = colours.poll(); 
        System.out.println("19. Removed first element: " + first + ", list now: " + colours);
        System.out.println();

        // 20. Retrieve but not remove first element
        String firstPeek = colours.peek();
        System.out.println("20. First element (peek): " + firstPeek + ", list unchanged: " + colours);
        System.out.println();

        // 21. Retrieve but not remove last element
        String lastPeek = colours.peekLast();
        System.out.println("21. Last element (peekLast): " + lastPeek + ", list unchanged: " + colours);
        System.out.println();

        // 22. Check if a particular element exists (e.g., "Red")
        boolean hasRed = colours.contains("Red");
        System.out.println("22. Contains 'Red'? " + hasRed);
        System.out.println();

        // 23. Convert linked list to array list
        ArrayList<String> arrayList = new ArrayList<>(colours);
        System.out.println("23. Converted to ArrayList: " + arrayList);
        System.out.println();

        // 24. Compare two linked lists
        LinkedList<String> anotherList = new LinkedList<>(colours);
        boolean areEqual = colours.equals(anotherList);
        System.out.println("24. colours equals anotherList (same elements)? " + areEqual);
        int common = 0;
        for (String s : colours) {
            if (copyColours.contains(s)) {
                common++;
            }
        }
        System.out.println("    Number of common elements between colours and copyColours: " + common);
        System.out.println();

        // 25. Check if linked list is empty
        System.out.println("25. Is colours empty? " + colours.isEmpty());
        System.out.println();

        // 26. Replace an element (replace index 2 with "Gold")
        if (colours.size() > 2) {
            colours.set(2, "Gold");
            System.out.println("26. After replacing index 2 with 'Gold': " + colours);
        } else {
            System.out.println("26. List too small to replace index 2");
        }
    }
}