/**
 * Created by Trevor Vanderee on 2017-04-26.
 */
public class Field {
    private int[][] field;
    public Field(int sizeX, int sizeY){
        field = new int[sizeX][sizeY];
        for (int[] i:field) {
            for(int j: i){
                j=0;
            }
        }
    }

    public int getCellValue(int posX, int posY){
        return field[posX][posY];
    }

    public void setCellValue(int posX, int posY, int state){
        field[posX][posY]= state;
    }
}
