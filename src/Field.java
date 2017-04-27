/**
 * Program: Snake
 * Author: Trevor Vanderee
 * This class is used to house
 * the game board for snake.
 * it has a 2d array space for each
 * spot on the game board.
 */
public class Field {
    private int[][] field;
    public Field(int sizeX, int sizeY){
        //initiate array with 0's
        field = new int[sizeX][sizeY];
        for (int[] i:field) {
            for(int j: i){
                j=0;
            }
        }
    }

    /**
     * Get the cell value at the
     * desired location
     * @param posX: int Position X
     * @param posY: int Position Y
     * @return int status at location
     */
    public int getCellValue(int posX, int posY){
        return field[posX][posY];
    }

    /**
     * Set the status at
     * the desired location
     * @param posX: int Position X
     * @param posY: int Position Y
     * @param state: Desired State
     */
    public void setCellValue(int posX, int posY, int state){
        field[posX][posY]= state;
    }
}
