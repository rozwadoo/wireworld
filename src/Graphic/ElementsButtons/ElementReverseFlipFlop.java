package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementReverseFlipFlop {
    public ElementReverseFlipFlop(SingleCell[][] cell, int i, int j){

        for(int y = j + 8; y < j + 14; y++){
            cell[i][y].setElement();
        }

        cell[i+1][j+7].setElement();

        for(int y = j + 6; y < j + 9; y++){
            cell[i+2][y].setElement();
        }

        cell[i+3][j+7].setElement();

        cell[i+4][j+8].setElement();
        for(int y = j; y < j + 7; y++){
            cell[i+4][y].setElement();
        }

        cell[i+5][j+6].setElement();
        cell[i+5][j+8].setElement();

        for(int y = j + 7; y < j + 10; y++){
            cell[i+6][y].setElement();
        }

        cell[i+7][j+8].setElement();

        for(int y = j + 9; y < j + 14; y++)
            cell[i+8][y].setElement();
    }
}
