package Graphic.Element;

import Graphic.Elements;
import Graphic.SingleCell;

public class AndNotGate extends Elements {

    private int[][] andnotgate = {
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private int width = 14;
    private int height = 7;


    public AndNotGate(SingleCell[][] board, int i, int j) {
        super(board, i, j);
        setSets();
    }

    public void setSets(){
        setWidth(width);
        setHeight(height);
        setStructur(andnotgate);
    }

}
