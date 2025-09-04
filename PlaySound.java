import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class PlaySound{ 
   public static void main(String[] arg){
    File file=new File("sou.wav");
  try(AudioInputStream audio= AudioSystem.getAudioInputStream(file)){
    Clip clip=AudioSystem.getClip();
    clip.open(audio);
    int p=1;
    while(true){
    clip.start();
    if(p==0){
      break;
    }
  }
    System.out.println("NO PB");
  }  
  catch(FileNotFoundException e){
  System.out.println("File Not Found");
  }
  catch(UnsupportedAudioFileException e){
    System.out.println("File not supported");
  }
  catch(IOException e){
     System.out.println("Something went wrong");
  }
  catch(LineUnavailableException e){
     System.out.println("Line UNavaiable");
  }
  finally{
    System.out.println("DSSDS!!!");
  }
}
}