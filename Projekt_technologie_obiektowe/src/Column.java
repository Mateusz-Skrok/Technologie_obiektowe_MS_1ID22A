
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;


public class Column extends javax.swing.JPanel {


    public Column(Table table1) {
        initComponents();
        table=table1;
    }



    private void initComponents() {

        relation = new ArrayList<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        PK= new JCheckBoxMenuItem("PRIMARY KEY");
        FK= new JCheckBoxMenuItem("FOREIGN KEY");
        NotNull= new JCheckBoxMenuItem("NOT NULL");
        Unique= new JCheckBoxMenuItem("UNIQUE");
        Check= new JCheckBoxMenuItem("CHECK");
        Default= new JCheckBoxMenuItem("DEFAULT");
        Rename= new JMenuItem("Zmien nazwe");
        Delete= new JMenuItem("Usun");

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"int", "CHAR", "VARCHAR", "BINARY","TINYBLOB","TINYTEXT","TEXT","BLOB(100)","MEDIUMTEXT","MEDIUMBLOB","LONGTEXT","LONGBLOB",
        "BIT(100)","TINYINT(100)","BOOL","BOOLEAN","SMALLINT(100)","MEDIUMINT(100)","INT(100)","INTEGER(100)","BIGINT(100)","FLOAT(1)","DEC(100, 1)","DATE","DATETIME","TIMESTAMP","YEAR"}));
        popup = new JPopupMenu();
        popup.add(PK);
        popup.add(FK);
        popup.add(NotNull);
        popup.add(Unique);
        popup.add(Check);
        popup.add(Default);
        FK.setEnabled(false);

        popup2 = new JPopupMenu();
        popup2.add(Rename);
        popup2.add(Delete);



        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               if(Check.getState()) {
                   TextSetter textSetter= new TextSetter(Check);
                   textSetter.setLabelName("Podaj parametr check");
                   textSetter.setVisible(true);
               } else
                   Check.setText("CHECK");
            }
        });
        Default.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(Default.getState()) {
                    TextSetter textSetter= new TextSetter(Default);
                    textSetter.setLabelName("Podaj parametr Default");
                    textSetter.setVisible(true);
                } else
                    Default.setText("DEFAULT");
            }
        });

        Rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    TextSetter textSetter= new TextSetter(Column.this);
                    textSetter.setLabelName("Podaj nowa nazwe");
                    textSetter.setVisible(true);

            }
        });

        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.getjPanel1().remove(Column.this);
                table.getjPanel1().revalidate();
                table.getjPanel1().repaint();
                table.getColumns().remove(Column.this);
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
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        if(SwingUtilities.isRightMouseButton(evt))
        popup2.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    public void setName(String name1){
        name=name1;
        jLabel1.setText(name1);
    }

    public String getName(){return name;}

    public boolean PKState(){
        return PK.getState();
    }

    public void disablePK(){
        PK.setEnabled(false);
    }

    public void FKChangeState(){
        FK.setState(true);
    }

    public void addRelation(Table table,Column column){
        relation.add(new ArrayList<>(Arrays.asList(table,column)));
    }

    public ArrayList<ArrayList<Object>> getRelation(){
        return relation;
    }

    public boolean[] attributState(){

        boolean[] attributs = new boolean[5];
        attributs[0]=PK.getState();
        attributs[1]=NotNull.getState();
        attributs[2]=Unique.getState();
        attributs[3]=Check.getState();
        attributs[4]=Default.getState();

        return attributs;
    }

    public String getCheckArgument(){

        return Check.getText().substring(Check.getText().indexOf("("),Check.getText().indexOf(")"));
    }

    public String getDefaultArgument(){

        return Default.getText().substring(Default.getText().indexOf("("),Default.getText().indexOf(")"));
    }

    public String getColumType(){
        return jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
    }

    private ArrayList<ArrayList<Object>> relation;
    private Table table;
    private JPopupMenu popup;
    private JPopupMenu popup2;
    private String name;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private JCheckBoxMenuItem PK,NotNull,Unique,Check,Default,FK;
    private JMenuItem Rename,Delete;

}
