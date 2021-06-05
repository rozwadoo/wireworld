package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementEORGate {
    public ElementEORGate(SingleCell[][] cell, int i, int j){
        for(int y = j; y < j + 6; y++){
            cell[i][y].setElement();
        }

        cell[i+1][j+6].setElement();

        for(int y = j + 5; y < j + 9; y++){
            cell[i+2][y].setElement();
        }

        for(int y = j + 8; y < j + 14; y++){
            cell[i+3][y].setElement();
        }
        cell[i+3][j+5].setElement();

        for(int y = j + 5; y < j + 9; y++){
            cell[i+4][y].setElement();
        }

        cell[i+5][j+6].setElement();

        for(int y = j; y < j + 6; y++){
            cell[i+6][y].setElement();
        }
    }
}
