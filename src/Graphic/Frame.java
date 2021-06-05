package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{

    private int[][] mapOfCells = new int[51][51];
    protected LeftPanel leftPanel = new LeftPanel();
    protected RightPanel rightPanel = new RightPanel();
    private Interface anInterface;

    public Frame(Interface a) {
        super("Wire World");
        anInterface = a;
        setPreferredSize(new Dimension(1100, 750));
        setLocation(0,0);

        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        add(leftPanel);
        add(rightPanel);
        leftPanel.runAll.addActionListener(this);
        leftPanel.zatwierdzIteracje.addActionListener(this);
        leftPanel.zatwierdzNazwePliku.addActionListener(this);
        leftPanel.run1.addActionListener(this);
        leftPanel.saveThisIteration.addActionListener(this);
        leftPanel.acctual.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void takeMap(int[][] tym){
        this.mapOfCells = tym;
    }

    public void update(){
        for(int i=1; i < rightPanel.board.getRowsColws(); i++)
        {
            for(int j = 1; j < rightPanel.board.getRowsColws(); j++)
            {
                rightPanel.board.update(mapOfCells[i][j],i ,j);
            }
        }
    }

    public String getFileName(){
        return leftPanel.getNazwaPliku();
    }

    public int[][] getTym(){
        return rightPanel.getBoard();
    }

    private void createEditedMap(){
        for(int i = 1; i < rightPanel.board.getRowsColws(); i++){
            for(int j = 1; j < rightPanel.board.getRowsColws(); j++){
                mapOfCells[i][j] = rightPanel.getIntegerOfBoard(i,j);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == leftPanel.run1){
            anInterface.iterateBoard();
        }

        if (source == leftPanel.runAll) {
            anInterface.iteratesBoard(leftPanel.getNumerIteracji());
        }

        if (source ==leftPanel.zatwierdzNazwePliku){
            anInterface.showMap();
        }

        if(source == leftPanel.zatwierdzIteracje){
            createEditedMap();
        }

        if(source == leftPanel.saveThisIteration){
            anInterface.save();
        }

        if(source == leftPanel.acctual){

        }
    }
}
