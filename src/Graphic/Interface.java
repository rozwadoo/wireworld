package Graphic;

import mapa.Map;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class Interface {

    private final Frame frame = new Frame(this);
    private final Map m = new Map();
    private File file;

    public Interface() {
        getM().setColumn(frame.rightPanel.board.getRowsColws());
        getM().setRow(frame.rightPanel.board.getRowsColws());

        try {
            PrintWriter writer = new PrintWriter("temporary.txt");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public void showMap(String name) {
        try {
            getM().setDim(name);
            getM().read(name);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        file = new File(name);
        frame.takeMap(getM().getmToInt());
        frame.update();
    }

    public void iterateBoard(){
        getM().iterate();
        frame.takeMap(getM().getmToInt());
        frame.update();
    }

    public void iteratesBoard(int it) {
        Timer dataTimer = new Timer();
        dataTimer.schedule(new TimerTask() {

            public int ta = it;

            @Override
            public void run() {
                getM().iterate();
                frame.takeMap(getM().getmToInt());
                frame.update();
                ta--;
                if(ta == 0){
                    dataTimer.cancel();
                    dataTimer.purge();
                }
            }
        }, 0, 400);
    }

    public void save(){
        try {
            getM().save("output.txt", frame.rightPanel.board.getLoE() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actually(File temporary){

        String new_odp = "temporary.txt";
        PrintWriter pw;

        try {

            pw = new PrintWriter(new_odp);
            BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String line = br.readLine();

            while (line != null)
            {
                pw.println(line);
                line = br.readLine();
            }

            br = new BufferedReader(new FileReader(temporary.getAbsolutePath()));
            line = br.readLine();

            while(line != null)
            {
                pw.println(line);
                line = br.readLine();
            }

            pw.flush();
            br.close();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        showMapUpdate(new_odp);
    }

    private void showMapUpdate(String name) {
        try {
            getM().setDim(name);
            getM().read(name);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        frame.takeMap(getM().getmToInt());
        frame.update();
    }

    public Map getM() {
        return m;
    }
}

