package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleCell extends JButton implements ActionListener {

    private BoardSetting color;

    SingleCell(BoardSetting a){
        super();
        color = a;
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == this){
            setBackground(color.getSetColor());
        }
    }
}
