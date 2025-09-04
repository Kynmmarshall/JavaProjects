import java.util.Scanner;
public class App{
  public static void main(String arg[]){
    Scanner scanner=new Scanner(System.in);
    System.out.println("How many fib do u want: ");
   int i=0,j=1,k,l,p=0;
   k=scanner.nextInt();
   scanner.nextLine();
   System.out.printf(i+" "+j);
   while (p<k) {
      l=j;
      j=i+j;
      i=l;
      System.out.printf(" "+j);
      p++;
    }
  }
}