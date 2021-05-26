package Graphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class BoardSetting extends JPanel implements ActionListener {

    protected JSlider suwak = new JSlider(10, 50, 30);
    protected JTextField pole = new JTextField("30", 4);
    protected JButton accept = new JButton("Zatwierdź");

    private JLabel wyborKoloru = new JLabel("Wybierz element");
    private SwitchColorButton black = new SwitchColorButton(Color.BLACK);
    private SwitchColorButton orange = new SwitchColorButton(Color.ORANGE);
    private SwitchColorButton yellow = new SwitchColorButton(Color.yellow);
    private SwitchColorButton blue = new SwitchColorButton(Color.blue);

    private Color setColor;

    public BoardSetting() {
        setColor = black.getBackground();
        setPreferredSize(new Dimension(140,700));
        add(wyborKoloru);
        wyborKoloru.setPreferredSize(new Dimension(140,30));
        add(black);
        add(orange);
        add(yellow);
        add(blue);
        black.addActionListener(this);
        orange.addActionListener(this);
        yellow.addActionListener(this);
        blue.addActionListener(this);

    }

    public Color getSetColor() {
        return setColor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == black){
            setColor = black.getBackground();
        }
        if(source == orange){
            setColor = orange.getBackground();
        }
        if(source == yellow){
            setColor = yellow.getBackground();
        }
        if(source == blue){
            setColor = blue.getBackground();
        }
    }
}