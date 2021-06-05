package Graphic;

import Graphic.ElementsButtons.ElementDiode;
import mapa.Map;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Interface {

    private Frame ramka = new Frame(this);
    private Map m = new Map();
    private File tymczasowy;

    public Interface() {
        m.setColumn(ramka.prawy.tarcza.getRowsColws());
        m.setRow(ramka.prawy.tarcza.getRowsColws());
    }

    public void showMap() {
        try {
            m.setDim(ramka.getFileName());
            m.read(ramka.getFileName());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        tymczasowy = new File(ramka.getFileName());
        ramka.takeMap(m.getmToInt());
        ramka.update();
    }

    public void iterateBoard(){
        m.iterate();
        ramka.takeMap(m.getmToInt());
        ramka.update();
    }

    public void iteratesBoard(int it) {
        Timer dataTimer = new Timer();
        dataTimer.schedule(new TimerTask() {

            public int ta = it;

            @Override
            public void run() {
                m.iterate();
                ramka.takeMap(m.getmToInt());
                ramka.update();
                ta--;
                if(ta == 0){
                    dataTimer.cancel();
                    dataTimer.purge();
                }
            }
        }, 0, 500);
    }

/*
    public void updateMap(){
        m.getIntToM(ramka.getTym());
    }
*/

    public void save(){
        try {
            m.save(tymczasowy,"test/output.txt" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

