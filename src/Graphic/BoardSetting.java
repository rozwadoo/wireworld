package Graphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class BoardSetting extends JPanel{

    private JLabel wyborKoloru = new JLabel("Wybierz element");

    protected BoardSettingButton clear = new BoardSettingButton("Clear", this);

    private BoardSettingButton black = new BoardSettingButton("Empty", this);
    private BoardSettingButton orange = new BoardSettingButton("Electron tail", this);
    private BoardSettingButton yellow = new BoardSettingButton("Conductor", this);
    private BoardSettingButton blue = new BoardSettingButton("Electron head", this);

    protected BoardSettingButton andNotGate = new BoardSettingButton("AndNotGate", this);
    protected BoardSettingButton reverseAndNotGate = new BoardSettingButton("R AndNotGate", this);

    protected BoardSettingButton diode = new BoardSettingButton("Diode", this);
    protected BoardSettingButton reverseDiode = new BoardSettingButton("R Diode", this);

    protected BoardSettingButton eORGate = new BoardSettingButton("EORGate", this);
    protected BoardSettingButton rEORGate = new BoardSettingButton("R EORGate", this);

    protected BoardSettingButton flipFlop = new BoardSettingButton("FlipFlop", this);
    protected BoardSettingButton RFlipFlop = new BoardSettingButton("R FlipFlop", this);

    protected BoardSettingButton oRGate = new BoardSettingButton("ORGate", this);
    protected BoardSettingButton rORGate = new BoardSettingButton("R ORGate", this);

    private String nameElement;

    public BoardSetting() {
        setPreferredSize(new Dimension(140,700));
        add(clear);
        add(black);
        add(orange);
        add(yellow);
        add(blue);

        add(andNotGate);
        add(reverseAndNotGate);
        add(diode);
        add(reverseDiode);
        add(eORGate);
        add(rEORGate);
        add(flipFlop);
        add(RFlipFlop);
        add(oRGate);
        add(rORGate);
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public String getNameElement() {
        return nameElement;
    }
}