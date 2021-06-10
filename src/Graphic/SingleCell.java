package Graphic;

import Graphic.Element.AndNotGate;
import Graphic.Element.Diode;
import Graphic.Element.EORGate;
import Graphic.Element.ORGate;
import Graphic.Element.FlipFlop;
import mapa.Structure;

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

        switch (name) {
            case "Electron tail" -> {
                this.setBackground(Color.RED);
                board.addTextLine("ElectronTail", i, j);
            }
            case "Conductor" -> {
                this.setBackground(Color.YELLOW);
                board.addTextLine("Conductor", i, j);
            }
            case "Electron head" -> {
                this.setBackground(Color.BLUE);
                board.addTextLine("ElectronHead", i, j);
            }

            case "AndNotGate" -> {
                new AndNotGate(cell, i - 3, j).normal();
                board.addTextLine("AndNotGate", i, j, "Normal");
                Structure n = new mapa.AndNotGate(i, j, "Normal");
                board.getLoE().put(n.getStart(), n);
            }
            case "R AndNotGate" -> {
                new AndNotGate(cell, i - 3, j).normal();
                board.addTextLine("AndNotGate", i, j, "Reversed");
                Structure n = new mapa.AndNotGate(i, j , "Reversed");
                board.getLoE().put(n.getStart(), n);
            }

            case "Diode" -> {
                new Diode(cell, i - 1, j).normal();
                board.addTextLine("Diode", i, j, "Normal");
                Structure n = new mapa.Diode(i, j, "Normal");
                board.getLoE().put(n.getI(), n);
            }
            case "R Diode" -> {
                new Diode(cell, i - 1, j).reverse();
                board.addTextLine("Diode", i, j, "Reversed");
                Structure n = new mapa.Diode(i, j , "Reversed");
                board.getLoE().put(n.getI(), n);
            }

            case "EORGate" -> {
                new EORGate(cell, i - 3, j).normal();
                board.addTextLine("EORGate", i, j, "Normal");
                Structure n = new mapa.EORGate(i, j, "Normal");
                board.getLoE().put(n.getStart(), n);
            }
            case "R EORGate" -> {
                new EORGate(cell, i - 3, j).reverse();
                board.addTextLine("EORGate", i, j, "Reversed");
                Structure n = new mapa.EORGate(i, j, "Reversed");
                board.getLoE().put(n.getStart(), n);
            }

            case "FlipFlop" -> {
                new FlipFlop(cell, i - 4, j).normal();
                board.addTextLine("FlipFlop", i, j, "Normal");
                Structure n = new mapa.FlipFlop(i, j, "Normal");
                board.getLoE().put(n.getStart(), n);
            }
            case "R FlipFlop" -> {
                new FlipFlop(cell, i - 4, j).reverse();
                board.addTextLine("FlipFlop", i, j, "Reversed");
                Structure n = new mapa.FlipFlop(i, j, "Reversed");
                board.getLoE().put(n.getStart(), n);
            }

            case "ORGate" -> {
                new ORGate(cell, i - 2, j).normal();
                board.addTextLine("ORGate", i, j, "Normal");
                Structure n = new mapa.ORGate(i, j, "Normal");
                board.getLoE().put(n.getStart(), n);
            }
            case "R ORGate" -> {
                new ORGate(cell, i - 2, j).reverse();
                board.addTextLine("ORGate", i, j, "Reversed");
                Structure n = new mapa.ORGate(i, j, "Reversed");
                board.getLoE().put(n.getStart(), n);
            }
        }
    }
}
