package Graphic.ElementsButtons;

import Graphic.SingleCell;

import java.awt.*;

public class ElementDiode {
    public ElementDiode(SingleCell[][] cell, int i, int j){
        Color c = Color.YELLOW;
        cell[i][j+6].setElement();
        cell[i][j+7].setElement();
        for(int y = j; y < j+14;y++){
            if(y != j+7)cell[i+1][y].setElement();
        }
        cell[i+2][j+6].setElement();
        cell[i+2][j+7].setElement();
    }
}
