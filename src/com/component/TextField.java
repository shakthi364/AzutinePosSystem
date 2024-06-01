package com.component;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextField extends JTextField {

    public boolean isShowicon() {
        return showicon;
    }

    public void setShowicon(boolean showicon) {
        this.showicon = showicon;
        repaint();
    }

    private Icon seticon;
    private String hintText = "";
    private boolean showicon;

    public TextField() {
        setBorder(new EmptyBorder(10, 10, 10, 10)); //set Right Border 50
        setOpaque(false);
        setSelectionColor(new Color(80, 199, 255));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seticon = new ImageIcon(getClass().getResource("/com/res/user_icon.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, height, height);
        super.paintComponent(g);

        //creact Icon
        if (isShowicon()) {

            setBorder(new EmptyBorder(10, 40, 10, 10)); //set Right Border 50
            int marginButton = 5;
            int buttonSize = height - marginButton * 2;

            int marginImage = 5;
            int imageSize = buttonSize - marginImage * 2;
            Image image = ((ImageIcon) getSeticon()).getImage();
            g2.drawImage(image, 10, marginButton + marginImage, imageSize, imageSize, null);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(getHintText(), ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

    public Icon getSeticon() {
        return seticon;
    }

    public void setSeticon(Icon seticon) {
        this.seticon = seticon;
        repaint();
    }

    /**
     * @return the hintText
     */
    public String getHintText() {
        return hintText;
    }

    /**
     * @param hintText the hintText to set
     */
    public void setHintText(String hintText) {
        this.hintText = hintText;
        repaint();
    }

}
