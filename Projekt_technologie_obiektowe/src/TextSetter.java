

import DragClass.ComponentMover;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class TextSetter extends javax.swing.JFrame {


    public TextSetter(Column column1) {
        column=column1;
        initComponents();
    }
    public TextSetter(JPanel jPanel1,Column column1,List<Column> columns) {
        column=column1;
        jPanel=jPanel1;
        columnList=columns;
        initComponents();
    }
    public TextSetter(Table table1) {
        table=table1;
        initComponents();
    }
    public TextSetter(Table table1, JPanel jPanel1, List<Table> tables, ComponentMover componentMover) {
        table=table1;
        jPanel=jPanel1;
        tableList=tables;
        cm=componentMover;
        initComponents();
    }
    public TextSetter(JCheckBoxMenuItem BoxMenu1) {
        BoxMenu=BoxMenu1;
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

        jButton3.setText("Zatwierdz");
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
                if(table!=null)
                    table.setTableName(text);
                if(column!=null&&columnList!=null&&jPanel!=null){
                    column.setName(text);
                    columnList.add(column);
                    jPanel.add(column);
                }
                if(table!=null&&tableList!=null&&jPanel!=null&&cm!=null){
                    table.setTableName(text);
                    tableList.add(table);
                    jPanel.add(table);
                    jPanel.revalidate();
                    jPanel.repaint();
                    cm.registerComponent(table);
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
            message.setText("Brak danych");
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


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        text="";
    }

    private ComponentMover cm;
    private List<Table> tableList;
    private JPanel jPanel;
    private List<Column> columnList;
    private Column column;
    private Table table;
    private JCheckBoxMenuItem BoxMenu;
    private Set<String> keyWords;
    private String text;
    private final Message message = new Message();
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
}
