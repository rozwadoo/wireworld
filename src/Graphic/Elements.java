package Graphic;

import java.awt.*;

public class Elements {

    private SingleCell[][] cell;
    private int i;
    private int j;

    private int width;
    private int height;
    private int[][] struc;

    public Elements(SingleCell[][] board, int i, int j){
        this.cell = board;
        this.i = i;
        this.j = j;
    }

    public void normal(){
        if(height + i  > 40)height = 40 - i;
        if(width + j  > 40)width = 40 - j;
        for (int x = 0; x < height && x < 40; x++) {
            for (int y = 0; y < width && y < 40; y++) {
                if (struc[x][y] == 1)
                    cell[i + x][j + y].setBackground(Color.YELLOW);
            }
        }
    }

    public void reverse(){
        if(height + i  > 40)height = 40 - i;
        if(width + j  > 40)width = 40 - j;
        for (int x = height - 1; x >= 0; x--) {
            for (int y = width - 1; y >= 0; y--) {
                if (struc[x][y] == 1)
                    cell[i + x][j + width - 1 - y].setBackground(Color.YELLOW);
            }
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStructur(int[][] structur) {
        this.struc = structur;
    }
}
