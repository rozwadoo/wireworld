package Graphic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LeftPanel extends JPanel implements ActionListener {

    private JLabel napisWprowadzPlik = new JLabel("Wprowadź nazwę pliku");
    private JLabel napisWprowadzIteracje = new JLabel("Wprowadź liczbę iteracji");

    private JTextField wprowadzNazwePliku = new JTextField();
    private JTextField wprowadzLiczbeIteracji = new JTextField();

    protected JButton zatwierdzIteracje = new JButton("Zatwierdz");
    protected JButton zatwierdzNazwePliku = new JButton("Zatwierdz");
    protected JButton saveThisIteration = new JButton("Zapisz iteracje");

    private JButton wybierzNazwePliku = new JButton("Wybierz plik:");

    private JLabel odstep = new JLabel();
    protected JButton run = new JButton("START");
    protected JButton run1 = new JButton("1 iteracja");

    private final JFileChooser fc = new JFileChooser();

    private String nazwaPliku;
    private int numerIteracji;

    LeftPanel(){
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        wybierzNazwePliku.addActionListener(this);
        zatwierdzIteracje.addActionListener(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(napisWprowadzPlik,35,35,35)
                        .addComponent(wprowadzNazwePliku,35,35,35)
                        .addComponent(wybierzNazwePliku, 35,35,35)
                        .addComponent(zatwierdzNazwePliku,35,35,35)
                        .addComponent(odstep, 35,35,35)
                        .addComponent(napisWprowadzIteracje,35,35,35)
                        .addComponent(wprowadzLiczbeIteracji,35,35,35)
                        .addComponent(zatwierdzIteracje,35,35,35)
                        .addComponent(odstep, 35,35,35)
                        .addComponent(saveThisIteration, 35,35,35)
                        .addComponent(run1,35,35,35)
                        .addComponent(run,35,35,35)
        );
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(napisWprowadzPlik,150,150,150)
                                .addComponent(wprowadzNazwePliku,150,150,150)
                                .addComponent(wybierzNazwePliku, 150,150,150)
                                .addComponent(zatwierdzNazwePliku,150,150,150)
                                .addComponent(odstep, 50,50,50)
                                .addComponent(napisWprowadzIteracje,150,150,150)
                                .addComponent(wprowadzLiczbeIteracji,150,150,150)
                                .addComponent(zatwierdzIteracje,150,150,150)
                                .addComponent(odstep, 50,50,50)
                                .addComponent(saveThisIteration,150,150,150)
                                .addComponent(run1,150,150,150)
                                .addComponent(run,150,150,150)
                        )
        );
    }

    public int getNumerIteracji(){
        return numerIteracji;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    private void takeFile(){
        File file;
        int response;
        JFileChooser chooser = new JFileChooser(".");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            nazwaPliku = file.getPath();
            wprowadzNazwePliku.setText(nazwaPliku);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == zatwierdzIteracje){
            numerIteracji = Integer.parseInt(wprowadzLiczbeIteracji.getText());
        }

        if(source == wybierzNazwePliku){
            takeFile();
        }

        if(source == zatwierdzNazwePliku){
            nazwaPliku = wprowadzNazwePliku.getText();
        }
    }

    private boolean isInteger(String input ) { //Pass in string
        try { //Try to make the input into an integer
            Integer.parseInt( input );
            return true; //Return true if it works
        }
        catch( Exception e ) {
            return false; //If it doesn't work return false
        }
    }
}
