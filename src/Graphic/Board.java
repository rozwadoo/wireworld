package Graphic;

import mapa.Structure;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Board extends JPanel{

    protected SingleCell [][] cell = new SingleCell[51][51];
    private final int rowsColws = 40;
    private File temporary;
    private FileWriter fw;
    private final HashMap<Integer, Structure> LoE = new HashMap<>();

    Board(BoardSetting setting){

        createFile();

        setPreferredSize(new Dimension(700,700));
        setLayout(new GridLayout(rowsColws,rowsColws,1,1));
        for(int i = 1; i <= rowsColws; i++){
            for(int j = 1; j <= rowsColws; j++){
                cell[i][j] = new SingleCell(cell, setting, i, j, this);
                cell[i][j].setBackground(Color.BLACK);
                this.add(cell[i][j]);
            }
        }
    }

    public File getFile() {
        return temporary;
    }

    public void update(int x, int a, int b){
        if(x == 1)cell[a][b].setBackground(Color.BLUE);
        else
        if(x == 2)cell[a][b].setBackground(Color.RED);
        else
        if(x == 3)cell[a][b].setBackground(Color.yellow);
        else
        if(x == 0)cell[a][b].setBackground(Color.BLACK);

        if(x != 0)cell[a][b].setEditable(false);
    }

    public int getRowsColws()
    {
        return rowsColws;
    }

    public void addTextLine(String s, int y, int x){
        x = x - 1;
        y = y - 1;
        String a = s + ": " + x + ", "
                + y;
        addLineToFile(a);
    }

    public void addTextLine(String s, int y, int x, String g){
        x = x - 1;
        y = y - 1;
        String a = s + ": " + x + ", "
                + y + ", " + g;
        addLineToFile(a);
    }

    private void addLineToFile(String a){
        try {
            fw = new FileWriter(temporary, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(a);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(){
        try {
            temporary = File.createTempFile("Temp-",".txt");
            temporary.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Structure> getLoE() {
        return LoE;
    }

}
