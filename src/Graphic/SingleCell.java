package Graphic;

import Graphic.ElementsButtons.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleCell extends JButton implements ActionListener {

    private final BoardSetting boardSetting;
    private final SingleCell[][] panel;
    private final int i;
    private final int j;
    private boolean isEditable;

    SingleCell( SingleCell[][] panel,BoardSetting boardSetting, int i, int j){
        super();
        this.i = i;
        this.j = j;
        this.panel = panel;
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
            new ElemenstAndNotGate(panel, i, j);
        } else
        if(name.equals("R AndNotGate")){
            new ElementReverseAndNotGate(panel, i, j);
        } else

        if(name.equals("Diode")){
            new ElementDiode(panel, i, j);
        } else
        if(name.equals("R Diode")){
            new ElementReverseDiode(panel, i, j);
        } else

        if(name.equals("EORGate")) {
            new ElementEORGate(panel, i, j);
        } else
        if(name.equals("R EORGate")) {
            new ElementReverseEORGate(panel, i, j);
        } else

        if(name.equals("FlipFlop")) {
            new ElementFlipFlop(panel, i, j);
        } else
        if(name.equals("R FlipFlop")) {
            new ElementReverseFlipFlop(panel, i, j);
        } else

        if(name.equals("ORGate")) {
            new ElementORGate(panel, i, j);
        } else
        if(name.equals("R ORGate")) {
            new ElementReverseORGate(panel, i, j);
        }
    }

}
