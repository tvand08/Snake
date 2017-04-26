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
    private boolean[][] field;
    private Thread moving;
    public Snakey( ){
        field = new boolean[40][40];
        for (boolean[] i:field) {
            for(boolean j: i){
                j=false;
            }
        }
        frame = new JFrame();
        c = new Panel(field);
        moving=new myThread(field,c);
        frame.setSize(800,830);
        c.setSize(c.getPreferredSize());
        frame.add(c);
        c.setFocusable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        k = new keyThread(c,field, (myThread) moving);
        k.start();
        moving.start();
    }

    private void repaint() {
        g.setColor(Color.BLACK);
        c.paintComponents(g);
        g.drawString("Helllo", 200, 200);
    }
    public static void main(String[] args){ new Snakey();}
}
