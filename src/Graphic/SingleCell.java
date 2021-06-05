package Graphic;

import Graphic.ElementsButtons.*;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

public class SingleCell extends JButton implements ActionListener {

    private final BoardSetting boardSetting;
    private final SingleCell[][] cell;
    private final Board board;
    private final int i;
    private final int j;
    private boolean isEditable;

    SingleCell( SingleCell[][] cell,BoardSetting boardSetting, int i, int j, Board board){
        super();
        this.i = i;
        this.j = j;
        this.cell = cell;
        this.boardSetting = boardSetting;
        this.boardSetting.setNameElement("Empty");
        isEditable = true;
        this.board = board;
        addActionListener(this);
    }

    public void setElement(){
        setBackground(Color.YELLOW);
        isEditable = false;
    }

    public void setEditable(boolean b){
        isEditable = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == this){
            if(isEditable)
                createElement();
        }
    }

    private void createElement(){
        String name = boardSetting.getNameElement();

        if(name.equals("Empty")){
            this.setBackground(Color.BLACK);
        } else
        if(name.equals("Electron tail")){
            this.setBackground(Color.orange);
        } else
        if(name.equals("Conductor")){
            this.setBackground(Color.yellow);
        } else
        if(name.equals("Electron head")){
            this.setBackground(Color.BLUE);
        } else

        if(name.equals("AndNotGate")){
            new ElemenstAndNotGate(cell, i -3, j);
            board.addTextLine("AndNotGate", i, j, "Normal");
        } else
        if(name.equals("R AndNotGate")){
            new ElementReverseAndNotGate(cell, i - 3, j);
            board.addTextLine("AndNotGate", i, j, "Reversed");
        } else

        if(name.equals("Diode")){
            new ElementDiode(cell, i - 1, j);
            board.addTextLine("Diode", i, j, "Normal");
        } else
        if(name.equals("R Diode")){
            new ElementReverseDiode(cell, i - 1, j);
            board.addTextLine("Diode", i, j, "Reversed");
        } else

        if(name.equals("EORGate")) {
            new ElementEORGate(cell, i -3, j);
            board.addTextLine("EORGate", i, j, "Normal");
        } else
        if(name.equals("R EORGate")) {
            new ElementReverseEORGate(cell, i -3, j);
            board.addTextLine("EORGate", i, j, "Reversed");
        } else

        if(name.equals("FlipFlop")) {
            new ElementFlipFlop(cell, i - 4, j);
            board.addTextLine("FlipFlop", i, j, "Normal");
        } else
        if(name.equals("R FlipFlop")) {
            new ElementReverseFlipFlop(cell, i - 4, j);
            board.addTextLine("FlipFlop", i, j, "Reversed");
        } else

        if(name.equals("ORGate")) {
            new ElementORGate(cell, i - 2, j);
            board.addTextLine("ORGate", i, j, "Normal");
        } else
        if(name.equals("R ORGate")) {
            new ElementReverseORGate(cell, i - 2, j);
            board.addTextLine("ORGate", i, j, "Reversed");
        }
    }
}
