import javax.swing.*;
import java.awt.*;

/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class Panel extends JPanel {
    public Panel( ){

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(230,80,20,20);
        g.setColor(Color.RED);
        g.fillRect(230,80,10,10);
    }
    public Dimension getPrefferredSize(){
        return new Dimension(400,400);
    }
}
