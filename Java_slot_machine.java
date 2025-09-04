import java.util.Scanner;
import java.util.Random;
public class Java_slot_machine {
    public static void main(String[] args) throws Exception {
    Scanner scanner=new Scanner(System.in);
    Random random=new Random();
    int Bet; 
    int Balance=100;
    char replay;
    char[] Row={'0','$','*','#','@','!','&','%','~'};
    char[] spin={};
     while(true){
    System.out.println("\n******************************\nWELCOME TO JAVA SLOT MACHINE\nSymbols: 0 $ * # @ ! & % ~\n******************************\nCurrent balance: $"+Balance);
    System.out.print("Place your bet amount ($10,$20,$30,$60): $");
    Bet=scanner.nextInt();
    
   if(Balance<Bet){
      while(true){
      System.out.println("You don't have enough Balance :(");
      Bet=scanner.nextInt();
        if(Balance>Bet){
         break;
        }  
   }
   }
   
   Balance-=Bet;
    scanner.nextLine();
    System.out.println("Spinning...");
    switch(Bet){
      case 10: 
      spin=new char[3];
      break;
      case 20: 
      spin=new char[4];
      break;
      case 30: 
      spin=new char[5];
      break;
      case 60: 
      spin=new char[7];
      break;
      default: 
       Balance+=Bet;
       System.out.println("Wrong Input!!!");
    }
    int  i=0,j=0;
    System.out.println("************************");
         
    while(j<spin.length){
            i=random.nextInt(0,9);
            spin[j]=Row[i];
            System.out.print(spin[j]+" ");
            j++;
         }
         System.out.println("\n************************");
      int gain=0;  j=0;
   while(j<spin.length-1){
      i=j+1;
     while(i<spin.length){
       if (spin[j]==spin[i]){
         gain+=15;
       }
       i++;
     }
     j++;
   }   Balance+=gain;
   if(gain==0){
      System.out.println("Sorry you Lost this round :("+"\nYour new Balance is $"+Balance);
   }else{
      System.out.println("You won $"+gain+"\nYour new Balance is $"+Balance);
   }
   System.out.println("Do you want to play again? (Y/N):");
   replay=scanner.next().charAt(0);
   if(replay!='y' && replay!='Y'){
      break;
   }
}
    //scanner.close();
}
}