package Graphic.Element;

import Graphic.Elements;
import Graphic.SingleCell;

public class Diode extends Elements {

    private int [][] diode = {
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}
    };

    private int width = 14;
    private int height = 3;

    public Diode(SingleCell[][] board, int i, int j){
        super(board, i, j);
        setSets();
    }

    public void setSets(){
        setWidth(width);
        setHeight(height);
        setStructur(diode);
    }


}
