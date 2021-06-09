package mapa;

public class Diode extends Structure {
    public Diode(int s, Map m, String lname) {
        setRow(7);
        setColumn(14);
        setName("Diode");
        setLname(lname);
        setStart(s);
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
        m.getLoE().put(getStart() , this);
    }
    public Diode(int s, String lname) {
        setName("Diode");
        setLname(lname);
        setStart(s);
    }
}
