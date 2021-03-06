package mapa;

public class Cell {

    private Cell[] neighbours;
    private int state0;
    private int state1;
    private int position;
    /*  0 - empty
        1 - head
        2 - tail
        3 - conductor
     */

    public Cell(int s0, int p ) {
        setState0(s0);
        setPosition(p);
        setNeighbours(new Cell[8]);
        Map.getBoard().put(position, this);
    }


    public int getState0() {
        return state0;
    }

    public void setState0(int state0) {
        this.state0 = state0;
    }

    public int getState1() {
        return state1;
    }

    public void setState1(int state1) {
        this.state1 = state1;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Cell getN(int n) {
        return getNeighbours()[n];
    }

    public void addN(int n, Cell c) {
            getNeighbours()[n] = c;
    }

    public void giveN(Map m) {
        for(int i = 0; i < 8; ++i) addN(i, m.getBoard().get(1));
        if(getPosition() > m.getColumn() && getPosition() % m.getColumn() != 1) addN(0, m.getBoard().get(this.getPosition()-m.getColumn()-1));
        if(getPosition() > m.getColumn()) addN(1, m.getBoard().get(this.getPosition()-m.getColumn()));
        if(getPosition() > m.getColumn() && getPosition() % m.getColumn() != 0) addN(2, m.getBoard().get(this.getPosition()-m.getColumn()+1));
        if(getPosition() % m.getColumn() != 1) addN(3, m.getBoard().get(this.getPosition()-1));
        if(getPosition() % m.getColumn() != 0) addN(4, m.getBoard().get(this.getPosition()+1));
        if(getPosition() <= m.getColumn()*(m.getRow()-1) && getPosition() % m.getColumn() != 1) addN(5, m.getBoard().get(this.getPosition()+m.getColumn()-1));
        if(getPosition() <= m.getColumn()*(m.getRow()-1)) addN(6, m.getBoard().get(this.getPosition()+m.getColumn()));
        if(getPosition() <= m.getColumn()*(m.getRow()-1) && getPosition() % m.getColumn() != 0) addN(7, m.getBoard().get(this.getPosition()+m.getColumn()+1));
    }

    public int count(){
        int s = 0;
        for (int i = 0; i < 8; ++i) {
            if (getNeighbours()[i].getState0() == 1) s += 1;
        }
        return s;
    }

    public void generate(){
        if( this.state0 == 0) setState1(0);
        else if( this.state0 == 1) setState1(2);
        else if( this.state0 == 2) setState1(3);
        else if( this.state0 == 3 && (this.count() == 1 || this.count() == 2)) setState1(1);
        else setState1(3);
    }

    public void update(){
        setState0(this.state1);
    }

    public boolean equals( Cell c ) {
        return c.getPosition() == this.getPosition();
    }

    public Cell[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Cell[] neighbours) {
        this.neighbours = neighbours;
    }
}
