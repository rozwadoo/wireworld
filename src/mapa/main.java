package mapa;

import Graphic.Frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Frame ramka = new Frame();
        map m = new map();


        try {
            m.setDim(args[0]);
            m.read(args[0]);
        } catch( IOException e) {
            System.err.println(e.getMessage());
        }

        ramka.takeMap(m.getmToInt());
        ramka.update();

        int it = Integer.parseInt(args[1]);

        for (int i = 0; i <= it; ++i) {
            //Thread.sleep(550);
            m.iterate();
            ramka.takeMap(m.getmToInt());
            ramka.update();
        }

       // System.out.println("col" + m.getColumn());
        //System.out.println("row" + m.getRow());
        //System.out.println("b" + m.getBoard().get(43).getState0() + " ");
        //File file=new File("test/diode1");
        File file=new File("test/output.txt");
        m.save(file,"test/output1.txt" );

        for (int j = 0; j <13; ++j) {
            for (int i = 1; i <= 14; ++i) {
                System.out.printf("%d ", m.getBoard().get(i + j * 14).getState0());
            }
            System.out.println("\n");
        }
        /*System.out.println("\n");
        int[][] a = m.translate();
        for (int j = 0; j <13; ++j) {
            for (int i = 0; i < 14; ++i) {
                System.out.printf("%d ", a[j][i]);
            }
            System.out.println("\n");
        }*/

        /*for (int j = 0; j <13; ++j) {
            for (int i = 1; i <= 14; ++i) {
                System.out.printf("%d ", m.getBoard().get(i + j * 14).getPosition());
            }
            System.out.println("\n");
        }*/

        //for(int i = 0; i < 8; ++i) System.out.printf("%d ", m.getBoard().get(133).getN(i).getPosition());
        //for(int i = 0; i < 8; ++i) System.out.printf("%d ", m.getBoard().get(147).getN(i).getPosition());
       //for(int i = 0; i < 8; ++i) System.out.printf("%d ", m.getBoard().get(48).getN(i).getPosition());
        ///int q = m.getColumn()*(m.getRow()-1);
        //int w = m.getBoard().get(147).getPosition() % m.getColumn();
    }

}
