import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Program: Snake
 * Author: Trevor Vanderee
 *  This class is a keyListener
 *  that can modify the direction
 *  of the snake
 */
public class keyThread implements KeyListener {
    //Constants for keypad
    private static final int LEFT = 37;
    private static final int UP = 38;
    private static final int RIGHT = 39;
    private static final int DOWN =40;
    //References
    private JPanel c;
    private myThread moving;

    public keyThread(JPanel c, myThread smake) {
        //Add KeyListener to the game
        c.addKeyListener(this);
        //Link references
        this.moving = smake;
        this.c = c;
    }//Constructor

    /**
     * This program executes code
     * when one of the arrow keys
     * are pressed
     * @param e: the key pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {

        //Get the key pressed
        int move = e.getKeyCode();

        /*
        Make sure the game has
        registered the last move
        the user tried to make
         */
        if (moving.getUpdated()) {
            //Check which Direction it moved in
            switch (move) {
                case LEFT:
                    if (moving.getDirection() != 2) {
                        moving.setDirection(1);
                    }
                    break;
                case UP:
                    if (moving.getDirection() != 3) {
                        moving.setDirection(0);
                    }
                    break;
                case RIGHT:
                    if (moving.getDirection() != 1) {
                        moving.setDirection(2);
                    }
                    break;
                case DOWN:
                    if (moving.getDirection() != 0) {
                        moving.setDirection(3);
                    }
                    break;
            }
            //New move made.. allow for update
            moving.setUpdated(false);
        }

    }//keyPressed

    /**
     * Never Used !Ignore
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Never Used !Ignore
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}
