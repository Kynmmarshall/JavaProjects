import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class myFrameLabels extends JFrame{
    public static void main(String[] args) {
        myFrameLabels kynmwindow2 = new myFrameLabels();
        kynmwindow2.setVisible(true);
        kynmwindow2.setSize(800, 500);
        kynmwindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kynmwindow2.setTitle("kynm radiant reyna player windows");
        kynmwindow2.setResizable(false);

        JLabel l1 = new JLabel("label 1");
        l1.setBounds(10, 10, 200, 200);
        l1.setBackground(Color.BLUE);
        
        kynmwindow2.add(l1);
    }
}
