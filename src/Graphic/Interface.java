package Graphic;

import Graphic.Frame;
import mapa.Map;

import java.io.File;
import java.io.IOException;

public class Interface {

    private Frame ramka = new Frame(this);
    private Map m = new Map();
    private int it;

    public Interface() throws InterruptedException {
    }

    public void showMap() {
        try {
            m.setDim(ramka.getFileName());
            m.read(ramka.getFileName());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        ramka.takeMap(m.getmToInt());
        ramka.update();
    }

    public Map getM(){
        return m;
    }

    public void takeIt(int i){
        it = i;
    }

    public void iterateBoard(){
        m.iterate();
        ramka.takeMap(m.getmToInt());
        ramka.update();
    }

    public void iteratesBoard(int it) {

    }

    /*
    public void save(){
        File file;
        try {
            m.save(file,"test/output.txt" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
}

