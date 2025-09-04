import java.util.Scanner;

public class basic_calculator {
    public static void main(String[] args) throws Exception {
    Scanner scanner=new Scanner(System.in);
    double num1,num2;
    char operator;
    String exit;
    while(true){
    System.out.println("Enter your first number");
    num1=scanner.nextDouble();
    scanner.nextLine();
    System.out.println("What operation do you want to carry out? (+,-,/,*)");
    operator=scanner.next().charAt(0);
    System.out.println("Enter your second number");
    num2=scanner.nextDouble();
    switch (operator) {
        case '+'->System.out.printf("Result = %.2f\n\n",(num1+num2));
        case '-'->System.out.printf("Result = %.2f\n\n",(num1-num2));
        case '/'->System.out.printf("Result = %.2f\n\n",(num1/num2));
        case '*'->System.out.printf("Result = %.2f\n\n",(num1*num2));
        default ->System.out.printf("Wrong Input!!!\n\n");
    }
    System.out.println("Do you want to Exit? (yes or no)");
    exit=scanner.next();
   if(exit.equalsIgnoreCase("yes")){break;}
}
}
}