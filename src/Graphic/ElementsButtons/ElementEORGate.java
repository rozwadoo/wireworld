package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementEORGate {
    public ElementEORGate(SingleCell[][] panel, int i, int j){
        for(int y = j; y < j + 6; y++){
            panel[i][y].setElement();
        }

        panel[i+1][j+6].setElement();

        for(int y = j + 5; y < j + 9; y++){
            panel[i+2][y].setElement();
        }

        for(int y = j + 8; y < j + 14; y++){
            panel[i+3][y].setElement();
        }
        panel[i+3][j+5].setElement();

        for(int y = j + 5; y < j + 9; y++){
            panel[i+4][y].setElement();
        }

        panel[i+5][j+6].setElement();

        for(int y = j; y < j + 6; y++){
            panel[i+6][y].setElement();
        }
    }
}
