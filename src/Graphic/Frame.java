package Graphic;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private int[][] tym;
    public LeftPanel lewy = new LeftPanel();
    private RightPanel prawy = new RightPanel();


    public Frame(){
        super("Wire World");
        setPreferredSize(new Dimension(900, 750));

        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        add(lewy);
        add(prawy);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void takeMap(int[][] tym){
        this.tym = tym;
    }

    public void update(){
        for(int i=0; i < prawy.getRowsColws(); i++)
        {
            for(int j = 0; j < prawy.getRowsColws(); j++)
            {
                prawy.update(tym[i][j],i ,j);
            }
        }
    }
/*
    public void dateIn(){
        while(lewy.start == false){
            ;
        }
        System.out.println("q");
    }
*/
}
