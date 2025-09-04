import java.util.Scanner;

public class Weight_converter {
    public static void main(String[] args) throws Exception {
    Scanner scanner=new Scanner(System.in);
    int choice=0;
    double weight=0;
    while (true) {
    System.out.println("Enter the weight");
    weight=scanner.nextDouble();
    System.out.println("HELLO What do you want to do: ");
    System.out.println("1.Pounds to Kilograms \n2.kilograms to pounds\n3.Exit");
    choice=scanner.nextInt();
    scanner.nextLine();
    if (choice==1) {
        weight=weight*0.453592;
        System.out.printf("Weight = %.2f kilograms\n\n",weight);
    }
    else if(choice==2) {
    weight=weight/0.453592;
   System.out.printf("Weight = %.2f pounds\n\n",weight);
    }
    else if(choice==3){
        break;
    }
    else{
        System.out.println("wrong Input!!!\n\n");
    }
    //scanner.close();
}
    } 
}