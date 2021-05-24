package mapa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Structure extends Map {
    private int start;
    private String name;
    private String lname;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    public void make(int n, Map m){
        getBoard().get(n).setState0(3);
        getBoard().get(n).giveN(m);
    }
    public void addToFile(java.io.File f, Map m, int s) throws IOException {
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
        switch(getLname()) {
            case "Empty":
                bw.write(name + ": " + c + ", " + ro + "\n");
                break;
            default:
                bw.write(getName() + ": " + c + ", " + ro + ", " + getLname() +"\n");
                break;
        }
        r.close();
        bw.flush();
        bw.close();
        f.delete();
        Files.copy(Paths.get("tmp.txt"), Paths.get("output.txt"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
