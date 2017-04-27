import sun.awt.image.ImageWatched;

import javax.swing.*;

import java.awt.*;


/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class Panel extends JPanel {
    private static final int BOX_SIZE = 20;
    private Field field;
    public Panel(Field field) {
        this.field = field;
    }

       public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i =0; i <40; i++ ){
            for(int j =0; j<40; j++) {

                g.setColor(Color.BLACK);
                g.drawRect( j*BOX_SIZE, i*BOX_SIZE, BOX_SIZE, BOX_SIZE);
                if(field.getCellValue(i,j)==1){
                    g.setColor(Color.BLUE);
                }else if(field.getCellValue(i,j)==2){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j*BOX_SIZE + 1, i*BOX_SIZE+1, BOX_SIZE - 1, BOX_SIZE - 1);
            }
        }

    }
    public Dimension getPrefferredSize(){
        return new Dimension(800,800);
    }
}
