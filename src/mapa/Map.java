package mapa;

import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class Map {
    private int row;
    private int column;
    private static TreeMap<Integer, Cell> board = new TreeMap<>();
    private final int[][] mToInt = new int[51][51];
    private HashMap<Integer, Structure> LoE = new HashMap<>();


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

    public void setDim( String path) throws IOException, FileNotFoundException {
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
                    case "Conductor":
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
                Structure n;
                String t = p.length > 3 ? p[3].trim() : "";
                int h = 0;
                if(getBoard().get(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn())).getState0() == 3) h = 1;
                switch (p[0].trim()){
                    case "Diode":
                        n = new Diode(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        break;
                    case "ORGate":
                        n = new ORGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        break;
                    case "FlipFlop":
                        n = new FlipFlop(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        break;
                    case "EORGate":
                        n = new EORGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        break;
                    case "AndNotGate":
                        n = new AndNotGate(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        break;
                    case "ElectronHead":
                        n = new Conductor(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        getBoard().get(n.getStart()).setState0(1);
                        getBoard().get(n.getStart()).giveN(this);
                        if(h == 1) getLoE().remove(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), n);
                        break;
                    case "ElectronTail":
                        n = new Conductor(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        getBoard().get(n.getStart()).setState0(2);
                        getBoard().get(n.getStart()).giveN(this);
                        if(h == 1) getLoE().remove(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), n);
                        break;
                    case "Conductor":
                        n = new Conductor(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), this, t);
                        getBoard().get(n.getStart()).giveN(this);
                        if(h == 1) getLoE().remove(Integer.parseInt(p[1].trim()) + 1 + (Integer.parseInt(p[2].trim()) * this.getColumn()), n);
                        break;
                }
            } catch( ArrayIndexOutOfBoundsException|NumberFormatException e) {
                System.err.println( "Linia: \"" + line +e.getMessage());
            }
        }
    }
    public void save(String name, HashMap<Integer, Structure> LoE) throws IOException {
        java.io.File file = new java.io.File(name);
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(HashMap.Entry<Integer, Structure> entry : getLoE().entrySet()) {
            Structure n =  entry.getValue();
            Integer s = entry.getKey();
            int ro;
            int c;
            if (s % getColumn() != 0) {
                c = (s % getColumn()) - 1;
                ro = (s - (s % getColumn())) / getColumn();
            } else {
                c = getColumn() - 1;
                ro = s / getColumn() - 1;
            }
            bw.write(n.getName() + ": " + c + ", " + ro + ", " + n.getLname() + "\n");
        }
        for(HashMap.Entry<Integer, Structure> entry : LoE.entrySet()) {
            Structure n =  entry.getValue();
            int ro = n.getI() - 1;
            int c = n.getJ() - 1;
            bw.write(n.getName() + ": " + c + ", " + ro + ", " + n.getLname() + "\n");
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
        bw.flush();
        bw.close();
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
            if(i%column == 0){
                mToInt[i/column][column] = board.get(i).getState0();
            }
            else
            {
                mToInt[i/column + 1][i %column] = board.get(i).getState0();
            }
        }
        return mToInt;
    }

    public HashMap<Integer, Structure> getLoE() {
        return LoE;
    }

    public void setLoE(HashMap<Integer, Structure> loE) {
        LoE = loE;
    }
}
