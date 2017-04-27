import javax.swing.*;
import java.awt.*;

/**
 * Program: Snake
 * Author: Trevor Vanderee
 * Date: 2017-04-25
 * Description: Implementation of the classic
 *  arcade game snake. Goal of the game is to
 *  eat as much food as you can without hitting
 *  any walls or yourself
 */
public class Snakey {

    //Objects in use
    private JPanel c;
    private Graphics g;
    private keyThread k;
    private JFrame frame;
    private JTextField  tf;
    private Field field;
    private Thread moving;

    public Snakey( ){
        //Create Playing Field Array
        field = new Field(40,40);

        //Panel operations to house board
        c = new Panel(field);
        c.setSize(c.getPreferredSize());
        c.setFocusable(true);

        //Create Frame
        frame = new JFrame();
        frame.setSize(820,850);
        frame.add(c);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Create Main Game Thread
        moving=new myThread(field,c);

        //Keystroke Listener
        k = new keyThread(c, (myThread) moving);

        //Create Food Item(RED)
        ((myThread) moving).newFood();
        //Start Game
        moving.start();
    }//Constructor

    public static void main(String[] args){ new Snakey();}
}
