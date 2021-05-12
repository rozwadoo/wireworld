package Graphic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {

    JLabel napisWprowadzPlik = new JLabel("Wprowadź nazwę pliku");
    JLabel napisWprowadzIteracje = new JLabel("Wprowadź liczbę iteracji");

    JTextField wprowadzNazwePliku = new JTextField();
    JTextField wprowadzLiczbeIteracji = new JTextField();

    JButton zatwierdzIteracje = new JButton("Zatwierdz");
    JButton zatwierdzNazwePliku = new JButton("Zatwierdz");

    JLabel odstep = new JLabel();
    JButton run = new JButton("START");

    /*public String nazwaPliku;
    public int numerIteracji;
    public boolean start = false;
*/
    LeftPanel(){
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
/*
        zatwierdzIteracje.addActionListener(this);
        zatwierdzNazwePliku.addActionListener(this);
        run.addActionListener(this);
*/
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(napisWprowadzPlik,50,50,50)
                        .addComponent(wprowadzNazwePliku,35,35,35)
                        .addComponent(zatwierdzNazwePliku,50,50,50)
                        .addComponent(odstep, 50,50,50)
                        .addComponent(napisWprowadzIteracje,50,50,50)
                        .addComponent(wprowadzLiczbeIteracji,35,35,35)
                        .addComponent(zatwierdzIteracje,50,50,50)
                        .addComponent(odstep, 50,50,50)
                        .addComponent(run)
        );
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(napisWprowadzPlik,150,150,150)
                                .addComponent(wprowadzNazwePliku,150,150,150)
                                .addComponent(zatwierdzNazwePliku,150,150,150)
                                .addComponent(odstep, 150,150,150)
                                .addComponent(napisWprowadzIteracje,150,150,150)
                                .addComponent(wprowadzLiczbeIteracji,150,150,150)
                                .addComponent(zatwierdzIteracje,150,150,150)
                                .addComponent(odstep, 50,50,50)
                                .addComponent(run)
                        )
        );
    }
/*
    public String getNazwaPliku() {
        return nazwaPliku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == zatwierdzIteracje){
            numerIteracji = Integer.parseInt(wprowadzLiczbeIteracji.getText());

        }

        if(source == zatwierdzNazwePliku){
            nazwaPliku = wprowadzNazwePliku.getText();
        }

        if(source == run){
            start = true;
        }
    }*/
}
