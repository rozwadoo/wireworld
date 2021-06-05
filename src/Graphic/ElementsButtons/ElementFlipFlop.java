package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementFlipFlop {
    public ElementFlipFlop(SingleCell [][] panel, int i, int j){
        for(int y = j; y < j + 6; y++){
            panel[i][y].setElement();
        }

        panel[i+1][j+6].setElement();

        for(int y = j + 5; y < j + 8; y++){
            panel[i+2][y].setElement();
        }

        panel[i+3][j+6].setElement();

        panel[i+4][j+5].setElement();
        for(int y = j + 7; y < j + 14; y++){
            panel[i+4][y].setElement();
        }

        panel[i+5][j+5].setElement();
        panel[i+5][j+7].setElement();

        for(int y = j + 4; y < j + 7; y++){
            panel[i+6][y].setElement();
        }

        panel[i+7][j+5].setElement();

        for(int y = j; y < j + 5; y++)
            panel[i+8][y].setElement();
    }
}
