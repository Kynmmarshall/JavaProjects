import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=scanner.nextInt();
        scanner.nextLine();
        int i=1;
        System.out.println("The multiplication table of 11 is: ");
    while (i<=12) {
        System.out.printf("\n"+num+" * "+i+" = "+num*i+"\n");
        i++;
    }
    }
} 