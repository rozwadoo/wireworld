package mapa;

public class AndNotGate extends Structure {
    public AndNotGate(int s, Map m, String lname){
        setRow(9);
        setColumn(14);
        setName("AndNotGate");
        setLname(lname);
        for (int i = s - m.getColumn() * 4; i < s + m.getColumn() * 5; ++i) {
            getBoard().put(i, new Cell(0, i));
        }
        switch(lname) {
            case "Normal":
                for (int i = s - m.getColumn() * 3; i < s - m.getColumn() * 3 + 7; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 3; i < s + m.getColumn() * 3 + 5; ++i) {
                    make(i, m);
                }
                for (int i = s - m.getColumn() + 6; i < s - m.getColumn() + 9; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() + 8; i < s + m.getColumn() + 14; ++i) {
                    make(i, m);
                }
                make(s - m.getColumn() * 2 + 7, m);
                make(s + 7, m);
                make(s + m.getColumn() * 2 + 5, m);
                make(s + m.getColumn() + 6, m);
                break;
            case "Reversed":
                for (int i = s - m.getColumn() * 3 + 7; i < s - m.getColumn() * 3 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn() * 3 + 9; i < s + m.getColumn() * 3 + 14; ++i) {
                    make(i, m);
                }
                for (int i = s - m.getColumn() + 5; i < s - m.getColumn() + 8; ++i) {
                    make(i, m);
                }
                for (int i = s + m.getColumn(); i < s + m.getColumn() + 6; ++i) {
                    make(i, m);
                }
                make(s - m.getColumn() * 2 + 6, m);
                make(s + 6, m);
                make(s + m.getColumn() * 2 + 8, m);
                make(s + m.getColumn() + 7, m);
                break;
        }
    }
}
