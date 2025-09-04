import java.util.Scanner;
public class project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("Enter your score (0-100): ");
        int score = scanner.nextInt();

        if (score >= 0 & score <= 100) {
            if (score >= 90) {
                System.out.println("Grade: A - Excellent!");
            } else if (score >= 75) {
                System.out.println("Grade: B - Very Good!");
            } else if (score >= 60) {
                System.out.println("Grade: C - Good.");
            } else if (score >= 50) {
                System.out.println("Grade: D - Pass.");
            } else {
                System.out.println("Grade: F - Fail.");
            }
        } else {
            System.out.println("Invalid score. Please enter between 0 and 100.");
        }
    }
}
}
