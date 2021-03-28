
import DragClass.ComponentMover;
import DragClass.DragLayout;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;


public class MainMenu extends javax.swing.JFrame {


    public MainMenu() {
        initComponents();
    }



    private void initComponents() {
        cm = new ComponentMover();
        cm.setEdgeInsets( new Insets(-100, -100, -100, -100) );
        cm.setAutoLayout(true);
        message =  new Message();
        keyWords= new HashSet<String>();

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel(new DragLayout());
        jButton2 = new javax.swing.JButton();


        readFile("keyWords.txt");
        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setMinimumSize(new java.awt.Dimension(334, 160));
        jDialog1.setSize(new java.awt.Dimension(334, 160));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Podaj nazwe tabeli");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton3.setText("Utworz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Anuluj");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(54, 54, 54))
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addGap(20, 20, 20))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jPanel2);

        jButton2.setText("Wyczysc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addGap(0, 387, Short.MAX_VALUE))
                                        .addComponent(jScrollPane2))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jDialog1.setVisible(true);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Table panle = new Table(this);
        if(!jTextField1.getText().isBlank()) {
            if(!keyWords.contains(jTextField1.getText().toUpperCase())) {
                panle.setName(jTextField1.getText().trim());
                jTextField1.setText("");
                jPanel2.add(panle);
                cm.registerComponent(panle);
                jDialog1.setVisible(false);
            }
            else{
                message.setVisible(true);
                message.setText("Uzyto kluczowego slowa");
            }
        }
        else {
            message.setVisible(true);
            message.setText("Nie podano nazwy tabeli");
        }
    }

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
        char c=evt.getKeyChar();
        if(c==' '||c=='#'||c==';'||c==':'||c=='@')
            evt.consume();

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
       jDialog1.setVisible(false);
    }

    void readFile(String fileName) {
        try {
            Scanner textFile = new Scanner(new File(fileName));

            while (textFile.hasNext()) {
                keyWords.add(textFile.next().trim());
            }

            textFile.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public javax.swing.JPanel getjPanel2(){
        return jPanel2;
    }
    public Set<String> getKeyWords(){ return keyWords;}

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    private Set<String> keyWords;
    private  Message message;
    private ComponentMover cm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;


}
