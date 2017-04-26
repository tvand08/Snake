import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by Trevor Vanderee on 2017-04-25.
 */
public class keyThread extends Thread implements KeyListener {

    public keyThread(JPanel c){
        c.addKeyListener(this);
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
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
