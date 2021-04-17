
import Connector.JConnector;
import DragClass.ComponentMover;
import DragClass.DragLayout;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

import static Connector.ConnectLine.LINE_ARROW_DEST;
import static Connector.ConnectLine.LINE_ARROW_NONE;


public class MainMenu extends javax.swing.JFrame {


    public MainMenu() {
        initComponents();
    }



    private void initComponents() {
        cm = new ComponentMover();
        cm.setEdgeInsets( new Insets(0, 0, -100, -100) );
        cm.setAutoLayout(true);
        tablice=new ArrayList<Table>();

        message =  new Message();
        keyWords= new HashSet<String>();

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                                .addContainerGap())
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
                                .addGap(12, 12, 12)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
        tablice.clear();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Table panle = new Table(this);
        if(!jTextField1.getText().isBlank()) {
            if(!keyWords.contains(jTextField1.getText().toUpperCase())) {
                panle.setName(jTextField1.getText().trim());
                jTextField1.setText("");
                jPanel2.add(panle);
                jPanel2.revalidate();
                jPanel2.repaint();
                tablice.add(panle);
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
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox();
        if(jComboBox1.getItemCount()!=0)
        loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1);
        if(jComboBox2.getItemCount()!=0)
        loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2);
        jDialog2.setVisible(true);
        jLabel2.setText("Jeden do wielu");

    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox();
        if(jComboBox1.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1);
        if(jComboBox2.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2);
        jDialog2.setVisible(true);
        jLabel2.setText("Jeden do jednego");

    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox();
        if(jComboBox1.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1);
        if(jComboBox2.getItemCount()!=0)
            loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2);
        jDialog2.setVisible(true);
        jLabel2.setText("Wielu do wielu");

    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        jDialog2.setVisible(false);

    }
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {

        Table table1=serchTable(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
        Table table2=serchTable(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
        JConnector connectLine,connectLine2;
        if(table1!=null&&table2!=null&&table1!=table2) {
            if(jLabel2.getText().equals("Jeden do wielu"))
             connectLine = new JConnector(table1, table2, LINE_ARROW_DEST, Color.BLACK);
            else if(jLabel2.getText().equals("Jeden do jednego"))
                connectLine = new JConnector(table1, table2, LINE_ARROW_NONE, Color.BLACK);
            else {
                Table panle = new Table(this);
                        panle.setName(jComboBox1.getItemAt(jComboBox1.getSelectedIndex())+"_"+jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
                        jPanel2.add(panle);
                        tablice.add(panle);
                        cm.registerComponent(panle);
                connectLine2 = new JConnector(panle, table1, LINE_ARROW_DEST, Color.BLACK);
                connectLine = new JConnector(panle, table2, LINE_ARROW_DEST, Color.BLACK);
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

    private void jComboBox1ItemChange(ItemEvent e){
        if(jComboBox1.getItemCount()!=0)
        loadAtrributsToComboBox(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),1);
    }
    private void jComboBox2ItemChange(ItemEvent e){
        if(jComboBox2.getItemCount()!=0)
        loadAtrributsToComboBox(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()),2);
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

    public void loadTableToComboBox(){
        jComboBox1.removeAllItems();
        for (Table table : tablice) jComboBox1.addItem(table.getTableName());
        jComboBox2.removeAllItems();
        for (Table table : tablice) jComboBox2.addItem(table.getTableName());
    }

    public Table serchTable(String name){
        if(name==null)
            return null;
        for (Table table : tablice){
            if(name.equals(table.getTableName()))
               return table;
        }
        return null;
    }
    public void loadAtrributsToComboBox(String name,int i){
        Table tmp=serchTable(name);
        if(i==1) {
            jComboBox3.removeAllItems();
            for (Column column : tmp.getColumns()) jComboBox3.addItem(column.getName());
        }else if(i==2) {
            jComboBox4.removeAllItems();
            for (Column column : tmp.getColumns()) jComboBox4.addItem(column.getName());
        }
    }

    public javax.swing.JPanel getjPanel2(){
        return jPanel2;
    }
    public Set<String> getKeyWords(){ return keyWords;}
    public List<Table> getTablice(){return tablice;}


    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {
        for (Table table : tablice) System.out.println(table.getTableName());
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
    ArrayList<Table> tablice;

    private Set<String> keyWords;
    private  Message message;
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
