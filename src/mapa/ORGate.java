package mapa;

import java.io.File;
import java.io.IOException;

public class ORGate extends Structure {
    public ORGate(int s, Map m, String lname) {
        setRow(7);
        setColumn(14);
        setName("ORGate");
        setStart(s);
        setLname(lname);
        switch (lname) {
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
                make(s + 7 - m.getColumn(), m);
                make(s + 7 + m.getColumn(), m);
                break;
            case "Reversed":
                for (int i = s - m.getColumn() * 2 + 7; i < s - m.getColumn() * 2 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2 + 7; i < s + m.getColumn() * 2 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s; i < s + 8; ++i) {
                    make(i, m);
                }
                make(s + 6 - m.getColumn(), m);
                make(s + 6 + m.getColumn(), m);
                break;
        }
        m.LoE.put(getStart() , this);
    }
}