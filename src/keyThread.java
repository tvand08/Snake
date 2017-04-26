import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class keyThread extends Thread implements KeyListener {
    private boolean[][] field;
    private int xPos, yPos;
    private JPanel c;
    private myThread moving;
    public keyThread(JPanel c,boolean[][] field,myThread smake){
        c.addKeyListener(this);
        this.moving = smake;
        this.c =c;
        this.field = field;
        field[1][1]=true;
        xPos =1;
        yPos = 1;
    }
    public void run(){
        try {
            while (true) {
                sleep((long) (Math.random() * 100));
            }
        }catch (InterruptedException e){}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int move = e.getKeyCode();
        field[xPos][yPos]=false;
        System.out.println(move);
        switch (move){
            case 37:
                if(moving.getDirection()!=2) {
                    moving.setDirection(1);
                }
                break;
            case 38:
                if(moving.getDirection()!=3) {
                    moving.setDirection(0);
                }
                break;
            case 39:
                if(moving.getDirection()!=1) {
                    moving.setDirection(2);
                }
                break;
            case 40:
                if(moving.getDirection()!=0) {
                    moving.setDirection(3);
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
