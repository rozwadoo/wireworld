package mapa;

import java.io.File;
import java.io.IOException;

public class Diode extends Structure {
    public Diode(int s, Map m, String lname) {
        setRow(7);
        setColumn(14);
        setName("Diode");
        setLname("Normal");
        int auxc = m.getColumn() - 14;
        for (int i = s - m.getColumn() * 3; i < s + m.getColumn() * 4; ++i) {
            getBoard().put(i, new Cell(0, i));
        }
        switch (lname) {
            case "Normal":
                for (int i = s; i < s + 7; ++i) {
                    make(i, m);
                }
                for (int i = s + 8; i < s + 14; ++i) {
                    make(i, m);
                }
                make(s + 6 - m.getColumn(), m);
                make(s + 7 - m.getColumn(), m);
                make(s + 6 + m.getColumn(), m);
                make(s + 7 + m.getColumn(), m);
                break;
            case "Reversed":
                for (int i = s; i < s + 6; ++i) {
                    make(i, m);
                }
                for (int i = s + 7; i < s + 14; ++i) {
                    make(i, m);
                }
                make(s + 6 - m.getColumn(), m);
                make(s + 7 - m.getColumn(), m);
                make(s + 6 + m.getColumn(), m);
                make(s + 7 + m.getColumn(), m);
                break;
        }
    }
}
