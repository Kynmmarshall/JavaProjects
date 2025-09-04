import java.util.Scanner;

public class project2 {
    public static void main(String[] args) {
         int PIN = 1234;
        double balance = 5000.00;
    while (true) {
        System.out.println("\n**** Welcome to the ATM ****");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == PIN) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Incorrect PIN.");
        }
}
    }
}
