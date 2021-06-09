package Graphic;

import Graphic.Element.*;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void setEditable(boolean b){
        isEditable = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == this){
            if(boardSetting.getNameElement().equals("Electron tail") || boardSetting.getNameElement().equals("Electron head"))
                createElement();
            else
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
            board.addTextLine("ElectronTail", i, j);
        } else
        if(name.equals("Conductor")){
            this.setBackground(Color.yellow);
            board.addTextLine("Conductor", i, j);
        } else
        if(name.equals("Electron head")){
            this.setBackground(Color.BLUE);
            board.addTextLine("ElectronHead", i, j);
        } else

        if(name.equals("AndNotGate")){
            new AndNotGate(cell, i -3, j).normal();
            board.addTextLine("AndNotGate", i, j, "Normal");
        } else
        if(name.equals("R AndNotGate")){
            new AndNotGate(cell, i - 3, j).normal();
            board.addTextLine("AndNotGate", i, j, "Reversed");
        } else

        if(name.equals("Diode")){
            new Diode(cell, i - 1, j).normal();
            board.addTextLine("Diode", i, j, "Normal");
        } else
        if(name.equals("R Diode")){
            new Diode(cell, i - 1, j).reverse();
            board.addTextLine("Diode", i, j, "Reversed");
        } else

        if(name.equals("EORGate")) {
            new EORGate(cell, i -3, j).normal();
            board.addTextLine("EORGate", i, j, "Normal");
        } else
        if(name.equals("R EORGate")) {
            new EORGate(cell, i -3, j).reverse();
            board.addTextLine("EORGate", i, j, "Reversed");
        } else

        if(name.equals("FlipFlop")) {
            new FlipFlop(cell, i - 4, j).normal();
            board.addTextLine("FlipFlop", i, j, "Normal");
        } else
        if(name.equals("R FlipFlop")) {
            new FlipFlop(cell, i - 4, j).reverse();
            board.addTextLine("FlipFlop", i, j, "Reversed");
        } else

        if(name.equals("ORGate")) {
            new ORGate(cell, i - 2, j).normal();
            board.addTextLine("ORGate", i, j, "Normal");
        } else
        if(name.equals("R ORGate")) {
            new ORGate(cell, i - 2, j).reverse();
            board.addTextLine("ORGate", i, j, "Reversed");
        }
    }
}
