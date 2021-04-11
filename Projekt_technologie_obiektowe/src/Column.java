/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Mateusz
 */
public class Column extends javax.swing.JPanel {

    /**
     * Creates new form column
     */
    public Column() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        textSetter = new TextSetter();
        Table table = new Table(new MainMenu());
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        PK= new JCheckBoxMenuItem("PRIMARY KEY");
        NotNull= new JCheckBoxMenuItem("NOT NULL");
        Unique= new JCheckBoxMenuItem("UNIQUE");
        Check= new JCheckBoxMenuItem("CHECK");
        Default= new JCheckBoxMenuItem("DEFAULT");


        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHAR(100)", "VARCHAR(100)", "BINARY(100)","TINYBLOB","TINYTEXT","TEXT(100)","BLOB(100)","MEDIUMTEXT","MEDIUMBLOB","LONGTEXT","LONGBLOB",
        "BIT(100)","TINYINT(100)","BOOL","BOOLEAN","SMALLINT(100)","MEDIUMINT(100)","INT(100)","INTEGER(100)","BIGINT(100)","FLOAT(1)","DEC(100, 1)","DATE","DATETIME","TIMESTAMP","YEAR"}));
        final JPopupMenu popup = new JPopupMenu();
        popup.add(PK);
        popup.add(NotNull);
        popup.add(Unique);
        popup.add(Check);
        popup.add(Default);

        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               if(Check.getState()) {
                   textSetter.setLabelName("Podaj parametr check");
                   textSetter.setBoxMenu(Check);
                   textSetter.setVisible(true);
               } else
                   Check.setText("CHECK");
            }
        });
        Default.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(Default.getState()) {
                    textSetter.setLabelName("Podaj parametr Default");
                    textSetter.setBoxMenu(Default);
                    textSetter.setVisible(true);
                } else
                    Default.setText("DEFAULT");
            }
        });


        jButton1.setText("jButton1");
        jButton1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
        );
    }// </editor-fold>

    public void setName(String name1){
        name=name1;
        jLabel1.setText(name1);
    }
    // Variables declaration - do not modify
    private TextSetter textSetter;
    private String name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private JCheckBoxMenuItem PK,NotNull,Unique,Check,Default;
    // End of variables declaration
}
