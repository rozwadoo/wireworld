package mapa;

public class Conductor extends Structure {

    public Conductor(int s, Map m, String lname) {
        setName("Conductor");
        setLname(lname);
        setStart(s);
        make(s, m);
        m.getLoE().put(getStart() , this);
    }

    public Conductor(int s, Map m, String lname, int n) {
        setName("Conductor");
        setLname(lname);
        switch (lname) {
            case "HR":
                for (int i = s; i < s + n; ++i) {
                    make(i, m);
                }
                break;
            case "HL":
                for (int i = s - n + 1; i < s + 1; ++i) {
                    make(i, m);
                }
                break;
            case "VD":
                for (int i = 0; i < n; ++i) {
                    make(s - m.getColumn() * i, m);
                }
                break;
            case "VU":
                for (int i = 0; i < n; ++i) {
                    make(s + m.getColumn() * i, m);
                }
                break;
        }
        m.getLoE().put(getStart() , this);
    }
}

