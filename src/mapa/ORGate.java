package mapa;

import java.io.File;
import java.io.IOException;

public class ORGate extends Structure {
    public ORGate(int s, Map m, String lname){
        setRow(7);
        setColumn(14);
        setName("ORGate");
        setLname(lname);
        int auxc = m.getColumn() - 14;
        for (int i = s - m.getColumn() * 3; i < s + m.getColumn() * 4; ++i) {
            getBoard().put(i, new Cell(0, i));
        }
        switch(lname) {
            case "Normal":
                for (int i = s - m.getColumn() * 2; i < s - m.getColumn() * 2 + 7; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2; i < s + m.getColumn() * 2 + 7; ++i) {
                    make(i, m);
                }
                for (int i = s + 6; i < s + 14; ++i) {
                    make(i, m);
                }
                make(s - 7 - auxc, m);
                make(s + 21 + auxc, m);
                break;
                case "Reversed":
                for (int i = s - m.getColumn() * 2 + 7; i < s - m.getColumn(); ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2 + 7; i < s + m.getColumn() * 3; ++i) {
                    make(i, m);
                }
                for (int i = s; i < s + 8; ++i) {
                    make(i, m);
                }
                make(s - 8 - auxc, m);
                make(s + 20 + auxc, m);
                break;
        }
    }
    public ORGate(int s, Map m, File f, String lname) throws IOException {
        setRow(7);
        setColumn(14);
        setName("ORGate");
        setLname(lname);
        int auxc = m.getColumn() - 14;
        for (int i = s - m.getColumn() * 3; i < s + m.getColumn() * 4; ++i) {
            getBoard().put(i, new Cell(0, i));
        }
        switch(lname) {
            case "Normal":
                for (int i = s - m.getColumn() * 2; i < s - m.getColumn() * 2 + 7; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2; i < s + m.getColumn() * 2 + 7; ++i) {
                    make(i, m);
                }
                for (int i = s + 6; i < s + 14; ++i) {
                    make(i, m);
                }
                make(s - 8 - auxc, m);
                make(s + 21 + auxc, m);
                break;
            case "Reversed":
                for (int i = s - m.getColumn() * 2 + 7; i < s - m.getColumn(); ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2 + 7; i < s + m.getColumn(); ++i) {
                    make(i, m);
                }
                for (int i = s; i < s + 8; ++i) {
                    make(i, m);
                }
                make(s - 9 - auxc, m);
                make(s + 20 + auxc, m);
                break;
        }
        this.addToFile(f, m, s);
    }
}
