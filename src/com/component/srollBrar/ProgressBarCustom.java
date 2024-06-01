package com.component.srollBrar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author shakthi
 */
public class ProgressBarCustom extends JProgressBar{

    /**
     * @return the Background
     */
    public Color getBackground() {
        return Background;
    }

    /**
     * @param Background the Background to set
     */
    public void setBackground(Color Background) {
        this.Background = Background;
    }

    /**
     * @return the Foreground
     */
    public Color getForeground() {
        return Foreground;
    }

    /**
     * @param Foreground the Foreground to set
     */
    public void setForeground(Color Foreground) {
        this.Foreground = Foreground;
    }

    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color2) {
        this.color1 = color2;
    }
    
    private Color color1 = Color.decode("#00d4ff");
    private Color Background = Color.decode("#00d4ff");
    private Color Foreground = Color.decode("#00d4ff");
    
    public ProgressBarCustom(){
//        setBackground(getBackground());
        setForeground(getForeground());
        setUI(new BasicProgressBarUI(){
            @Override
            protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
                g.setColor(getColor1());
                super.paintString(g, x, y, width, height, amountFull, b);
            }
            
        });
    }

}
