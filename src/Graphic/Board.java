package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Board extends JPanel{

    private BoardSetting settings;
    protected SingleCell [][] panel = new SingleCell[50][50];
    private int rowsColws = 30;
    private RightPanel previous;


    Board(BoardSetting board){

        settings = board;

        int a = 30;

        setPreferredSize(new Dimension(700,700));
        setLayout(new GridLayout(rowsColws,rowsColws,1,1));
        for( i = 0; i < rowsColws; i++){
            for( j = 0; j < rowsColws; j++){
                panel[i][j] = new SingleCell(settings);
                panel[i][j].setBackground(Color.BLACK);
                this.add(panel[i][j]);
            }
        }
    }

    public void update(int x, int a, int b){
        if(x == 1)panel[a][b].setBackground(Color.BLUE);
        else
        if(x == 2)panel[a][b].setBackground(Color.orange);
        else
        if(x == 3)panel[a][b].setBackground(Color.yellow);
        else
        if(x == 0)panel[a][b].setBackground(Color.BLACK);
    }

    public int getRowsColws()
    {
        return rowsColws;
    }
}
