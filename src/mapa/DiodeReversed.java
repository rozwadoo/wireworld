package mapa;

import java.io.File;
import java.io.IOException;

public class DiodeReversed extends Structure {
    public DiodeReversed(int s, Map m){
        setRow(7);
        setColumn(14);
        setName("Diode");
        setLname("Reversed");
        int auxc = m.getColumn() - 14;
        for(int i = s-m.getColumn()*3; i < s+m.getColumn()*4; ++i){
            getBoard().put(i, new Cell( 0, i));
        }
        for(int i = s; i < s+6; ++i){
            make(i, m);
        }
        for(int i = s+7; i < s+14; ++i){
            make(i, m);
        }
        make(s-8-auxc, m);
        make(s-7-auxc, m);
        make(s+20+auxc, m);
        make(s+21+auxc, m);
    }
    public DiodeReversed(int s, Map m, File f) throws IOException {
        setRow(7);
        setColumn(14);
        setName("Diode");
        setLname("Reversed");
        int auxc = m.getColumn() - 14;
        for(int i = s-m.getColumn()*3; i < s+m.getColumn()*4; ++i){
            getBoard().put(i, new Cell( 0, i));
        }
        for(int i = s; i < s+6; ++i){
            make(i, m);
        }
        for(int i = s+7; i < s+14; ++i){
            make(i, m);
        }
        make(s-8-auxc, m);
        make(s-7-auxc, m);
        make(s+20+auxc, m);
        make(s+21+auxc, m);
        this.addToFile(f, m, s);
    }
}
