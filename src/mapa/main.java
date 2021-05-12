package mapa;

import Graphic.Frame;

import java.io.IOException;

public class main {
    public static void main(String[] args) {

        Frame ramka = new Frame();
        map m = new map();

        try {
            m.read(args[0]);
        } catch( IOException e) {
            System.err.println( "Linia: "+e.getMessage());
        }



        int it = Integer.parseInt(args[1]);

        for (int i = 0; i <= 5; ++i) {
            m.getBoard().forEach((k,v) -> v.generate());
            m.getBoard().forEach((k,v) -> v.update());
        }

        System.out.println("col" + m.getColumn());
        System.out.println("row" + m.getRow());
        //System.out.println("b" + m.getBoard().get(43).getState0() + " ");

        for (int j = 0; j <=8; ++j) {
            for (int i = 1; i <= 14; ++i) {
                System.out.printf("%d ", m.getBoard().get(i + j * 14).getState0());
            }
            System.out.println("\n");
        }


        /*for(int i = 0; i < 8; ++i) System.out.printf("%d ", m.getBoard().get(133).getN(i).getPosition());
        for(int i = 0; i < 8; ++i) System.out.printf("%d ", m.getBoard().get(147).getN(i).getPosition());
        for(int i = 0; i < 8; ++i) System.out.printf("%d ", m.getBoard().get(48).getN(i).getPosition());*/
    }
}
