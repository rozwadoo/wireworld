package Graphic.ElementsButtons;

import Graphic.SingleCell;
import java.awt.*;

public class ElemenstAndNotGate {

    public ElemenstAndNotGate(SingleCell[][] cell, int i, int j){
        for(int y = j; y < j+7; y++){
            cell[i][y].setElement();
        }

        cell[i+1][j+7].setElement();

        for(int y = j + 6; y < j+9; y++){
            cell[i + 2][y].setElement();
        }

        cell[i+3][j+7].setElement();

        for(int y = j + 8; y < j+14; y++){
            cell[i + 4][y].setElement();
        }

        cell[i + 4][j + 6].setElement();
        cell[i + 5][j + 5].setElement();

        for(int y = j; y < j+5; y++){
            cell[i + 6][y].setElement();
        }
    }
}
