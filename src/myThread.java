import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Program: Snake
 * Author: Trevor Vanderee
 *  This class holds the main
 *  Game Thread. Most updates
 *  are called through this thread
 */
public class myThread extends Thread {

    //Possible snake directions
    private static final int NORTH = 0;
    private static final int WEST = 1;
    private static final int EAST = 2;
    private static final int SOUTH = 3;

    //Current Direction of the snake
    private int Direction;

    //Current position of snake head
    private int posX;
    private int posY;

    //Total size of snake
    private int snakeSize;

    //Check if panel repainted
    private boolean updated;

    //Queue holds positions of all snake parts
    private Queue<Position> queue;

    //References
    private Field field;
    private JPanel c;
    //Position holder
    private Position temp;

    public myThread(Field field , JPanel c){
        //Link References
        this.c = c;
        this.field = field;
        //Set base vars
        updated = false;
        snakeSize = 3;
        posX =1;
        posY =1;
        setDirection(EAST);
        //Create queue
        queue = new LinkedList<>();
    }
    public void run(){
        //Game Thread
        while(true) {
            //Move one square in designated _Direction
            switch (Direction) {
                case NORTH:
                    posY--;
                    break;
                case SOUTH:
                    posY++;
                    break;
                case EAST:
                    posX++;
                    break;
                case WEST:
                    posX--;
                    break;
            }
            //Check if out of bounds
            if (posX < 0 || posY < 0 || posX > 39 || posY > 39) {
                System.out.println("You Lose");
                break;
            }
            //Check if snake ate food
            if(field.getCellValue(posY,posX)==2){
                newFood();
                snakeSize += 4;
            }
            //else check if snake ate itself
            else if(field.getCellValue(posY,posX)==1){
                System.out.println("You Lose");
                break;
            }
            //set the value of the current cell to be snake
            field.setCellValue(posY,posX,1);
            //add to queue
            queue.add(new Position(posY, posX));

            //Check if we can remove from the tail
            if (snakeSize < queue.size()){
                temp = queue.remove();
                field.setCellValue(temp.getX(),temp.getY(),0);
            }
            //Update
            c.repaint();
            c.revalidate();
            updated = true;
            try{
                sleep((long)100);
            }catch (InterruptedException e){}
        }
    }

    /**
     * Set the direction of the snake
     * @param dir: The direction
     */
    public void setDirection(int dir){
        Direction = dir;
    }

    /**
     * Get the current direction of
     * the snake
     * @return int Direction
     */
    public int getDirection(){
        return Direction;
    }

    /**
     * Create a new food in a random
     * spot. If that spot is already
     * snake, try again.
     */
    public void newFood(){
        int posX = (int)(Math.random()*39);
        int posY = (int)(Math.random()*39);
        if(field.getCellValue(posX,posY)==1){
            newFood();
            return;
        }
        field.setCellValue(posX,posY,2);
    }

    /**
     * Return whether or not the
     * screen has been updated
     * @return boolean updated
     */
    public boolean getUpdated(){
        return updated;
    }

    /**
     * Set the updated value
     * @param it: boolean
     */
    public void setUpdated(boolean it){
        updated = it;
    }
}
