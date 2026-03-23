import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class myFrameButtons extends JFrame{
    public static void main(String[] args) {
        myFrameButtons kynmwindow2 = new myFrameButtons();
        kynmwindow2.setVisible(true);
        kynmwindow2.setSize(800, 500);
        kynmwindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kynmwindow2.setTitle("kynm radiant reyna player windows");
        kynmwindow2.setResizable(false);

        JButton b1 = new JButton("I");
        JButton b2 = new JButton("Love"); 
        JButton b3 = new JButton("Valorant"); 
        JButton b4 = new JButton(""); 
        while (true){
        b1.setBounds(20, 20,100 ,100 );
        b1.setBackground(Color.green);
        kynmwindow2.add(b1);

        
        b2.setBounds(120, 20,100 ,100 );
        b2.setBackground(Color.red);
        kynmwindow2.add(b2);

        b3.setBounds(220, 20,100 ,100 );
        b3.setBackground(Color.yellow);
        kynmwindow2.add(b3);

        b4.setBounds(5, 10,20 ,500 );
        b4.setBackground(Color.DARK_GRAY);
        kynmwindow2.add(b4);
    
    }
    }
}
