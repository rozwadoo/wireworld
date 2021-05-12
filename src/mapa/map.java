package mapa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.TreeMap;

public class map {
    private int row;
    private int column;
    private static TreeMap<Integer, cell> board = new TreeMap<>();

    public map(){

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

    public static TreeMap<Integer, cell> getBoard() {
        return board;
    }

    public void setBoard(TreeMap<Integer, cell> board) {
        this.board = board;
    }
    public void iterate(){
        board.forEach((k,v) -> v.generate());
        board.forEach((k,v) -> v.update());
        }

    public void read( String path)
            throws IOException, FileNotFoundException {
        BufferedReader r = new BufferedReader( new FileReader(path));
        String line;
        int row = 1;
        int col = 1;
        while( (line= r.readLine()) != null ) {
            String [] p = line.split(":|\\,\\s*");
            try {
                if(p[0].trim().equals("Diode") ) col = Math.max(col, Integer.parseInt(p[1].trim())+14);
                if(p[0].trim().equals("Diode") ) row = Math.max(row, Integer.parseInt(p[2].trim())+4);
            } catch( ArrayIndexOutOfBoundsException|NumberFormatException e) {
                System.err.println( "Linia: \"" + line + "\" jest błędna ("+e.getMessage()+") i została pominięta");
            }
        }
        this.setRow(row);
        this.setColumn(col);
        for(int i = 1; i < this.getColumn()*this.getRow()+1; ++i){
            getBoard().put(i, new cell( 0, i));
        }
        BufferedReader re = new BufferedReader( new FileReader(path));
        while( (line= re.readLine()) != null ) {
            String [] p = line.split(":|\\,\\s*");
            try {
                map n;
                if(p[0].trim().equals("Diode")) {
                    n = new diodeNormal(Integer.parseInt(p[1].trim())+1+ (Integer.parseInt(p[2].trim())*14));
                    for(int cl : n.board.keySet()) {
                        if (n.board.get(cl).getState0() == 3) getBoard().get(cl).setState0(3);
                    }
                }
                else if(p[0].trim().equals("ElectronHead")) {
                    getBoard().get(Integer.parseInt(p[1].trim())+1+ Integer.parseInt(p[2].trim())*14).setState0(1);
                }
                else if(p[0].trim().equals("ElectronTail")) {
                    getBoard().get(Integer.parseInt(p[1].trim())+1+ Integer.parseInt(p[2].trim())*14).setState0(2);
                }
            } catch( ArrayIndexOutOfBoundsException|NumberFormatException e) {
                System.err.println( "Linia: \"" + line + "\" jest błędna ("+e.getMessage()+") i została pominięta");
            }
        }

    }
    public static void save( String d){
        try {
            File myObj = new File(d);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
   /* public static void edit(String d, String s){
        try {
            FileWriter myWriter = new FileWriter(d);
            myWriter.write(s);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/

}
