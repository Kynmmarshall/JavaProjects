import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("HELLO WORLD");
        ArrayList<String> student = new ArrayList<String>();
        student.add("peter");
        student.add("mary");
        student.add("jane");
        student.add("john");
        student.add("wilson");
        student.add("marshall");
        student.add("martha");
        student.add("jack");
        student.add("will");
        student.add("ben");
        
        System.out.println(student.get(5));
        student.set(5,"mannn");
        System.out.printf("Total Number Of Students: "+student.size());
        System.out.println();

        for (int i=0; i< student.size(); i++){
            System.out.printf(student.get(i)+ " ");
        }
    }
    }
