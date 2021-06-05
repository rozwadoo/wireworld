package Graphic;

import Graphic.ElementsButtons.ElementDiode;
import mapa.Map;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Interface {

    private Frame frame = new Frame(this);
    private Map m = new Map();
    private File tymczasowy;

    public Interface() {
        m.setColumn(frame.rightPanel.board.getRowsColws());
        m.setRow(frame.rightPanel.board.getRowsColws());
    }

    public void showMap() {
        try {
            m.setDim(frame.getFileName());
            m.read(frame.getFileName());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        tymczasowy = new File(frame.getFileName());
        frame.takeMap(m.getmToInt());
        frame.update();
    }

    public void iterateBoard(){
        m.iterate();
        frame.takeMap(m.getmToInt());
        frame.update();
    }

    public void iteratesBoard(int it) {
        Timer dataTimer = new Timer();
        dataTimer.schedule(new TimerTask() {

            public int ta = it;

            @Override
            public void run() {
                m.iterate();
                frame.takeMap(m.getmToInt());
                frame.update();
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

