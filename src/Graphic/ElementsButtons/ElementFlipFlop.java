package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementFlipFlop {
    public ElementFlipFlop(SingleCell [][] cell, int i, int j){
        for(int y = j; y < j + 6; y++){
            cell[i][y].setElement();
        }

        cell[i+1][j+6].setElement();

        for(int y = j + 5; y < j + 8; y++){
            cell[i+2][y].setElement();
        }

        cell[i+3][j+6].setElement();

        cell[i+4][j+5].setElement();
        for(int y = j + 7; y < j + 14; y++){
            cell[i+4][y].setElement();
        }

        cell[i+5][j+5].setElement();
        cell[i+5][j+7].setElement();

        for(int y = j + 4; y < j + 7; y++){
            cell[i+6][y].setElement();
        }

        cell[i+7][j+5].setElement();

        for(int y = j; y < j + 5; y++)
            cell[i+8][y].setElement();
    }
}
