/**
 * Program: Snake
 * Author: Trevor Vanderee
 *  This Class is a wrapper
 *  for two integers to be
 *  passed into a queue
 *  together
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        //Wrap X and Y
        this.x=x;
        this.y=y;

    }

    /**
     * get value of x
     * @return int x
     */
    public int getX(){
        return x;
    }

    /**
     * get value of y
     * @return int y
     */
    public int getY(){
        return y;
    }
}
