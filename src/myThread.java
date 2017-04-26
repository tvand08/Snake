import javax.swing.*;

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
    private boolean[][] field;
    private JPanel c;

    public myThread(boolean[][] field , JPanel c){
        this.c = c;
        this.field = field;
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
            if(posX<0 || posY<0||posX>39 ||posY>39){
                System.out.println("You Lose");
                break;
            }
            field[posX][posY] = true;
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
}
