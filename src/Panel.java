import javax.swing.*;
import java.awt.*;

/**
 * Program: Snake
 * Author: Trevor Vanderee
 *  This class houses all
 *  the graphics operations
 *  including drawing to the
 *  JPanel
 */
public class Panel extends JPanel {
    //Size of each Square
    private static final int BOX_SIZE = 20;
    //Reference to field board
    private Field field;

    public Panel(Field field) {
        //Link Field
        this.field = field;
    }

    /**
     * This method is used to paint
     * and repaint the screen as needed
     * @param g: Graphics
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //For every Square on the board
        for(int i =0; i <40; i++ ){
            for(int j =0; j<40; j++) {

                //if the cell is nothing
                if(field.getCellValue(i,j)==0){
                    g.setColor(Color.WHITE);
                }
                //If the cell is Snake
                else if(field.getCellValue(i,j)==1){
                    g.setColor(Color.BLUE);
                }
                //If the cell is food
                else if(field.getCellValue(i,j)==2){
                    g.setColor(Color.RED);
                }
                //Fill the rectangle up
                g.fillRect(j*BOX_SIZE + 1, i*BOX_SIZE+1, BOX_SIZE - 1, BOX_SIZE - 1);
            }
        }

    }

    /**
     * Get the preferred size for the gameboard
     * @return Dimension
     */
    public Dimension getPrefferredSize(){
        return new Dimension(800,800);
    }
}
