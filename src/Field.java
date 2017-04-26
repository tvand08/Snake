/**
 * Created by Trevor Vanderee on 2017-04-26.
 */
public class Field {
    private boolean[][] field;
    public Field(int sizeX, int sizeY){
        field = new boolean[sizeX][sizeY];
        for (boolean[] i:field) {
            for(boolean j: i){
                j=false;
            }
        }
    }

    public boolean getCellValue(int posX, int posY){
        return field[posX][posY];
    }

    public void setCellValue(int posX, int posY, boolean flag){
        field[posX][posY]= flag;
    }
}
