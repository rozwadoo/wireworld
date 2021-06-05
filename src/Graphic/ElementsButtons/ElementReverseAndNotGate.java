package Graphic.ElementsButtons;

import Graphic.SingleCell;

import java.awt.*;

public class ElementReverseAndNotGate {
    public ElementReverseAndNotGate(SingleCell[][] panel, int i, int j){

        Color c = Color.YELLOW;
        for(int y = j+7; y < j+14; y++){
            panel[i][y].setElement();
        }

        panel[i+1][j+6].setElement();

        for(int y = j + 5; y < j+8; y++){
            panel[i + 2][y].setElement();
        }

        panel[i+3][j+6].setElement();

        for(int y = j; y < j+6; y++){
            panel[i + 4][y].setElement();
        }

        panel[i + 4][j + 7].setElement();
        panel[i + 5][j + 8].setElement();

        for(int y = j + 9; y < j+14; y++){
            panel[i + 6][y].setElement();
        }
    }
}
