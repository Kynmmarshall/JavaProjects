
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class myFrame {
    public static void main(String[] args) {
        monday myWindow = new monday();
        ImageIcon image = new ImageIcon("me.png");
        myWindow.setIconImage(image.getImage());
        JButton b1 = new JButton("Hello world");
        while (true){
        b1.setBounds(100, 100, 100, 100);
        b1.setBackground(Color.CYAN);
        myWindow.add(b1);}
    }
}
