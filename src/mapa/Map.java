package mapa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.TreeMap;

public class Map {
    private int row;
    private int column;
    private static TreeMap<Integer, Cell> board = new TreeMap<>();
    private int[][] mToInt = new int[50][ 50];


    public Map(){
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public static TreeMap<Integer, Cell> getBoard() {
        return board;
    }

    public void setBoard(TreeMap<Integer, Cell> board) {
        this.board = board;
    }
    public void iterate(){
        board.forEach((k,v) -> v.generate());
        board.forEach((k,v) -> v.update());
        }

    public void setDim( String path)
            throws IOException, FileNotFoundException {
        BufferedReader r = new BufferedReader(new FileReader(path));
        String line;
        int row = 1;
        int col = 1;
        while ((line = r.readLine()) != null) {
            String[] p = line.split(":|\\,\\s*");
            try {
                switch (p[0].trim()) {
                    case "Diode":
                    case "ORGate":
                        col = Math.max(col, Integer.parseInt(p[1].trim()) + 14);
                        row = Math.max(row, Integer.parseInt(p[2].trim()) + 4);
                        break;
                    case "FlipFlop":
                        col = Math.max(col, Integer.parseInt(p[1].trim()) + 14);
                        row = Math.max(row, Integer.parseInt(p[2].trim()) + 6);
                        break;
                    case "EORGate":
                    case "AndNotGate":
                        col = Math.max(col, Integer.parseInt(p[1].trim()) + 14);
                        row = Math.max(row, Integer.parseInt(p[2].trim()) + 5);
                        break;
                    case "ElectronHead":
                    case "ElectronTail":
                        col = Math.max(col, Integer.parseInt(p[1].trim()) + 1);
                        row = Math.max(row, Integer.parseInt(p[2].trim()) + 1);
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.err.println("Linia: \"" + line + e.getMessage());
            }
        }
        this.setRow(row);
        this.setColumn(col);
    }
    public void read( String path)
            throws IOException, FileNotFoundException {
        for(int i = 1; i < this.getColumn()*this.getRow()+1; ++i){
            getBoard().put(i, new Cell( 0, i));
        }
        BufferedReader re = new BufferedReader( new FileReader(path));
        String line;
        while( (line= re.readLine()) != null ) {
            String [] p = line.split(":|\\,\\s*");
            try {
                Map n;
                switch (p[0].trim()){
                    case "Diode":
                        if(p[3].trim().equals("Normal")) {
                            n = new Diode(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Normal");
                        }
                        else if(p[3].trim().equals("Reversed")){
                            n = new Diode(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()),  this,"Reversed");
                        }
                        else break;
                        for(int cl : n.board.keySet()) {
                            if (n.board.get(cl).getState0() == 3) getBoard().get(cl).setState0(3);
                        }
                        break;
                    case "ORGate":
                        if(p[3].trim().equals("Normal")) {
                            n = new ORGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Normal");
                        }
                        else if(p[3].trim().equals("Reversed")) {
                            n = new ORGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Reversed");
                        }
                        else break;
                        for(int cl : n.board.keySet()) {
                            if (n.board.get(cl).getState0() == 3) getBoard().get(cl).setState0(3);
                        }
                        break;
                    case "FlipFlop":
                        if(p[3].trim().equals("Normal")) {
                            n = new FlipFlop(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Normal");
                        }
                        else if(p[3].trim().equals("Reversed")) {
                            n = new FlipFlop(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Reversed");
                        }
                        else break;
                        for(int cl : n.board.keySet()) {
                            if (n.board.get(cl).getState0() == 3) getBoard().get(cl).setState0(3);
                        }
                        break;
                    case "EORGate":
                        if(p[3].trim().equals("Normal")) {
                            n = new EORGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Normal");
                        }
                        else if(p[3].trim().equals("Reversed")) {
                            n = new EORGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Reversed");
                        }
                        else break;
                        for(int cl : n.board.keySet()) {
                            if (n.board.get(cl).getState0() == 3) getBoard().get(cl).setState0(3);
                        }
                        break;
                    case "ElectronHead":
                        getBoard().get(Integer.parseInt(p[1].trim())+1+ Integer.parseInt(p[2].trim())*this.getColumn()).setState0(1);
                        getBoard().get(Integer.parseInt(p[1].trim())+1+ Integer.parseInt(p[2].trim())*this.getColumn()).giveN(this);
                        break;
                    case "ElectronTail":
                        getBoard().get(Integer.parseInt(p[1].trim())+1+ Integer.parseInt(p[2].trim())*this.getColumn()).setState0(2);
                        getBoard().get(Integer.parseInt(p[1].trim())+1+ Integer.parseInt(p[2].trim())*this.getColumn()).giveN(this);
                        break;
                    case "AndNotGate":
                        if(p[3].trim().equals("Normal")) {
                            n = new AndNotGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Normal");
                        }
                        else if(p[3].trim().equals("Reversed")) {
                            n = new AndNotGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, "Reversed");
                        }
                        else break;
                        for(int cl : n.board.keySet()) {
                            if (n.board.get(cl).getState0() == 3) getBoard().get(cl).setState0(3);
                        }
                        break;
                }
            } catch( ArrayIndexOutOfBoundsException|NumberFormatException e) {
                System.err.println( "Linia: \"" + line +e.getMessage());
            }
        }
    }
    public void save(java.io.File f, String name) throws IOException {
        BufferedReader r = new BufferedReader( new FileReader(f));
        java.io.File file = new java.io.File("tmp.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        try {
            while ((line = r.readLine()) != null) {
                String [] p = line.split(":|\\,\\s*");
                switch (p[0].trim()){
                    case "ElectronHead":
                        break;
                    case "ElectronTail":
                        break;
                    default:
                        bw.write(line + "\n");
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println( e.getMessage());
        }
        for(int i = 1; i < this.getColumn()*this.getRow()+1; ++i) {
            int ro;
            int c;
            if (i % getColumn() != 0) {
                c = (i % getColumn()) - 1;
                ro = (i - (i % getColumn())) / getColumn();
            } else {
                c = getColumn() - 1;
                ro = i / getColumn() - 1;
            }
            switch (getBoard().get(i).getState0()) {
                case 1:
                    bw.write("ElectronHead" + ": " + c + ", " + ro + "\n");
                    break;
                case 2:
                    bw.write("ElectronTail" + ": " + c + ", " + ro + "\n");
                    break;
            }
        }
        r.close();
        bw.flush();
        bw.close();
        //f.delete();
        Files.copy(Paths.get("tmp.txt"), Paths.get(name), StandardCopyOption.REPLACE_EXISTING);
        file.delete();
    }
   public int[][] translate(){
       int [][] a = new int[getRow()][getColumn()];
       for (int i = 0; i <getRow(); ++i) {
           for (int j = 0; j < getColumn(); ++j) {
               a[i][j] = getBoard().get(getColumn() * i + j + 1).getState0();
           }
       }
       return a;
   }

    public int[][] getmToInt(){
        for(int i = 1; i < column*row+1; ++i){
            if(i%row == 0){
                mToInt[i/row][row] = board.get(i).getState0();
            }
            else
            {
                mToInt[i/row + 1][i % row] = board.get(i).getState0();
            }
        }
        return mToInt;
    }


}
