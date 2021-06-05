package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementReverseORGate {
    public ElementReverseORGate(SingleCell[][] panel, int i, int j){
        for(int y = j + 7; y < j + 14; y++){
            panel[i][y].setElement();
            panel[i+4][y].setElement();
        }

        panel[i+1][j+6].setElement();

        for(int y = j; y < j + 8; y++){
            panel[i+2][y].setElement();
        }

        panel[i+3][j+6].setElement();
    }
}
