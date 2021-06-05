package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardSettingButton extends JButton implements ActionListener {

    private final BoardSetting boardSetting;

    BoardSettingButton(String s, BoardSetting a){
        super(s);
        boardSetting = a;
        addActionListener(this);
        setPreferredSize(new Dimension(140,30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == this){
            boardSetting.setNameElement(this.getText());
        }
    }
}
