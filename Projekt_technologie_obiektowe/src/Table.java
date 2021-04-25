import Connector.JConnector;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Table extends javax.swing.JPanel {


    public Table(MainMenu jFrame) {
        frame=jFrame;
        initComponents();
    }

    private void initComponents() {

        message = new Message();
        columns=new ArrayList<Column>();
        relation = new ArrayList<JConnector>();


        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();


        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });

        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Usun");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE))
                        .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)))
        );
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Column column = new Column(this);
        TextSetter textSetter = new TextSetter(jPanel1,column,columns);
        textSetter.setLabelName("Podaj nazwe atrybutu");
        textSetter.setVisible(true);

    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.getjPanel2().remove(this);
        frame.getTables().remove(this);
        for (JConnector jConnector : relation)
        frame.getjPanel2().remove(jConnector);
        frame.getjPanel2().revalidate();
        frame.getjPanel2().repaint();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        TextSetter textSetter = new TextSetter(this);
        textSetter.setLabelName("Zmien nazwe tabeli");
        textSetter.setVisible(true);

    }

    public void setName2(String name){
        jLabel1.setText(name);
        tableName =name;
        this.setName(name);
    }

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {
        frame.getjPanel2().revalidate();
        frame.getjPanel2().repaint();
    }

    public javax.swing.JLabel getjLabel1(){
        return this.jLabel1;
    }
    public javax.swing.JPanel getjPanel1(){
        return jPanel1;
    }
    public String getTableName(){return tableName;}
    public List<Column> getColumns() {
        return columns;
    }

    public List<JConnector> getRelation() {
        return relation;
    }

    private List<JConnector> relation;
    private List<Column> columns;
    private Message message;
    private String tableName;
    private MainMenu frame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;

}
