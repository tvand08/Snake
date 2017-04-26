import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class myThread extends Thread {

    private static final int NORTH =0;
    private static final int WEST =1;
    private static final int EAST = 2;
    private static final int SOUTH =3;
    private int posX;
    private int posY;
    private int Direction;
    private Field field;
    private Queue<Position> queue;
    private int snakeSize;
    private Position temp;
    private JPanel c;

    public myThread(Field field , JPanel c){
        this.c = c;
        this.field = field;
        snakeSize = 3;
        queue = new LinkedList<>();
        posX =1;
        posY =1;
        setDirection(EAST);
    }
    public void run(){
        while(true) {
            switch (Direction) {
                case NORTH:
                    posX--;
                    break;
                case SOUTH:
                    posX++;
                    break;
                case EAST:
                    posY++;
                    break;
                case WEST:
                    posY--;
                    break;
            }
            if (posX < 0 || posY < 0 || posX > 39 || posY > 39) {
                System.out.println("You Lose");
                break;
            }
            if(field.getCellValue(posX,posY)==2){
                newFood();
                snakeSize += 4;
            }else if(field.getCellValue(posX,posY)==1){
                System.out.println("You Lose");
                break;
            }
            field.setCellValue(posX,posY,1);

            queue.add(new Position(posX, posY));

            if (snakeSize < queue.size()){
                temp = queue.remove();
                field.setCellValue(temp.getX(),temp.getY(),0);
            }

            c.repaint();
            c.revalidate();
            try{
                sleep((long)100);
            }catch (InterruptedException e){}
        }
    }

    public void setDirection(int dir){
        Direction = dir;
    }
    public int getDirection(){
        return Direction;
    }

    public void newFood(){
        int posX = (int)(Math.random()*39);
        int posY = (int)(Math.random()*39);
        if(field.getCellValue(posX,posY)==1){
            newFood();
            return;
        }
        field.setCellValue(posX,posY,2);
    }
}
