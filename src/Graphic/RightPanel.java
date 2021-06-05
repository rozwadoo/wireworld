package Graphic;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    protected BoardSetting boardSetting = new BoardSetting();
    protected Board tarcza = new Board(boardSetting);
    protected JPanel ustawienia = new JPanel();

    RightPanel(){

        add(tarcza);
        add(ustawienia);

        setPreferredSize(new Dimension(900,700));

        ustawienia.add(boardSetting);
        ustawienia.setPreferredSize(new Dimension(140,700));
    }

    public int getIntegerOfBoard(int a, int b){
        if(tarcza.panel[a][b].getBackground() == Color.BLUE)return 1;
        else
        if(tarcza.panel[a][b].getBackground() == Color.ORANGE)return 2;
        else
        if(tarcza.panel[a][b].getBackground() == Color.YELLOW)return 3;
        else
        if(tarcza.panel[a][b].getBackground() == Color.BLACK)return 0;
        else
        return -1;
    }


    public int[][] getBoard(){

        int number = tarcza.getRowsColws();

        int n[][] = new int[51][51];
        for(int i=1; i <= number; i++){
            for(int j=1; j <= number; j++){
                n[i][j] = getIntegerOfBoard(i,j);
            }
        }
        return n;
    }
}
