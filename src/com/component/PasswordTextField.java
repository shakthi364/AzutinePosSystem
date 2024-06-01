package com.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class PasswordTextField extends JPasswordField {

    public Color getAnimationColor() {
        return animationColor;
    }

    public void setAnimationColor(Color animationColor) {
        this.animationColor = animationColor;
    }

    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }
    
    public boolean isShowAndHide() {
        return showAndHide;
    }

    public void setShowAndHide(boolean showAndHide) {
        this.showAndHide = showAndHide;
        repaint();
    }

    private Color animationColor = new Color(3, 175, 255);
    private final Image iconeyeview;
    private final Image iconeyehide;
    private final Icon iconlockicon;
    private boolean hide = true;
    private String hintText = "Enter Your Password";
    private boolean showAndHide;

    public PasswordTextField() {
        setBackground(getBackground());
        setOpaque(false);
        setBorder(new EmptyBorder(10, 40, 10, 40));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        iconeyeview = new ImageIcon(getClass().getResource("/com/res/eye_view_icon.png")).getImage();
        iconeyehide = new ImageIcon(getClass().getResource("/com/res/eye_hide_view_icon.png")).getImage();
        iconlockicon = new ImageIcon(getClass().getResource("/com/res/lock_icon.png"));

        // Create and check if mouse over button
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(showAndHide){
                    if (checkMouseOver(e.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
                }
            }
        });

        //Creat Button Click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(showAndHide){
                    if (SwingUtilities.isLeftMouseButton(e)) {
                    if (checkMouseOver(e.getPoint())) {
                        hide = !hide;
                        if (hide) {
                            setEchoChar('\u2022');
                        } else {
                            setEchoChar((char) 0);
                        }
                        repaint();
                    }
                }
                }
            }

        });
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

        // Create Button
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        if(showAndHide){
        GradientPaint gra = new GradientPaint(0, 0, new Color(255, 255, 255), width, 0, getAnimationColor());
        g2.setPaint(gra);
        g2.fillOval(width - height + 3, marginButton, buttonSize, buttonSize);
        }

        // Create Button Icon
        int marginImage = 5;
        int imageSize = buttonSize - marginImage * 2;
        if(showAndHide){
        g2.drawImage(hide ? iconeyehide:iconeyeview, width - height + marginImage + 3, marginButton + marginImage, imageSize, imageSize, null);
        }

        //creact left Icon
        Image lockicon = ((ImageIcon) iconlockicon).getImage();
        g2.drawImage(lockicon, 10, marginButton + marginImage, imageSize, imageSize, null);
        g2.dispose();
    }

//    private void creatShowHide(Graphics2D g3) {
//        int x = getWidth();
//        int y = getHeight();
//        g3.drawImage(hide ? iconeyehide:iconeyeview, x,y,null);
//    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (String.valueOf(getPassword()).length() == 0) {
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

    private boolean checkMouseOver(Point mouse) {
        int width = getWidth();
        int height = getHeight();
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 3, marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }

}
