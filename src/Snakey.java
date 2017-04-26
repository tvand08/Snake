import javax.swing.*;
import java.awt.*;

/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class Snakey {
    private JPanel c;
    private Graphics g;
    private keyThread k;
    private JFrame frame;
    private JTextField  tf;
    public Snakey( ){
        frame = new JFrame();
        c = new Panel();
        frame.setSize(400,400);
        c.setSize(c.getPreferredSize());
        frame.add(c);

        c.setFocusable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        k = new keyThread(c);
        k.start();
    }

    private void repaint() {
        g.setColor(Color.BLACK);
        c.paintComponents(g);
        g.drawString("Helllo", 200, 200);
    }
    public static void main(String[] args){ new Snakey();}
}
