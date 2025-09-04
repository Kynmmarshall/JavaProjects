import java.util.Scanner;
public class bosh{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
    int b=4;
    System.out.println(b++);
    System.out.println(b);
        try{
        System.out.println("Enter a number1: "+b);
        int num1= scanner.nextInt();
        System.out.println("Enter a number2: ");
        int num2= scanner.nextInt();}
         catch(Exception e){
            System.out.println("Wrong input!!!");
         }
    }
}