package Graphic;

import Graphic.ElementsButtons.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleCell extends JButton implements ActionListener {

    private final BoardSetting boardSetting;
    private final SingleCell[][] cell;
    private final int i;
    private final int j;
    private boolean isEditable;

    SingleCell( SingleCell[][] cell,BoardSetting boardSetting, int i, int j){
        super();
        this.i = i;
        this.j = j;
        this.cell = cell;
        this.boardSetting = boardSetting;
        this.boardSetting.setNameElement("Empty");
        isEditable = true;
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

        if(j + 14 > 41 || i + 9 > 41);//sprawdza czy elementy nie wyjdą poza granice
        else
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
            new ElemenstAndNotGate(cell, i, j);
        } else
        if(name.equals("R AndNotGate")){
            new ElementReverseAndNotGate(cell, i, j);
        } else

        if(name.equals("Diode")){
            new ElementDiode(cell, i, j);
        } else
        if(name.equals("R Diode")){
            new ElementReverseDiode(cell, i, j);
        } else

        if(name.equals("EORGate")) {
            new ElementEORGate(cell, i, j);
        } else
        if(name.equals("R EORGate")) {
            new ElementReverseEORGate(cell, i, j);
        } else

        if(name.equals("FlipFlop")) {
            new ElementFlipFlop(cell, i, j);
        } else
        if(name.equals("R FlipFlop")) {
            new ElementReverseFlipFlop(cell, i, j);
        } else

        if(name.equals("ORGate")) {
            new ElementORGate(cell, i, j);
        } else
        if(name.equals("R ORGate")) {
            new ElementReverseORGate(cell, i, j);
        }
    }

}
