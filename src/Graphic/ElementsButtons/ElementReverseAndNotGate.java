package Graphic.ElementsButtons;

import Graphic.SingleCell;

import java.awt.*;

public class ElementReverseAndNotGate {
    public ElementReverseAndNotGate(SingleCell[][] cell, int i, int j){

        Color c = Color.YELLOW;
        for(int y = j+7; y < j+14; y++){
            cell[i][y].setElement();
        }

        cell[i+1][j+6].setElement();

        for(int y = j + 5; y < j+8; y++){
            cell[i + 2][y].setElement();
        }

        cell[i+3][j+6].setElement();

        for(int y = j; y < j+6; y++){
            cell[i + 4][y].setElement();
        }

        cell[i + 4][j + 7].setElement();
        cell[i + 5][j + 8].setElement();

        for(int y = j + 9; y < j+14; y++){
            cell[i + 6][y].setElement();
        }
    }
}
