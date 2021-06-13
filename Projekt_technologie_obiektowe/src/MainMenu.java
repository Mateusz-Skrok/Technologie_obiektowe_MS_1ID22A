
import Connector.JConnector;
import DragClass.ComponentMover;
import DragClass.DragLayout;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

import static Connector.ConnectLine.*;


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

        relationDialogWindow = new javax.swing.JDialog();
        relationTypeLabel = new javax.swing.JLabel();
        tableLabel = new javax.swing.JLabel();
        tableRelationComboBox1 = new javax.swing.JComboBox<>();
        tableRelationComboBox2 = new javax.swing.JComboBox<>();
        attributsComboBox1 = new javax.swing.JComboBox<>();
        attributsComboBox2 = new javax.swing.JComboBox<>();
        relationCancelButton = new javax.swing.JButton();
        relationCreateButton = new javax.swing.JButton();
        attributLabel = new javax.swing.JLabel();
        table1Label = new javax.swing.JLabel();
        table2Label = new javax.swing.JLabel();
        createTableButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        diagramPanel = new javax.swing.JPanel(new DragLayout());
        clearButton = new javax.swing.JButton();
        oneToManyButton = new javax.swing.JButton();
        oneToOneButton = new javax.swing.JButton();
        ManyToManyButton = new javax.swing.JButton();
        SQLGenerateButton = new javax.swing.JButton();
        inheretenceButton = new javax.swing.JButton();
        inheritenceDialog = new javax.swing.JDialog();
        inhertienceLabel = new javax.swing.JLabel();
        inheritenceComboBox1 = new javax.swing.JComboBox<>();
        inheritenceComboBox2 = new javax.swing.JComboBox<>();
        inheritenceCancelButton = new javax.swing.JButton();
        inheritenceCreateButton = new javax.swing.JButton();
        baseLabel = new javax.swing.JLabel();
        subtableLabel = new javax.swing.JLabel();

        relationTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        relationTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        relationTypeLabel.setText("jLabel2");
        relationTypeLabel.setVerifyInputWhenFocusTarget(false);

        tableLabel.setText("Tabela");


        relationCancelButton.setText("Anuluj");
        relationCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relationCancelButtonActionPerformed(evt);
            }
        });
        relationCreateButton.setText("Utworz");
        relationCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relationCreateButtonActionPerformed(evt);
            }
        });
        attributLabel.setText("Atrybut");

        table1Label.setText("Tabela1");

        table2Label.setText("Tabela2");

        tableRelationComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tableRelationComboBox1ItemChange(e);
            }
        });
        tableRelationComboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tableRelationComboBox2ItemChange(e);
            }
        });

        relationDialogWindow.setLocationRelativeTo(null);
        relationDialogWindow.setSize(new java.awt.Dimension(400, 225));

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(relationDialogWindow.getContentPane());
        relationDialogWindow.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(relationTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialog2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                .addComponent(table1Label)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                                .addComponent(table2Label)
                                                .addGap(18, 18, 18)))
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                .addComponent(relationCancelButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(relationCreateButton))
                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tableRelationComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tableRelationComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(tableLabel)))
                                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(attributLabel)
                                                                .addGap(38, 38, 38))
                                                        .addGroup(jDialog2Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(attributsComboBox1, 0, 115, Short.MAX_VALUE)
                                                                        .addComponent(attributsComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(relationTypeLabel)
                                .addGap(18, 18, 18)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tableLabel)
                                        .addComponent(attributLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tableRelationComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attributsComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(table1Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tableRelationComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attributsComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(table2Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(relationCancelButton)
                                        .addComponent(relationCreateButton))
                                .addContainerGap())
        );

        inhertienceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inhertienceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inhertienceLabel.setText("Dziedziczenie");
        inhertienceLabel.setVerifyInputWhenFocusTarget(false);


        inheritenceCancelButton.setText("Anuluj");
        inheritenceCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inheritenceCancelButtonActionPerformed(evt);
            }
        });

        inheritenceCreateButton.setText("Utworz");
        inheritenceCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inheritenceCreateButtonActionPerformed(evt);
            }
        });

        baseLabel.setText("Bazowa");

        subtableLabel.setText("Pochodna");

        inheritenceDialog.setLocationRelativeTo(null);
        inheritenceDialog.setSize(new java.awt.Dimension(400, 225));

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(inheritenceDialog.getContentPane());
        inheritenceDialog.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
                jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inhertienceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialog3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDialog3Layout.createSequentialGroup()
                                                .addComponent(baseLabel)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                                                .addComponent(subtableLabel)
                                                .addGap(18, 18, 18)))
                                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(inheritenceComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog3Layout.createSequentialGroup()
                                                .addComponent(inheritenceCancelButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                                .addComponent(inheritenceCreateButton))
                                        .addComponent(inheritenceComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21))
        );
        jDialog3Layout.setVerticalGroup(
                jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inhertienceLabel)
                                .addGap(38, 38, 38)
                                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inheritenceComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(baseLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inheritenceComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subtableLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inheritenceCancelButton)
                                        .addComponent(inheritenceCreateButton))
                                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createTableButton.setText("Dodaj tabele");
        createTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTableButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(diagramPanel);

        clearButton.setText("Wyczysc");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        oneToManyButton.setText("1_do_w");
        oneToManyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneToManyButtonActionPerformed(evt);
            }
        });
        oneToOneButton.setText("1_do_1");
        oneToOneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneToOneButtonActionPerformed(evt);
            }
        });
        ManyToManyButton.setText("w_do_w");
        ManyToManyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManyToManyButtonActionPerformed(evt);
            }
        });
        SQLGenerateButton.setText("SQL");
        SQLGenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SQLGenerateButtonActionPerformed(evt);
            }
        });
        inheretenceButton.setText("Dziedziczenie");
        inheretenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inheretenceButtonActionPerformed(evt);
            }
        });
        diagramPanel.setBackground(new java.awt.Color(255, 255, 204));
        setBackground(Color.yellow);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(inheretenceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(oneToManyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(oneToOneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ManyToManyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(SQLGenerateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                        .addComponent(createTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(createTableButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oneToManyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oneToOneButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ManyToManyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inheretenceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SQLGenerateButton)
                                .addGap(42, 42, 42)
                                .addComponent(clearButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        this.setExtendedState(MAXIMIZED_BOTH);
    }



    private void createTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Table table = new Table(this);
        TextSetter textSetter = new TextSetter(table, diagramPanel, tables,cm);
        textSetter.setLabelName("Nazwa tabeli");
        textSetter.setVisible(true);

    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        diagramPanel.removeAll();
        diagramPanel.revalidate();
        diagramPanel.repaint();
        tables.clear();
    }

    private void oneToManyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox(tableRelationComboBox1, tableRelationComboBox2);
        if(tableRelationComboBox1.getItemCount()!=0)
        loadAtrributsToComboBox(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()),1,0);
        if(tableRelationComboBox2.getItemCount()!=0)
        loadAtrributsToComboBox(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()),2,0);
        relationDialogWindow.setVisible(true);
        relationTypeLabel.setText("Jeden do wielu");
        table1Label.setText("Wielu");
        table2Label.setText("Jeden");

    }
    private void oneToOneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox(tableRelationComboBox1, tableRelationComboBox2);
        if(tableRelationComboBox1.getItemCount()!=0)
            loadAtrributsToComboBox(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()),1,1);
        if(tableRelationComboBox2.getItemCount()!=0)
            loadAtrributsToComboBox(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()),2,1);
        relationDialogWindow.setVisible(true);
        relationTypeLabel.setText("Jeden do jednego");
        table1Label.setText("Jeden");
        table2Label.setText("Jeden");

    }
    private void ManyToManyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox(tableRelationComboBox1, tableRelationComboBox2);
        if(tableRelationComboBox1.getItemCount()!=0)
            loadAtrributsToComboBox(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()),1,2);
        if(tableRelationComboBox2.getItemCount()!=0)
            loadAtrributsToComboBox(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()),2,2);
        relationDialogWindow.setVisible(true);
        relationTypeLabel.setText("Wielu do wielu");
        table1Label.setText("Wielu");
        table2Label.setText("Wielu");

    }

    private void relationCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        relationDialogWindow.setVisible(false);

    }


    private void relationCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {

        Table table1= searchTable(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()));
        Table table2= searchTable(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()));
        Column column = searchColumn(attributsComboBox1.getItemAt(attributsComboBox1.getSelectedIndex()),table1);
        Column column2 = searchColumn(attributsComboBox2.getItemAt(attributsComboBox2.getSelectedIndex()),table2);
        JConnector connectLine,connectLine2;
        if(table1!=null&&table2!=null&&table1!=table2) {
            if(relationTypeLabel.getText().equals("Jeden do wielu")) {
                connectLine = new JConnector(table2, table1, LINE_ARROW_DEST, Color.BLACK);
                column.FKChangeStateToTrue();
                column.addRelation(table2,column2);
                column2.disablePK();
                saveRelaationConectors(table1,connectLine,false);
                saveRelaationConectors(table2,connectLine,false);
            }
            else if(relationTypeLabel.getText().equals("Jeden do jednego")) {
                connectLine = new JConnector(table2, table1, LINE_ARROW_NONE, Color.BLACK);
                if(column2.getPKState()){
                    column.FKChangeStateToTrue();
                    column.addRelation(table2,column2);
                    column2.disablePK();}
                else if(column.getPKState()) {
                    connectLine = new JConnector(table1, table2, LINE_ARROW_NONE, Color.BLACK);
                    column.disablePK();
                    column2.FKChangeStateToTrue();
                    column2.addRelation(table1, column);
                }
                else{
                    column.FKChangeStateToTrue();
                    column.addRelation(table2,column2);
                    column2.setPKState();
                    column2.disablePK();
                }
                saveRelaationConectors(table1,connectLine,false);
                saveRelaationConectors(table2,connectLine,false);
            }
            else {
                Table subTable = new Table(this);
                createSubTableForManyToManyRelation(subTable,table1,table2);
                connectLine2 = new JConnector(table1, subTable, LINE_ARROW_DEST, Color.BLACK);
                connectLine = new JConnector(table2, subTable, LINE_ARROW_DEST, Color.BLACK);
                diagramPanel.add(connectLine2);
                subTable.getjConnectors().add(connectLine);
                subTable.getjConnectors().add(connectLine2);
                subTable.setRelationDeleteMenuList(false);
            }
            diagramPanel.add(connectLine);
            diagramPanel.revalidate();
            diagramPanel.repaint();
            relationDialogWindow.setVisible(false);
        }
        else {
            message.setText("Wybrano złe tabele");
            message.setVisible(true);
        }
    }

    private void saveRelaationConectors(Table table,JConnector connectLine,boolean inheritence){
        table.getjConnectors().add(connectLine);
        table.setRelationDeleteMenuList(inheritence);
    }

    private void createSubTableForManyToManyRelation(Table subTable,Table table1,Table table2){

        subTable.setTableName(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex())+"_"+ tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()));
        Column column = new Column(subTable);
        Column column1 = new Column(subTable);
        column.setName(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex())+"_id");
        column1.setName(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex())+"_id");
        Column columnTable1 = searchColumn(attributsComboBox1.getItemAt(attributsComboBox1.getSelectedIndex()),table1);
        Column columnTable2 = searchColumn(attributsComboBox2.getItemAt(attributsComboBox2.getSelectedIndex()),table2);
        column.FKChangeStateToTrue();
        column1.FKChangeStateToTrue();
        subTable.getColumns().add(column);
        subTable.getColumns().add(column1);
        subTable.getColumnPanel().add(column);
        subTable.getColumnPanel().add(column1);
        column.addRelation(table1,columnTable1);
        column1.addRelation(table2,columnTable2);
        columnTable1.disablePK();
        columnTable2.disablePK();
        diagramPanel.add(subTable);
        tables.add(subTable);
        cm.registerComponent(subTable);
    }

    private void SQLGenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {

        SqlGenerate sqlGenerate = new SqlGenerate(tables);
        sqlCodeWindow.setTextArea(sqlGenerate.generateSqlTables()+sqlGenerate.generateSqlForeignKey());
        sqlCodeWindow.setVisible(true);

    }

    private void inheretenceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableToComboBox(inheritenceComboBox1, inheritenceComboBox2);
     inheritenceDialog.setVisible(true);

    }
    private void inheritenceCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        inheritenceDialog.setVisible(false);

    }
    private void inheritenceCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(inheritenceComboBox1 !=null&& inheritenceComboBox2 !=null) {
            Table table1 = searchTable(inheritenceComboBox1.getItemAt(inheritenceComboBox1.getSelectedIndex()));
            Table table2 = searchTable(inheritenceComboBox2.getItemAt(inheritenceComboBox2.getSelectedIndex()));
            JConnector connectLine;
            if(table1!=null && table2!=null && table1!=table2) {
                if(table1.PKAvailable()) {
                    connectLine = new JConnector(table2, table1, LINE_INHERITANCE, Color.BLACK);
                    saveRelaationConectors(table1,connectLine,true);
                    saveRelaationConectors(table2,connectLine,true);
                    table1.getSubTables().add(table2);
                    table2.getSuperTables().add(table1);
                    if(!table2.PKAvailable()){
                        creatColumnForSubTable(table2,table1);
                    }
                    else{
                        table2.getColumnWithPK().FKChangeStateToTrue();
                    }
                    table1.disablePKInTable();
                    table2.disablePKInTable();
                    diagramPanel.add(connectLine);
                    diagramPanel.revalidate();
                    diagramPanel.repaint();
                    inheritenceDialog.setVisible(false);
                }else{
                    message.setText("Brak klucz głównego w tabeli bazowej");
                    message.setVisible(true);
                }
            }
            else{
                message.setText("Wybrano takie same tabele");
                message.setVisible(true);
            }
        }

    }

    private void creatColumnForSubTable(Table table,Table table1){
        Column subTableColumn = new Column(table);
        subTableColumn.setName(table1.getPKName());
        subTableColumn.setPKState();
        subTableColumn.FKChangeStateToTrue();
        table.getColumns().add(subTableColumn);
        table.getColumnPanel().add(subTableColumn);
    }

    private void tableRelationComboBox1ItemChange(ItemEvent e){
        if(relationTypeLabel.getText().equals("Jeden do wielu")) {
            if (tableRelationComboBox1.getItemCount() != 0)
                loadAtrributsToComboBox(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()), 1,0);
        }
        else if(relationTypeLabel.getText().equals("Jeden do jednego")){
            if (tableRelationComboBox1.getItemCount() != 0)
                loadAtrributsToComboBox(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()), 1,1);
        } else {
            if (tableRelationComboBox1.getItemCount() != 0)
                loadAtrributsToComboBox(tableRelationComboBox1.getItemAt(tableRelationComboBox1.getSelectedIndex()), 1,2);
        }

    }
    private void tableRelationComboBox2ItemChange(ItemEvent e){
        if(relationTypeLabel.getText().equals("Jeden do wielu")) {
            if (tableRelationComboBox2.getItemCount() != 0)
                loadAtrributsToComboBox(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()), 2,0);
        }
        else if(relationTypeLabel.getText().equals("Jeden do jednego")){
            if (tableRelationComboBox2.getItemCount() != 0)
                loadAtrributsToComboBox(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()), 2,1);
        } else {
            if (tableRelationComboBox2.getItemCount() != 0)
                loadAtrributsToComboBox(tableRelationComboBox2.getItemAt(tableRelationComboBox2.getSelectedIndex()), 2,2);
        }
    }


    public void loadTableToComboBox(javax.swing.JComboBox<String> jComboBox1,javax.swing.JComboBox<String> jComboBox2){
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
                attributsComboBox1.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    attributsComboBox1.addItem(column.getName());
                }
            } else if (i == 2) {
                attributsComboBox2.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.getPKState()||column.getUniqueState())
                        attributsComboBox2.addItem(column.getName());
                }
            }
        }else if(realtionType==1){
            if (i == 1) {
                attributsComboBox1.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.getPKState())
                        attributsComboBox1.addItem(column.getName());
                    else
                        attributsComboBox1.addItem(column.getName());
                }
            } else if (i == 2) {
                attributsComboBox2.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.getPKState())
                        attributsComboBox2.addItem(column.getName());
                    else
                        attributsComboBox2.addItem(column.getName());
                }
            }
        } else if(realtionType==2){
            if (i == 1) {
                attributsComboBox1.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.getPKState())
                        attributsComboBox1.addItem(column.getName());
                }
            } else if (i == 2) {
                attributsComboBox2.removeAllItems();
                for (Column column : tmp.getColumns()) {
                    if (column.getPKState())
                        attributsComboBox2.addItem(column.getName());
                }
            }
        }

    }

    public javax.swing.JPanel getDiagramPanel(){
        return diagramPanel;
    }

    public List<Table> getTables(){return tables;}


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
    private Message message;
    private ComponentMover cm;
    private javax.swing.JButton createTableButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton oneToManyButton;
    private javax.swing.JButton oneToOneButton;
    private javax.swing.JButton ManyToManyButton;
    private javax.swing.JButton relationCancelButton;
    private javax.swing.JButton relationCreateButton;
    private javax.swing.JButton SQLGenerateButton;
    private javax.swing.JButton inheretenceButton;
    private javax.swing.JButton inheritenceCancelButton;
    private javax.swing.JButton inheritenceCreateButton;
    private javax.swing.JComboBox<String> tableRelationComboBox1;
    private javax.swing.JComboBox<String> tableRelationComboBox2;
    private javax.swing.JComboBox<String> attributsComboBox1;
    private javax.swing.JComboBox<String> attributsComboBox2;
    private javax.swing.JComboBox<String> inheritenceComboBox1;
    private javax.swing.JComboBox<String> inheritenceComboBox2;
    private javax.swing.JDialog relationDialogWindow;
    private javax.swing.JDialog inheritenceDialog;
    private javax.swing.JLabel relationTypeLabel;
    private javax.swing.JLabel tableLabel;
    private javax.swing.JLabel attributLabel;
    private javax.swing.JLabel table1Label;
    private javax.swing.JLabel table2Label;
    private javax.swing.JLabel inhertienceLabel;
    private javax.swing.JLabel baseLabel;
    private javax.swing.JLabel subtableLabel;
    public javax.swing.JPanel diagramPanel;
    private javax.swing.JScrollPane jScrollPane2;
}
