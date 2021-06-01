package Graphic;

import javax.swing.*;
import java.awt.*;

public class SwitchColorButton extends JButton {
    SwitchColorButton(Color c){
        super();
        setPreferredSize(new Dimension(30,30));
        setBackground(c);
    }
}
