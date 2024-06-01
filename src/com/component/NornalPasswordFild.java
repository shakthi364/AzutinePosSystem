/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.component;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Currency;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 *
 * @author binar
 */
public class NornalPasswordFild extends JPasswordField{
    
    private final Image eye;
    private final Image eye_hide;
    private boolean hide = true;
    
    public NornalPasswordFild(){
        
        setMargin(new Insets(2, 6, 2, 24));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = getWidth() -30;
                if(new Rectangle(x,0,30,30).contains(e.getPoint())){
                    hide = !hide;
                    if(hide){
                        setEchoChar('\u2022');
                    }else{
                        setEchoChar((char)0);
                    }
                    repaint();
                }
            }
            
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
            int x = getWidth()-24;
                if(new Rectangle(x,0,30,30).contains(e.getPoint())){
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }else{
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            }
            
            
        });
        
        eye = new ImageIcon(getClass().getResource("/com/res/icons8-eye-16.png")).getImage();
        eye_hide = new ImageIcon(getClass().getResource("/com/res/icons8-hide-16.png")).getImage();
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        createShowHide(g2);
    }
    
    
    
    private void createShowHide(Graphics2D g2){
        int x = getWidth() - 30 +5;
        int y = (getHeight() - 16) /2 ;
        g2.drawImage(hide?eye_hide:eye, x, y,null);
    }
    
}
