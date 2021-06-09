package Graphic;

import java.awt.Dimension;
import javax.swing.JPanel;


public class BoardSetting extends JPanel{

    private final BoardSettingButton red = new BoardSettingButton("Electron tail", this);
    private final BoardSettingButton yellow = new BoardSettingButton("Conductor", this);
    private final BoardSettingButton blue = new BoardSettingButton("Electron head", this);
    private final BoardSettingButton andNotGate = new BoardSettingButton("AndNotGate", this);
    private final BoardSettingButton reverseAndNotGate = new BoardSettingButton("R AndNotGate", this);
    private final BoardSettingButton diode = new BoardSettingButton("Diode", this);
    private final BoardSettingButton reverseDiode = new BoardSettingButton("R Diode", this);
    private final BoardSettingButton eORGate = new BoardSettingButton("EORGate", this);
    private final BoardSettingButton rEORGate = new BoardSettingButton("R EORGate", this);
    private final BoardSettingButton flipFlop = new BoardSettingButton("FlipFlop", this);
    private final BoardSettingButton RFlipFlop = new BoardSettingButton("R FlipFlop", this);
    private final BoardSettingButton oRGate = new BoardSettingButton("ORGate", this);
    private final BoardSettingButton rORGate = new BoardSettingButton("R ORGate", this);
    private String nameElement;

    public BoardSetting() {

        setPreferredSize(new Dimension(140,700));

        add(red);
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