package Graphic;

import Graphic.Frame;
import mapa.Map;

import java.io.IOException;

public class Interface {

    private Frame ramka = new Frame(this);
    private Map m = new Map();

    public Interface() {
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

    public void iterateBoard(){
        m.iterate();
        ramka.takeMap(m.getmToInt());
        ramka.update();
    }
}

