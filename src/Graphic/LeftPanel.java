package Graphic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LeftPanel extends JPanel implements ActionListener {

    private final JTextField wprowadzNazwePliku = new JTextField();
    private final JTextField wprowadzLiczbeIteracji = new JTextField();

    protected JButton zatwierdzIteracje = new JButton("Zatwierdz");
    protected JButton zatwierdzNazwePliku = new JButton("Zatwierdz");
    protected JButton saveThisIteration = new JButton("Zapisz iteracje");
    protected JButton runAll = new JButton("START");
    protected JButton run1 = new JButton("1 iteracja");
    protected JButton acctual = new JButton("Aktualizuj");
    private final JButton wybierzNazwePliku = new JButton("Wybierz plik:");

    private String nazwaPliku;
    private int numerIteracji;

    LeftPanel(){
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        wybierzNazwePliku.addActionListener(this);
        zatwierdzIteracje.addActionListener(this);

        JLabel napisWprowadzPlik = new JLabel("Wprowadź nazwę pliku");
        JLabel napisWprowadzIteracje = new JLabel("Wprowadź liczbę iteracji");

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(napisWprowadzPlik,30,30,30)
                        .addComponent(wprowadzNazwePliku,30,30,30)
                        .addComponent(wybierzNazwePliku, 30,30,30)
                        .addComponent(zatwierdzNazwePliku,30,30,30)
                        .addGap(30)
                        .addComponent(napisWprowadzIteracje,30,30,30)
                        .addComponent(wprowadzLiczbeIteracji,30,30,30)
                        .addComponent(zatwierdzIteracje,30,30,30)
                        .addGap(30)
                        .addComponent(acctual, 30,30,30)
                        .addComponent(saveThisIteration, 30,30,30)
                        .addGap(30)
                        .addComponent(runAll,30,30,30)
                        .addComponent(run1,30,30,30)
        );
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(napisWprowadzPlik,150,150,150)
                                .addComponent(wprowadzNazwePliku,150,150,150)
                                .addComponent(wybierzNazwePliku, 150,150,150)
                                .addComponent(zatwierdzNazwePliku,150,150,150)
                                .addGap(50)
                                .addComponent(napisWprowadzIteracje,150,150,150)
                                .addComponent(wprowadzLiczbeIteracji,150,150,150)
                                .addComponent(zatwierdzIteracje,150,150,150)
                                .addGap(50)
                                .addComponent(acctual, 150,150,150)
                                .addComponent(saveThisIteration,150,150,150)
                                .addGap(50)
                                .addComponent(runAll,150,150,150)
                                .addComponent(run1,150,150,150)
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
}
