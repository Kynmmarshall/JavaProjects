import java.util.Scanner;
public class project3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    while(true){
        System.out.print("\nEnter your age: ");
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.print("Have you passed the driving test? (yes/no): ");
            String passedTest = scanner.next();

            if (passedTest.equalsIgnoreCase("yes")) {
                System.out.println("You are eligible for a driving license.");
            } else {
                System.out.println("You are not eligible for a driving license.");
            }
        } else {
            System.out.println("You must be at least 18 years old to be eligible.");
        }
    }}
    }