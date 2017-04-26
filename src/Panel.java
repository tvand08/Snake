import sun.awt.image.ImageWatched;

import javax.swing.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class Panel extends JPanel {
    private static final int BOX_SIZE = 20;
    private boolean[][] field;
    private Queue<boolean[][]> queue;
    public Panel(boolean[][] field ){
        this.field = field;

    }
       public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i =0; i <39; i++ ){
            for(int j =0; j<39; j++) {

                g.setColor(Color.BLACK);
                g.drawRect( j*BOX_SIZE, i*BOX_SIZE, BOX_SIZE, BOX_SIZE);
                if(field[i][j]){
                    g.setColor(Color.RED);
                }else {
                    g.setColor(Color.white);
                }
                g.fillRect(j*BOX_SIZE + 1, i*BOX_SIZE+1, BOX_SIZE - 1, BOX_SIZE - 1);
            }
        }

    }
    public Dimension getPrefferredSize(){
        return new Dimension(800,800);
    }
}
