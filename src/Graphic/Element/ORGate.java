package Graphic.Element;

import Graphic.Elements;
import Graphic.SingleCell;

public class ORGate extends Elements {

    private final int [][] orgate = {
            { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
    };

    private final int width = 14;
    private final int height = 5;

    public ORGate(SingleCell[][] board, int i, int j) {
        super(board, i, j);
        setSets();
    }

    public void setSets(){
        setWidth(width);
        setHeight(height);
        setStructure(orgate);
    }
}
