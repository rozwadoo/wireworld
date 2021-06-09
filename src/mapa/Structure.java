package mapa;

public class Structure extends Map {
    private int start;
    private String name;
    private String lname;

    public int getStart() {
        return start;
    }

    {this.getStart();}

    public void setStart(int start) {
        this.start = start;
    }

    public void make(int n, Map m){
        getBoard().get(n).setState0(3);
        getBoard().get(n).giveN(m);
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
