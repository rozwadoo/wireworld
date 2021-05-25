package mapa;

public class EORGate extends Structure {
    public EORGate(int s, Map m, String lname){
        setRow(9);
        setColumn(14);
        setName("EORGate");
        setLname(lname);
        for (int i = s - m.getColumn() * 4; i < s + m.getColumn() * 5; ++i) {
            getBoard().put(i, new Cell(0, i));
        }
        switch(lname) {
            case "Normal":
                for (int i = s - m.getColumn() * 3; i < s - m.getColumn() * 3 + 6; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 3; i < s + m.getColumn() * 3 + 6; ++i) {
                    make(i, m);
                }
                for (int i = s - m.getColumn() + 5; i < s - m.getColumn() + 9; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() + 5; i < s + m.getColumn() + 9; ++i) {
                    make(i, m);
                }
                for (int i = s + 8; i < s + 14; ++i) {
                    make(i, m);
                }
                make(s - m.getColumn() * 2 + 6, m);
                make(s + 5, m);
                make(s + m.getColumn() * 2 + 6, m);
                break;
            case "Reversed":
                for (int i = s - m.getColumn() * 3 + 7; i < s - m.getColumn() * 3 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 3 + 7; i < s + m.getColumn() * 3 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s - m.getColumn() + 5; i < s - m.getColumn() + 9; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() + 5; i < s + m.getColumn() + 9; ++i) {
                    make(i, m);
                }
                for (int i = s; i < s + 6; ++i) {
                    make(i, m);
                }
                make(s - m.getColumn() * 2 + 7, m);
                make(s + 8, m);
                make(s + m.getColumn() * 2 + 7, m);
                break;
        }
    }
}
