/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gui;

import com.component.srollBrar.ScrollBarCustom;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.gui.homePanal.Branch_Registration;
import com.gui.homePanal.Brand_Registration;
import com.gui.homePanal.Category_Registration;
import com.gui.homePanal.Check_Stock;
import com.gui.homePanal.Company_Registration;
import com.gui.homePanal.Dashoard;
import com.gui.homePanal.Issue_Invoice;
import com.gui.homePanal.Issue_GRN;
import com.gui.homePanal.Issue_Goods_Return_note;
import com.gui.homePanal.Manage_Customers;
import com.gui.homePanal.Manage_Products;
import com.gui.homePanal.Manage_Supliers;
import com.gui.homePanal.Manage_Users;
import com.gui.homePanal.Profile;
import com.gui.homePanal.Salary;
import com.gui.homePanal.View_Previous_Goods_Receive_Notes;
import com.gui.homePanal.View_Previous_Goods_Return_Notes;
import com.gui.homePanal.View_previous_Invoices;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import raven.toast.Notifications;

/**
 *
 * @author shakthi
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home(String ad_id,String fname,String lname,String contact ) {
        initComponents();
        ScrollBar();
        Event();
        showForm(new Dashoard());
        date();
        time();
        HedearIconSet();
        jScrollPane1.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        jLabel4.setText(fname +" "+ lname);
        jLabel7.setText(fname +" "+ lname);
    }

    private void HedearIconSet() {
        Image icon = new ImageIcon(this.getClass().getResource("/com/res/logo1.png")).getImage();
        this.setIconImage(icon);
    }

    private void Event() {
        menu2.setEvent((int index, int subItem) -> {
            switch (index) {
                case 0 -> {
                    showForm(new Dashoard());
                    jLabel9.setText("D a s h b o a r d");
                    Font();
                }
                case 1 -> {
                    showForm(new Salary());
                    jLabel9.setText("S a l a r y");
                    Font();
                }
                case 2 -> {
                    showForm(new Manage_Customers());
                    jLabel9.setText("M a n a g e  C u s t o m e r s");
                    Font();
                }
                case 3 -> {
                    showForm(new Manage_Users());
                    jLabel9.setText("M a n a g e  U s e r s");
                    Font();
                }
                case 4 -> {
                    showForm(new Manage_Products());
                    jLabel9.setText("M a n a g e  P r o d u c t s");
                    Font();
                }
                case 5 -> {
                    showForm(new Brand_Registration());
                    jLabel9.setText("B r a n d  R e g i s t r a t i o n");
                    Font();
                }
                case 6 -> {
                    showForm(new Category_Registration());
                    jLabel9.setText("C a t e g o r y  R e g i s t r a t i o n");
                    Font();
                }
                case 7 -> {
                    showForm(new Manage_Supliers());
                    jLabel9.setText("M a n a g e  S u p p l i e r s");
                    Font();
                }
                case 8 -> {
                    showForm(new Company_Registration());
                    jLabel9.setText("C o m p a n y  R e g i s t r a t i o n");
                    Font();
                }
                case 9 -> {
                    showForm(new Branch_Registration());
                    jLabel9.setText("B r a n c h  R e g i s t r a t i o n");
                    Font();
                }
                case 10 -> {
                    showForm(new Check_Stock());
                    jLabel9.setText("C h e c k  S t o c k");
                    Font();
                }
                case 11 -> {
                    switch (subItem) {
                        case 1 -> {
                            showForm(new Issue_GRN());
                            jLabel9.setText("I s s u e  G R N");
                            Font();
                        }case 2 -> {
                            showForm(new View_Previous_Goods_Receive_Notes());
                            jLabel9.setText("V i e w  P r e v i o u s  G o o d s  R e c e i v e  N o t e s");
                            Font();
                        }
                    }
                }
                case 12 -> {
                    switch (subItem) {
                        case 1 -> {
                            showForm(new Issue_Goods_Return_note());
                            jLabel9.setText("I s s u e  G o o d s  R e t u r n  n o t e");
                            Font();
                        }case 2 -> {
                            showForm(new View_Previous_Goods_Return_Notes());
                            jLabel9.setText("V i e w  P r e v i o u s  G o o d s  R e t u r n  N o t e s");
                            Font();
                        }
                    }
                }
                case 13 -> {
                    switch (subItem) {
                        case 1 -> {
                            showForm(new Issue_Invoice());
                            jLabel9.setText("I s s u e  I n v o i c e");
                            Font();
                        }case 2 -> {
                            showForm(new View_previous_Invoices());
                            jLabel9.setText("V i e w  p r e v i o u s  I n v o i c e s");
                            Font();
                        }
                    }
                }
                case 14 -> {
                   showForm(new Profile());
                            jLabel9.setText("P r o f i l e");
                            Font();
                }
                case 15 -> {
//                    Notifications.getInstance().show(Notifications.Type.);
                }
                default -> {
                    System.out.println("ok");
                }
            }
        });
    }

    private void showForm(Component com) {
        panelRound2.removeAll();
        panelRound2.add(com);
        panelRound2.repaint();
        panelRound2.revalidate();
    }

    private void Font() {
        jLabel9.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(114, 114, 114));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    private void ScrollBar() {
        ScrollBarCustom scrollBarCustom = new ScrollBarCustom();

        scrollBarCustom.setOpaque(true);
//        scrollBarCustom.setBackground(Color.red);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom);
    }

    private void date() {
        DateTimeFormatter dates = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        jLabel2.setText("Today" + " " + dates.format(now));
    }

    Timer t;
    SimpleDateFormat st;

    private void time() {

        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");

                String tt = st.format(dt);
                jLabel8.setText(tt);
            }

        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new com.component.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu2 = new com.component.menu.Menu();
        panelRound2 = new com.component.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textField1 = new com.component.TextField();
        panelRound3 = new com.component.PanelRound();
        notificatiobIcon1 = new com.component.NotificatiobIcon();
        notificatiobIcon2 = new com.component.NotificatiobIcon();
        notificatiobIcon3 = new com.component.NotificatiobIcon();
        notificatiobIcon4 = new com.component.NotificatiobIcon();
        panelRound4 = new com.component.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        frofileImageRounded1 = new com.component.FrofileImageRounded();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A  Z  U  T  I  N  E      G  R  O  W  T  H      U  P");

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Logo.png"))); // NOI18N

        panelRound1.setBackground(new java.awt.Color(244, 244, 244));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Today 2023-09-08");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        menu2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(menu2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(4, 4, 4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundTopLeft(30);
        panelRound2.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(22, 22, 22));
        jLabel3.setText("Welcome Back");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(90, 90, 90));
        jLabel4.setText("Shakthi Binaramal");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-windows-11-48.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(114, 114, 114));
        jLabel8.setText("09:30:06 PM");

        jLabel9.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(114, 114, 114));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("D a s h b o a r d");

        jLabel10.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(114, 114, 114));
        jLabel10.setText("ENG");

        jLabel11.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(114, 114, 114));
        jLabel11.setText("UTF - 8");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-redo-18.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-bell-18.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-warning-18.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(437, 437, 437)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addGap(243, 243, 243)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        textField1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        textField1.setHintText("Search");
        textField1.setSeticon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-search-32.png"))); // NOI18N
        textField1.setShowicon(true);

        panelRound3.setBackground(new java.awt.Color(255, 149, 0));
        panelRound3.setRoundBottomLeft(40);
        panelRound3.setRoundBottomRight(40);
        panelRound3.setRoundTopLeft(40);
        panelRound3.setRoundTopRight(40);

        notificatiobIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-bell-28 (1).png"))); // NOI18N
        notificatiobIcon1.setText("99");
        notificatiobIcon1.setBadgeColor(new java.awt.Color(255, 51, 51));
        notificatiobIcon1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        notificatiobIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-power-28.png"))); // NOI18N

        notificatiobIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-setting-28.png"))); // NOI18N

        notificatiobIcon4.setBorder(null);
        notificatiobIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-exit-28.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(notificatiobIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notificatiobIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notificatiobIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notificatiobIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notificatiobIcon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notificatiobIcon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notificatiobIcon3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notificatiobIcon4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(40);
        panelRound4.setRoundBottomRight(40);
        panelRound4.setRoundTopLeft(40);
        panelRound4.setRoundTopRight(40);

        jLabel7.setFont(new java.awt.Font("Serif", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(90, 90, 90));
        jLabel7.setText("Shakthi Binaramal");

        frofileImageRounded1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/ProfileImage/Profile1.jpeg"))); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(frofileImageRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(frofileImageRounded1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBorder(null);

        jMenu1.setText("File");
        jMenu1.setPreferredSize(new java.awt.Dimension(44, 22));

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-add-folder-15.png"))); // NOI18N
        jMenuItem1.setText("New Product");
        jMenuItem1.setToolTipText("");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-add-file-15.png"))); // NOI18N
        jMenuItem2.setText("New File");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-opened-folder-15.png"))); // NOI18N
        jMenuItem3.setText("Open Folder");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Save");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Save As...");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Select All");
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator2);

        jMenuItem7.setText("Exit");
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setPreferredSize(new java.awt.Dimension(46, 22));

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-undo-15.png"))); // NOI18N
        jMenuItem8.setText("Undo");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-redo-15.png"))); // NOI18N
        jMenuItem9.setText("Redo");
        jMenu2.add(jMenuItem9);
        jMenu2.add(jSeparator3);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-cut-15.png"))); // NOI18N
        jMenuItem10.setText("Cut");
        jMenu2.add(jMenuItem10);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-copy-15.png"))); // NOI18N
        jMenuItem12.setText("Copy");
        jMenu2.add(jMenuItem12);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-paste-15.png"))); // NOI18N
        jMenuItem11.setText("Paste");
        jMenu2.add(jMenuItem11);
        jMenu2.add(jSeparator4);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/icons8-trash-15.png"))); // NOI18N
        jMenuItem13.setText("Delete");
        jMenu2.add(jMenuItem13);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");
        jMenu3.setPreferredSize(new java.awt.Dimension(51, 22));

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Ligth.png"))); // NOI18N
        jMenuItem14.setText("Light");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Dark.png"))); // NOI18N
        jMenuItem15.setText("Dark");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tools");
        jMenu4.setPreferredSize(new java.awt.Dimension(54, 22));
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Account");
        jMenu5.setPreferredSize(new java.awt.Dimension(71, 22));
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Help");
        jMenu6.setPreferredSize(new java.awt.Dimension(51, 22));

        jMenuItem16.setText("About");
        jMenu6.add(jMenuItem16);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Exit");
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        FlatMacLightLaf.setup();
        FlatLaf.updateUI();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        FlatMacDarkLaf.setup();
        FlatLaf.updateUI();
    }//GEN-LAST:event_jMenuItem15ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.component.FrofileImageRounded frofileImageRounded1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private com.component.menu.Menu menu2;
    private com.component.NotificatiobIcon notificatiobIcon1;
    private com.component.NotificatiobIcon notificatiobIcon2;
    private com.component.NotificatiobIcon notificatiobIcon3;
    private com.component.NotificatiobIcon notificatiobIcon4;
    private com.component.PanelRound panelRound1;
    private com.component.PanelRound panelRound2;
    private com.component.PanelRound panelRound3;
    private com.component.PanelRound panelRound4;
    private com.component.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
