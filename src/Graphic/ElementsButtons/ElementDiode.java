package Graphic.ElementsButtons;

import Graphic.SingleCell;

import java.awt.*;

public class ElementDiode {
    public ElementDiode(SingleCell[][] panel, int i, int j){
        Color c = Color.YELLOW;
        panel[i][j+6].setElement();
        panel[i][j+7].setElement();
        for(int y = j; y < j+14;y++){
            if(y != j+7)panel[i+1][y].setElement();
        }
        panel[i+2][j+6].setElement();
        panel[i+2][j+7].setElement();
    }
}
