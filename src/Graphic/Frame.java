package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadPoolExecutor;

public class Frame extends JFrame implements ActionListener{

    private int[][] tym = new int[51][51];
    protected LeftPanel lewy = new LeftPanel();
    protected RightPanel prawy = new RightPanel();
    private Interface taka;
    private Iteration iteracja;

    public Frame(Interface a) {
        super("Wire World");
        taka = a;
        setPreferredSize(new Dimension(1100, 750));
        setLocation(0,0);

        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        add(lewy);
        add(prawy);
        lewy.run.addActionListener(this);
        lewy.zatwierdzIteracje.addActionListener(this);
        lewy.zatwierdzNazwePliku.addActionListener(this);
        lewy.run1.addActionListener(this);
        lewy.saveThisIteration.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void takeMap(int[][] tym){
        this.tym = tym;
    }

    public void update(){
        for(int i=1; i < prawy.tarcza.getRowsColws(); i++)
        {
            for(int j = 1; j < prawy.tarcza.getRowsColws(); j++)
            {
                prawy.tarcza.update(tym[i][j],i ,j);
            }
        }
    }

    public String getFileName(){
        return lewy.getNazwaPliku();
    }

    private void createEditedMap(){
        for(int i = 0; i < prawy.getRowsCols(); i++){
            for(int j = 0; j < prawy.getRowsCols(); j++){
                tym[i][j] = prawy.getIntegerOfBoard(i,j);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == lewy.run1){
            taka.iterateBoard();
        }

        if (source == lewy.run) {
            iteracja = new Iteration(taka.getM(), this, lewy.getNumerIteracji());
        }

        if (source ==lewy.zatwierdzNazwePliku){
            taka.showMap();
        }

        if(source == lewy.zatwierdzIteracje){
            createEditedMap();
        }

       /* if(source == lewy.saveThisIteration){
            taka.save();
        }

        */
    }
}
