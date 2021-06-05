package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementORGate {
    public ElementORGate(SingleCell[][] panel, int i, int j){
        for(int y = j; y < j + 7; y++){
            panel[i][y].setElement();
            panel[i+4][y].setElement();
        }

        panel[i+1][j+7].setElement();

        for(int y = j + 6; y < j + 14; y++){
            panel[i+2][y].setElement();
        }

        panel[i+3][j+7].setElement();
    }
}
