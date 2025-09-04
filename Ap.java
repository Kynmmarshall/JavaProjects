import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ap extends JPanel implements ActionListener {

    private int x = 50, y = 50, diameter = 30;
    private int xSpeed = 5, ySpeed = 4;
    private Color ballColor = Color.RED;
    private Timer timer;

    public Ap() {
        timer = new Timer(10, this); // refresh every 20ms
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(ballColor);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += xSpeed;
        y += ySpeed;

        if (x < 0 || x > getWidth() - diameter) {
            xSpeed = -xSpeed;
            changeColor();
        }
        if (y < 0 || y > getHeight() - diameter) {
            ySpeed = -ySpeed;
            changeColor();
        }

        repaint();
    }

    private void changeColor() {
        Random rand = new Random();
        ballColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball Game");
        Ap gamePanel = new Ap();
        frame.add(gamePanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}