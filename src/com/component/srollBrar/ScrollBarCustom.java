package com.component.srollBrar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setOpaque(true);
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(4, 5));
        setForeground(new Color(255,149,0));
        setBackground(new Color(245,245,245));
        setUnitIncrement(20);
//        setOpaque(false);
    }

}
