package mapa;

import java.io.File;
import java.io.IOException;

public class diodeNormal extends structure{
    public diodeNormal( int s, map m){
        setRow(7);
        setColumn(14);
        setName("Diode");
        int auxc = m.getColumn() - 14;
        for(int i = s-m.getColumn()*3; i < s+m.getColumn()*4; ++i){
            getBoard().put(i, new cell( 0, i));
        }
        for(int i = s; i < s+7; ++i){
            make(i, m);
        }
        for(int i = s+8; i < s+14; ++i){
            make(i, m);
        }
        make(s-8-auxc, m);
        make(s-7-auxc, m);
        make(s+20+auxc, m);
        make(s+21+auxc, m);
    }
    public diodeNormal(int s, map m, File f, String fname) throws IOException {
        setRow(7);
        setColumn(14);
        int auxc = m.getColumn() - 14;
        for(int i = s-m.getColumn()*3; i < s+m.getColumn()*4; ++i){
            getBoard().put(i, new cell( 0, i));
        }
        for(int i = s; i < s+7; ++i){
            make(i, m);
        }
        for(int i = s+8; i < s+14; ++i){
            make(i, m);
        }
        make(s-8-auxc, m);
        make(s-7-auxc, m);
        make(s+20+auxc, m);
        make(s+21+auxc, m);
        this.addToFile(f, m, s, fname);
    }
}
