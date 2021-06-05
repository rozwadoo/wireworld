package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementReverseORGate {
    public ElementReverseORGate(SingleCell[][] cell, int i, int j){
        for(int y = j + 7; y < j + 14; y++){
            cell[i][y].setElement();
            cell[i+4][y].setElement();
        }

        cell[i+1][j+6].setElement();

        for(int y = j; y < j + 8; y++){
            cell[i+2][y].setElement();
        }

        cell[i+3][j+6].setElement();
    }
}
