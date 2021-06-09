package mapa;

public class FlipFlop extends Structure {
    public FlipFlop(int s, Map m, String lname) {
        setRow(11);
        setColumn(14);
        setName("FlipFlop");
        setLname(lname);
        setStart(s);
        switch (lname) {
            case "Normal":
                for (int i = s - m.getColumn() * 4; i < s - m.getColumn() * 4 + 6; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 4; i < s + m.getColumn() * 4 + 5; ++i) {
                    make(i, m);
                }
                for (int i = s + 7; i < s + 14; ++i) {
                    make(i, m);
                }
                make(s - m.getColumn() * 3 + 6, m);
                make(s - m.getColumn() + 6, m);
                make(s + 5, m);
                make(s + m.getColumn() + 5, m);
                make(s + m.getColumn() + 7, m);
                make(s + m.getColumn() * 3 + 5, m);
                for (int i = s - m.getColumn() * 2 + 5; i < s - m.getColumn() * 2 + 8; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2 + 4; i < s + m.getColumn() * 2 + 7; ++i) {
                    make(i, m);
                }
                break;
            case "Reversed":
                for (int i = s - m.getColumn() * 4 + 8; i < s - m.getColumn() * 4 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 4 + 9; i < s + m.getColumn() * 4 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s; i < s + 7; ++i) {
                    make(i, m);
                }
                make(s - m.getColumn() * 3 + 7, m);
                make(s - m.getColumn() + 7, m);
                make(s + 8, m);
                make(s + m.getColumn() + 6, m);
                make(s + m.getColumn() + 8, m);
                make(s + m.getColumn() * 3 + 8, m);
                for (int i = s - m.getColumn() * 2 + 6; i < s - m.getColumn() * 2 + 9; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 2 + 7; i < s + m.getColumn() * 2 + 10; ++i) {
                    make(i, m);
                }
                break;
        }
        m.LoE.put(getStart() , this);
    }
}