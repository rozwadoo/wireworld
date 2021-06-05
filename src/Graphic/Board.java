package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Board extends JPanel implements ActionListener{

    private BoardSetting boardSetting;
    protected SingleCell [][] panel = new SingleCell[50][50];
    private int rowsColws = 30;
    private RightPanel previous;

    Board(BoardSetting setting){

        boardSetting = setting;
        boardSetting.clear.addActionListener(this);
        int a = 30;

        setPreferredSize(new Dimension(700,700));
        setLayout(new GridLayout(rowsColws,rowsColws,1,1));
        for(int i = 1; i <= rowsColws; i++){
            for(int j = 1; j <= rowsColws; j++){
                panel[i][j] = new SingleCell(panel, boardSetting, i, j);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == boardSetting.clear){
            for(int i = 1; i <= rowsColws; i++){
                for(int j = 1; j <= rowsColws; j++){
                    panel[i][j].setBackground(Color.BLACK);
                    panel[i][j].setEditable(true);
                }
            }
        }
    }
}
