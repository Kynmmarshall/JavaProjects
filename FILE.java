import java.util.Scanner;
import java.util.function.ToDoubleFunction;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


class FILE{ 
   public static void main(String[] arg){
     ArrayList<Integer> list=new ArrayList<Integer>();
     Scanner scanner=new Scanner(System.in);
     String p;
  try(BufferedReader read=new BufferedReader(new FileReader("tex.txt"))){
    while((p=read.readLine())!=null){  
    System.out.println(p);
    }
     System.out.println("File Read");
  }
  catch(FileNotFoundException e){
   System.out.println("File Not Found");
  }
  catch(IOException e){
    System.out.println("File IOExeop!!!");
  }
    scanner.close();
   }
   }
