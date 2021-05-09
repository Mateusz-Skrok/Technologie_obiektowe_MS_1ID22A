
import Connector.JConnector;
import DragClass.ComponentMover;
import DragClass.DragLayout;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

import static Connector.ConnectLine.LINE_ARROW_DEST;
import static Connector.ConnectLine.LINE_ARROW_NONE;


public class MainMenu extends javax.swing.JFrame {


    public MainMenu() {
        initComponents();
    }



    private void initComponents() {

        sqlCodeWindow = new SqlCodeWindow();
        cm = new ComponentMover();
        cm.setEdgeInsets( new Insets(0, 0, -100, -100) );
        cm.setAutoLayout(true);
        tables =new ArrayList<Table>();
        message =  new Message();

        jDialog2 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel(new DragLayout());
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setVerifyInputWhenFocusTarget(false);

        jLabel3.setText("Tabela");


        jButton8.setText("Anuluj");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton9.setText("Utworz");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jLabel4.setText("Atrybut");

        jLabel5.setText("Tabela1");

        jLabel6.setText("Tabela2");

        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jComboBox1ItemChange(e);
            }
        });
        jComboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jComboBox2ItemChange(e);
            }
        });

        jDialog2.setLocationRelativeTo(null);
        jDialog2.setSize(new java.awt.Dimension(400, 225));

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialog2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)))
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                .addComponent(jButton8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton9))
                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel3)))
                                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addGap(38, 38, 38))
                                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jComboBox3, 0, 115, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton8)
                                        .addComponent(jButton9))
                                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }

        });
        jScrollPane2.setViewportView(jPanel2);

        jButton2.setText("Wyczysc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("1_do_w");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton6.setText("1_do_1");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton7.setText("w_do_w");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton10.setText("SQL ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(12, 12, 12))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10)
                                .addGap(61, 61, 61)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        this.setExtendedState(MAXIMIZED_BOTH);
    }



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Table table = new Table(this);
        TextSetter textSetter = new TextSetter(table,jPanel2, tables,cm);
        textSetter.setLabelName("Nazwa tabeli");
        textSetter.setVisible(true);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        tables.clear();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox();
        if(jComboBox1.getItemCount()!=0)
        loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1,0);
        if(jComboBox2.getItemCount()!=0)
        loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2,0);
        jDialog2.setVisible(true);
        jLabel2.setText("Jeden do wielu");

    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox();
        if(jComboBox1.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1,1);
        if(jComboBox2.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2,1);
        jDialog2.setVisible(true);
        jLabel2.setText("Jeden do jednego");

    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox();
        if(jComboBox1.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1,2);
        if(jComboBox2.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2,2);
        jDialog2.setVisible(true);
        jLabel2.setText("Wielu do wielu");

    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        jDialog2.setVisible(false);

    }


    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {

        Table table1= searchTable(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
        Table table2= searchTable(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
        JConnector connectLine,connectLine2;
        if(table1!=null&&table2!=null&&table1!=table2) {
            if(jLabel2.getText().equals("Jeden do wielu")) {
                connectLine = new JConnector(table2, table1, LINE_ARROW_DEST, Color.BLACK);
                Column column = searchColumn(jComboBox3.getItemAt(jComboBox3.getSelectedIndex()),table1);
                Column column2 = searchColumn(jComboBox4.getItemAt(jComboBox4.getSelectedIndex()),table2);
                column.FKChangeState();
                column.addRelation(table2,column2);
                column2.disablePK();
            }
            else if(jLabel2.getText().equals("Jeden do jednego")) {
                connectLine = new JConnector(table1, table2, LINE_ARROW_NONE, Color.BLACK);
                Column column = searchColumn(jComboBox3.getItemAt(jComboBox3.getSelectedIndex()),table1);
                Column column2 = searchColumn(jComboBox4.getItemAt(jComboBox4.getSelectedIndex()),table2);
                column.FKChangeState();
                column.addRelation(table2,column2);
                column2.disablePK();

            }
            else {
                Table panle = new Table(this);
                        panle.setName2(jComboBox1.getItemAt(jComboBox1.getSelectedIndex())+"_"+jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
                        Column column = new Column(panle);
                        Column column1 = new Column(panle);
                        column.setName(jComboBox1.getItemAt(jComboBox1.getSelectedIndex())+"_id");
                        column1.setName(jComboBox2.getItemAt(jComboBox2.getSelectedIndex())+"_id");
                        Column columnTable1 = searchColumn(jComboBox3.getItemAt(jComboBox3.getSelectedIndex()),table1);
                        Column columnTable2 = searchColumn(jComboBox4.getItemAt(jComboBox4.getSelectedIndex()),table2);
                        column.FKChangeState();
                        column1.FKChangeState();
                        panle.getColumns().add(column);
                        panle.getColumns().add(column1);
                        panle.getjPanel1().add(column);
                        panle.getjPanel1().add(column1);
                        column.addRelation(table1,columnTable1);
                        column1.addRelation(table2,columnTable2);
                        columnTable1.disablePK();
                        columnTable2.disablePK();
                        jPanel2.add(panle);
                        tables.add(panle);
                        cm.registerComponent(panle);
                connectLine2 = new JConnector(table1, panle, LINE_ARROW_DEST, Color.BLACK);
                connectLine = new JConnector(table2, panle, LINE_ARROW_DEST, Color.BLACK);
                jPanel2.add(connectLine2);
                panle.getRelation().add(connectLine);
                panle.getRelation().add(connectLine2);

            }
            table1.getRelation().add(connectLine);
            table2.getRelation().add(connectLine);
            jPanel2.add(connectLine);
            jPanel2.revalidate();
            jPanel2.repaint();
            jDialog2.setVisible(false);
        }
        else System.out.println("Error");
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {

        SqlGenerate sqlGenerate = new SqlGenerate(tables);
        sqlCodeWindow.setTextArea(sqlGenerate.generateSqlTables()+sqlGenerate.generateSqlForeignKey());
        sqlCodeWindow.setVisible(true);

    }

    private void jComboBox1ItemChange(ItemEvent e){
        if(jLabel2.getText().equals("Jeden do wielu")) {
            if (jComboBox1.getItemCount() != 0)
                loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()), 1,0);
        }
        else if(jLabel2.getText().equals("Jeden do jednego")){
            if (jComboBox1.getItemCount() != 0)
                loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()), 1,1);
        } else {
            if (jComboBox1.getItemCount() != 0)
                loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()), 1,2);
        }

    }
    private void jComboBox2ItemChange(ItemEvent e){
        if(jLabel2.getText().equals("Jeden do wielu")) {
            if (jComboBox2.getItemCount() != 0)
                loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()), 2,0);
        }
        else if(jLabel2.getText().equals("Jeden do jednego")){
            if (jComboBox2.getItemCount() != 0)
                loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()), 2,1);
        } else {
            if (jComboBox2.getItemCount() != 0)
                loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()), 2,2);
        }
    }

    public void loadTableToComboBox(){
        jComboBox1.removeAllItems();
        for (Table table : tables) jComboBox1.addItem(table.getTableName());
        jComboBox2.removeAllItems();
        for (Table table : tables) jComboBox2.addItem(table.getTableName());
    }

    public Table searchTable(String name){
        if(name==null)
            return null;
        for (Table table : tables){
            if(name.equals(table.getTableName()))
               return table;
        }
        return null;
    }
    public Column searchColumn(String name, Table table){
        if(name==null)
            return null;
        for (Column column : table.getColumns()){
            if(name.equals(column.getName()))
                return column;
        }
        return null;
    }
    public void loadAtrributsToComboBox(String name,int i,int realtionType){
        Table tmp= searchTable(name);
        if(realtionType==0) {
            if (i == 1) {
                jComboBox3.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    jComboBox3.addItem(column.getName());
                }
            } else if (i == 2) {
                jComboBox4.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.PKState())
                        jComboBox4.addItem(column.getName());
                }
            }
        }else if(realtionType==1){
            if (i == 1) {
                jComboBox3.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.PKState())
                        jComboBox3.addItem(column.getName()+" PK");
                    else
                        jComboBox3.addItem(column.getName());
                }
            } else if (i == 2) {
                jComboBox4.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.PKState())
                        jComboBox4.addItem(column.getName()+" PK");
                    else
                        jComboBox4.addItem(column.getName());
                }
            }
        } else if(realtionType==2){
            if (i == 1) {
                jComboBox3.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.PKState())
                        jComboBox3.addItem(column.getName());
                }
            } else if (i == 2) {
                jComboBox4.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.PKState())
                        jComboBox4.addItem(column.getName());
                }
            }
        }

    }

    public javax.swing.JPanel getjPanel2(){
        return jPanel2;
    }

    public List<Table> getTables(){return tables;}


    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {
      /*  for (Table table : tables){ //System.out.println(table.getColumns());
            for(Column column:table.getColumns()){

                if(!column.getRelation().isEmpty()) {
                    String saa = column.getRelation().toString();
                    Table table4 = (Table)column.getRelation().get(0).get(0);
                    Column col = (Column)column.getRelation().get(0).get(1);
                    System.out.println(table4.getTableName()+"  "+col.getName());
                   // System.out.println(saa.substring(saa.indexOf("Table[")+6,saa.indexOf(",")));
                }
            }
        }*/
        SqlGenerate sqlGenerate = new SqlGenerate(tables);
        System.out.print(sqlGenerate.generateSqlTables()+sqlGenerate.generateSqlForeignKey());
        //System.out.print(sqlGenerate.generateSqlForeignKey());


    }

    public static void main(String[] args) {

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

    private ArrayList<Table> tables;

    private SqlCodeWindow sqlCodeWindow;
    private Set<String> keyWords;
    private Message message;
    private ComponentMover cm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton10;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;


}
