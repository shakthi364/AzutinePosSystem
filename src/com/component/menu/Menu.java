package com.component.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author shakthi
 */
public class Menu extends JComponent{

    /**
     * @return the event
     */
    public MenuEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(MenuEvent event) {
        this.event = event;
    }
    
    private MenuEvent event;
    private MigLayout layout;
    private String[][] menuItems = new String[][]{
        {"Dashboard"},
        {"Salary"},
        {"Manage Customers"},
        {"Manage Users"},
        {"Manage Product"},
        {"Brand Registration"},
        {"Category Registration"},
        {"Manage Suppliers"},
        {"Company Registration"},
        {"Branch Registration"},
        {"Check Stock"},
        {"Good Receive Note","Issue GRN","Viwe Previous Notes"},
        {"Good Return Note","Issue Good Return Notes","Viwe Previous Notes"},
        {"Invoice","Issue Invoice","View Previous Invoices"},
        {"Profile"},
        {"Exit"},
    };
    
    public Menu(){
        init();
        setOpaque(false);
        
    }
    
    private void init(){
        layout = new MigLayout("wrap 1,fillx,gapy 0,inset 2","fill");
        setLayout(layout);
        setOpaque(true);
        
        // Init MenuItem
        for(int i = 0; i<menuItems.length;i++){
            addMenu(menuItems[i][0], i);
        }
    }
    
    private Icon getIcon(int index){
        URL url = getClass().getResource("/com/res/menuIcon/"+index+".png");
        if(url != null){
            return new ImageIcon(url);
        }else{
            return null;
        }
    }
    
    private void addMenu(String MenuName,int index){
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(MenuName, index, length>1);
        Icon icon = getIcon(index);
        if(icon != null){
            item.setIcon(icon);
        }
        
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(length>1){
                    if(!item.isSelected()){
                        //menu show
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    }else{
                        // menu hide
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                }else{
                    if(event != null){
                        event.selected(index, 0);
                    }
                }
            }
        });
        add(item);
        revalidate();
        repaint();
    }
    
    private void addSubMenu(MenuItem item,int index,int length,int indexZorder){
        JPanel panal = new JPanel(new MigLayout("wrap 1,fillx,inset 0,gapy 0","fill"));
        panal.setName(index+"");
        panal.setOpaque(false);
        for(int i = 1; i < length;i++){
            MenuItem subItem = new MenuItem(menuItems[index][i],i, false);
            
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(event != null){
                        event.selected(index, subItem.getIndex());
                    }
                }
            });
            
            subItem.initSubMenu(i, length);
            panal.add(subItem);
        }
        add(panal,"h 0!",indexZorder+1);
        revalidate();
        repaint();
        MenuAnimation.showmenu(panal, item, layout, true);
    }
    
    private void hideMenu(MenuItem item,int index){
        for(Component com:getComponents()){
            if(com instanceof JPanel && com.getName()!=null && com.getName().equals(index+"")){
                com.setName(null);
                MenuAnimation.showmenu(com, item, layout, false);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fill(new Rectangle2D.Double(0,0,getWidth(),getHeight()));
        
        super.paintComponent(g);
    }
    
    
    
}
