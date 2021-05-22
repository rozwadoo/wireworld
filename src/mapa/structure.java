package mapa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class structure extends map{
    private int start;
    private String name;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    public void make(int n, map m){
        getBoard().get(n).setState0(3);
        getBoard().get(n).giveN(m);
    }
    public void addToFile(java.io.File f, map m, int s, String fname) throws IOException {
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
        int ro;
        int c;
        if(s % m.getColumn() != 0){
            c = (s % m.getColumn()) - 1;
            ro = (s - (s % m.getColumn()))/m.getColumn();
        }
        else {
            c = m.getColumn() - 1;
            ro = s / m.getColumn() - 1;
        }
        bw.write(this.getName() + ": " + c + ", " + ro + "\n");
        for(int i = 1; i < m.getColumn()*m.getRow()+1; ++i) {
            switch (m.getBoard().get(i).getState0()) {
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
        f.delete();
        Files.copy(Paths.get("tmp.txt"), Paths.get(fname));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
