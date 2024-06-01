/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.component;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author binar
 */
public class NotificatiobIcon extends JButton {

    /**
     * @return the badgeColor
     */
    public Color getBadgeColor() {
        return badgeColor;
    }

    /**
     * @param badgeColor the badgeColor to set
     */
    public void setBadgeColor(Color badgeColor) {
        this.badgeColor = badgeColor;
    }

    private BufferedImage image;
    private Color badgeColor = new Color(220, 67, 67);

    public NotificatiobIcon() {
        setUI(new NotificationIconUI());
        setOpaque(false);
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(10, 11, 10, 11));
        setHorizontalTextPosition(SwingConstants.CENTER);
    }

    private void createImage() {
        if (getIcon() != null) {
            image = new BufferedImage(getIcon().getIconWidth(), getIcon().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();
            g2.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, null);
            g2.dispose();
        } else {
            image = null;
        }
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        super.setIcon(defaultIcon);
        createImage();
    }

    public class NotificationIconUI extends BasicButtonUI {

        @Override
        protected void paintText(Graphics g, JComponent jc, Rectangle textRect, String text) {
            
        }
        
        

        @Override
        protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
            if (image != null && !getText().equals("")) {
                //custom notification icon
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                double size = Math.max(iconRect.getWidth(), iconRect.getHeight()) * 0.7f;
                double x = Math.min(iconRect.getX() + iconRect.getWidth() / 2, c.getWidth()-size);
                double y = Math.max(iconRect.getY()-size / 2, 0);
                Area area = new Area(iconRect);
                area.subtract(new Area(new Ellipse2D.Double(x,y,size,size)));
                g2.setPaint(new TexturePaint(image, iconRect));
                g2.fill(area);
                String text = getText();
                createText(g2, x, y, size, text);
                g2.dispose();
                
            } else {
                super.paintIcon(g, c, iconRect);
            }
        }
        
        private void createText(Graphics2D g2,double x,double y,double size,String text){
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D f2d = fm.getStringBounds(text, g2);
            double space = size * 0.06f;
            double width = Math.max(size - space * 2, f2d.getWidth()+8);
            double heigh = size - space * 2;
            g2.setColor(badgeColor);
            g2.translate(x, y);
            g2.fill(new RoundRectangle2D.Double(space, space, width, heigh, heigh,heigh));
            double fx = ((width - f2d.getWidth()) / 2) + space;
            double fy = ((heigh - f2d.getHeight()) / 2) + space;
            g2.setColor(getForeground());
            g2.drawString(text, (int)fx, (int)fy+fm.getAscent());
        }

    }

}
