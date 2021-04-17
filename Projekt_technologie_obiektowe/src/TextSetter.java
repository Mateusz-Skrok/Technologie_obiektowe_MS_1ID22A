

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class TextSetter extends javax.swing.JFrame {


    public TextSetter() {
        initComponents();
    }

    private void initComponents() {
        keyWords= new HashSet<String>();

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        readFile("keyWords.txt");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton4)
                                        .addComponent(jButton3))
                                .addContainerGap())
        );

        this.setLocationRelativeTo(null);
        pack();
    }

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
        char c=evt.getKeyChar();
        if(c==' '||c=='#'||c==';'||c==':'||c=='@')
            evt.consume();

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        if(!jTextField1.getText().isBlank()) {
            if(!keyWords.contains(jTextField1.getText().toUpperCase())) {
                text =jTextField1.getText().trim();
                jTextField1.setText("");
                this.setVisible(false);
                if(BoxMenu!=null){
                    BoxMenu.setText(BoxMenu.getText()+"("+text+")");
                }
                if(column!=null){
                    column.setName(text);
                }
            }
            else{
                message.setVisible(true);
                message.setText("Uzyto kluczowego slowa");
                text="";
            }
        }
        else {
            message.setVisible(true);
            message.setText("Nie podano nazwy tabeli");
            text="";
        }

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

    public void setLabelName(String string){
        jLabel1.setText(string);
    }

    public String getText() {
        return text;
    }

    public void setBoxMenu(JCheckBoxMenuItem boxMenuItem){
        BoxMenu=boxMenuItem;
    }

    public void setTable(Table table1){
        table=table1;
    }
    public void setColumn(Column column1){
        column=column1;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        text="";
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextSetter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextSetter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextSetter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextSetter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextSetter().setVisible(true);
            }
        });
    }


    private Column column;
    private Table table;
    private JCheckBoxMenuItem BoxMenu;
    private Set<String> keyWords;
    private String text;
    private Message message = new Message();
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
}
