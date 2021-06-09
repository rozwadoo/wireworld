package Graphic;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

public class RightPanel extends JPanel {

    private BoardSetting boardSetting = new BoardSetting();
    protected Board board = new Board(boardSetting);

    RightPanel(){
        add(board);
        add(boardSetting);

        setPreferredSize(new Dimension(900,700));
        boardSetting.setPreferredSize(new Dimension(140,700));
    }

    public int getIntegerOfBoard(int a, int b){
        if(board.cell[a][b].getBackground() == Color.BLUE)return 1;
        else
        if(board.cell[a][b].getBackground() == Color.RED)return 2;
        else
        if(board.cell[a][b].getBackground() == Color.YELLOW)return 3;
        else
        if(board.cell[a][b].getBackground() == Color.BLACK)return 0;
        else
        return -1;
    }


    public int[][] getBoard(){

        int number = board.getRowsColws();

        int [][] n = new int[51][51];
        for(int i=1; i <= number; i++){
            for(int j=1; j <= number; j++){
                n[i][j] = getIntegerOfBoard(i,j);
            }
        }
        return n;
    }
}
