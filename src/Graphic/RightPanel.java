package Graphic;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    JPanel [][] panel = new JPanel[50][50];
    final int rowsColws = 30;

    RightPanel(){
        setPreferredSize(new Dimension(700,700));

        setLayout(new GridLayout(rowsColws,rowsColws,0,0));

        for(int i = 0; i < rowsColws; i++){
            for(int j = 0; j < rowsColws; j++){
                panel[i][j] = new JPanel();
                panel[i][j].setSize(new Dimension(10,10));
                panel[i][j].setBackground(Color.BLACK);
                add(panel[i][j]);
            }
        }
    }

    public void update(int x, int i, int j){
        if(x == 0)panel[i][j].setBackground(Color.BLUE);
        else
        if(x == 1)panel[i][j].setBackground(new Color(255,102,0));
        else
        if(x == 2)panel[i][j].setBackground(Color.yellow);
        else
        if(x == 3)panel[i][j].setBackground(Color.BLACK);
    }

    public int getRowsColws()
    {
        return rowsColws;
    }
}
