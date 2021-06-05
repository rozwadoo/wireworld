package Graphic.ElementsButtons;

import Graphic.SingleCell;

import java.awt.*;

public class ElementReverseDiode {
    public ElementReverseDiode(SingleCell[][] cell, int i, int j){
        cell[i][j+6].setElement();
        cell[i][j+7].setElement();
        for(int y = j; y < j+14;y++){
            if(y != j+6)cell[i+1][y].setElement();
        }
        cell[i+2][j+6].setElement();
        cell[i+2][j+7].setElement();
    }
}
