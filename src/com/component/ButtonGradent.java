package com.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ButtonGradent extends JButton {

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1 = Color.decode("#020024");
    private Color color2 = Color.decode("#00d4ff");
    private boolean button3DView;
    private boolean button3DViewAnimation;
    private final Timer time;
    private final Timer timerPressed;
    private float alpha = 0.3f;
    private boolean mouseOver;
    
    private boolean pressed;
    private Point pressedlocation;
    private float pressedSize;
    private float sizeSpeed = 10f;
    private float alphaPressed = 0.5f;

    public ButtonGradent() {
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10, 20, 10, 20));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                time.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                time.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressedSize = 0;
                alphaPressed= 0.5f;
                pressed = true;
                pressedlocation = e.getPoint();
                timerPressed.setDelay(0);
                timerPressed.start();
            }
        });

        time = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mouseOver) {
                    if (alpha < 0.6f) {
                        alpha += 0.05f;
                        repaint();
                    } else {
                        alpha = 0.6f;
                        time.stop();
                        repaint();
                    }
                } else {
                    if (alpha > 0.3f) {
                        alpha -= 0.05f;
                        repaint();
                    } else {
                        alpha = 0.3f;
                        time.stop();
                        repaint();
                    }
                }
            }
        });
        
        timerPressed = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedSize += sizeSpeed;
                if(alphaPressed <= 0){
                    pressed = false;
                    timerPressed.stop();
                }else{
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create Gradient Color
        GradientPaint gra = new GradientPaint(0, 0, getColor1(), width, 0, getColor2());
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, height, height);

        // Add Style
        if (button3DView) {
            createStyle(g2);
        }
        
        if(pressed){
            painPressed(g2);
        }
        g2.dispose();
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    private void createStyle(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        int width = getWidth();
        int height = getHeight();
        GradientPaint gra = new GradientPaint(0, 0, Color.WHITE, 0, height, new Color(255, 255, 255, 60));
        g2.setPaint(gra);
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 0);
        int controll = height + height / 2;
        f.curveTo(0, 0, width / 2, controll, width, 0);
        g2.fill(f);
    }
    
    private void painPressed(Graphics2D g2){
        if(pressedlocation.x - (pressedSize / 2) < 0 && pressedlocation.x + (pressedSize / 2) > getWidth()){
            timerPressed.setDelay(20);
            alphaPressed -= 0.05f;
            if(alphaPressed < 0){
                alphaPressed = 0;
            }
        }
        g2.setColor(Color.WHITE);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed));
        float x = pressedlocation.x - (pressedSize / 2);
        float y = pressedlocation.y - (pressedSize / 2);
        g2.fillOval((int)x, (int)y, (int)pressedSize, (int)pressedSize);
    }

    public boolean isButton3DView() {
        return button3DView;
    }

    public void setButton3DView(boolean button3DView) {
        this.button3DView = button3DView;
    }

}
