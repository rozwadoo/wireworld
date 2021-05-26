package Graphic;

import mapa.Map;

public class Iteration implements Runnable {

    private Map m;
    private Frame ramka;
    private int it;

    Iteration(Map m, Frame ramka, int it){
        this.m = m;
        this.ramka = ramka;
        this.it = it;
    }

    @Override
    public void run() {
        for(int i=0;i<it;i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {}
            m.iterate();
            ramka.takeMap(m.getmToInt());
            ramka.update();
        }
    }
}
