package Graphic.ElementsButtons;

import Graphic.SingleCell;

public class ElementReverseEORGate {
    public ElementReverseEORGate(SingleCell[][] cell, int i, int j) {
        for (int y = j + 7; y < j + 14; y++) {
            cell[i][y].setElement();
        }

        cell[i + 1][j + 7].setElement();

        for (int y = j + 5; y < j + 9; y++) {
            cell[i + 2][y].setElement();
        }

        for (int y = j; y < j + 6; y++) {
            cell[i + 3][y].setElement();
        }
        cell[i + 3][j + 8].setElement();

        for (int y = j + 5; y < j + 9; y++) {
            cell[i + 4][y].setElement();
        }

        cell[i + 5][j + 7].setElement();

        for (int y = j + 7; y < j + 14; y++) {
            cell[i + 6][y].setElement();
        }
    }
}
