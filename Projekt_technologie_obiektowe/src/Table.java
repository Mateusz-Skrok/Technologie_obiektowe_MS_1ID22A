import Connector.JConnector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Table extends javax.swing.JPanel {


    public Table(MainMenu jFrame) {
        mainPanel =jFrame;
        initComponents();
    }

    private void initComponents() {

        message = new Message();
        columns=new ArrayList<Column>();
        jConnectors = new ArrayList<JConnector>();
        subTables = new ArrayList<Table>();
        superTables = new ArrayList<Table>();

        tableNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        columnPanel = new javax.swing.JPanel();
        rightClickMenu=new JPopupMenu();
        rename=new JMenuItem("Zmien nazwe");
        delete=new JMenuItem("Usun");
        add=new JMenuItem("Dodaj atrybut");
        removeRelation = new JMenu("Usun relacje");
        rightClickMenu.add(rename);
        rightClickMenu.add(delete);
        rightClickMenu.add(add);

        rightClickMenu.add(removeRelation);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        columnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        tableNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableNameLabel.setText("jLabel1");

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });


        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });


        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });


        rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameActionPerformed(evt);
            }
        });
        columnPanel.setLayout(new javax.swing.BoxLayout(columnPanel, BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(columnPanel);

        setBackground(java.awt.Color.orange);
        columnPanel.setBackground(java.awt.Color.yellow);
        columnPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addComponent(tableNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tableNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addContainerGap())
        );


    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        if(SwingUtilities.isRightMouseButton(evt))
            rightClickMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        Column column = new Column(this);
        TextSetter textSetter = new TextSetter(columnPanel,column,columns);
        textSetter.setLabelName("Podaj nazwe atrybutu");
        textSetter.setVisible(true);

    }


    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        mainPanel.getDiagramPanel().remove(this);
        mainPanel.getTables().remove(this);
        for (JConnector jConnector : jConnectors) {
            Table tableSource=(Table) jConnector.getSource();
            for(Column column:tableSource.getColumns())
                column.enablePK();
            Table tableDestination=(Table) jConnector.getDest();
            for(Column column:tableDestination.getColumns())
                column.enablePK();
            mainPanel.getDiagramPanel().remove(jConnector);
        }
        for(Table table:superTables)
            table.getSubTables().remove(this);
        for(Table table:subTables)
            table.getSuperTables().remove(this);
        mainPanel.getDiagramPanel().revalidate();
        mainPanel.getDiagramPanel().repaint();
    }

    private void renameActionPerformed(java.awt.event.ActionEvent evt) {
        TextSetter textSetter = new TextSetter(this);
        textSetter.setLabelName("Zmien nazwe tabeli");
        textSetter.setVisible(true);

    }

    public void setRelationDeleteMenuList(boolean inheritence){
        removeRelation.removeAll();
        for (JConnector jConnector : jConnectors) {
            Table tableSource=(Table) jConnector.getSource();
            if(tableSource!=this) {
                JMenuItem newDeleteRelationMenu = new JMenuItem(tableSource.getTableName());
                newDeleteRelationMenu.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if(!inheritence)
                            removeRelation(evt,newDeleteRelationMenu);
                        else
                            removeInheritence(evt,newDeleteRelationMenu);
                    }
                });
                removeRelation.add(newDeleteRelationMenu);
            }
            Table tableDestination=(Table) jConnector.getDest();
            if(tableDestination!=this) {
                JMenuItem newDeleteRelationMenu = new JMenuItem(tableDestination.getTableName());
                newDeleteRelationMenu.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if(!inheritence)
                            removeRelation(evt,newDeleteRelationMenu);
                        else
                            removeInheritence(evt,newDeleteRelationMenu);
                    }
                });
                removeRelation.add(newDeleteRelationMenu);
            }
        }
    }

    private void removeInheritence(java.awt.event.ActionEvent evt,JMenuItem menuItem) {
        try {
            for (JConnector jConnector : jConnectors) {
                Table tableDestination = (Table) jConnector.getDest();
                Table tableSource = (Table) jConnector.getSource();
                if(tableDestination.getTableName().equals(menuItem.getText())|| tableSource.getTableName().equals(menuItem.getText())){
                    mainPanel.getDiagramPanel().remove(jConnector);
                    tableDestination.getjConnectors().remove(jConnector);
                    tableSource.getjConnectors().remove(jConnector);
                    tableSource.getSuperTables().remove(tableDestination);
                    tableDestination.getSubTables().remove(tableSource);
                    for (Column column:tableDestination.getColumns())
                        if(column.getPKState()&&tableDestination.getjConnectors().isEmpty())
                            column.enablePK();
                    for (Column column:tableSource.getColumns())
                        if(column.getPKState()&&tableSource.getjConnectors().isEmpty()) {
                            column.enablePK();
                            column.FKChangeStateToFalse();
                        }
                    tableDestination.setRelationDeleteMenuList(true);
                    tableSource.setRelationDeleteMenuList(true);
                }
            }
            }catch (Exception e){
                System.out.println(e);
            }
    }

    private void removeRelation(java.awt.event.ActionEvent evt,JMenuItem menuItem){
      try {
          for (JConnector jConnector : jConnectors) {
              Table tableDestination = (Table) jConnector.getDest();
              Table tableSource = (Table) jConnector.getSource();
              if (tableDestination.getTableName().equals(menuItem.getText()) || tableSource.getTableName().equals(menuItem.getText())) {
                  mainPanel.getDiagramPanel().remove(jConnector);
                  tableDestination.getjConnectors().remove(jConnector);
                  tableSource.getjConnectors().remove(jConnector);
                  if(tableDestination.equals(this)) {
                      for (Column column : tableDestination.getColumns()) {
                          for (int i = 0; i < column.getRelation().size(); i++) {
                              Table relationTabelInList=(Table) column.getRelation().get(i).get(0);
                              if(relationTabelInList.getTableName().equals(menuItem.getText()))
                                    column.getRelation().remove(i);
                          }
                          if (column.getFKState())
                              column.FKChangeStateToFalse();
                      }
                  }
                  if(tableSource.equals(this)){
                      for (Column column : tableDestination.getColumns()) {
                          for (int i = 0; i < column.getRelation().size(); i++) {
                              Table relationTabelInList=(Table) column.getRelation().get(i).get(0);
                              if(relationTabelInList.getTableName().equals(tableSource.getTableName()))
                                  column.getRelation().remove(i);
                          }
                          if (column.getFKState())
                              column.FKChangeStateToFalse();
                      }
                  }
                  tableDestination.setRelationDeleteMenuList(false);
                  tableSource.setRelationDeleteMenuList(false);
                  if (tableDestination.getjConnectors().isEmpty()) {
                      for (Column column : tableDestination.getColumns())
                          column.enablePK();
                  }
                  if (tableSource.getjConnectors().isEmpty()) {
                      for (Column column : tableSource.getColumns())
                          column.enablePK();
                  }
              }
          }
          mainPanel.getDiagramPanel().revalidate();
          mainPanel.getDiagramPanel().repaint();

      }catch (Exception e){
          System.out.println(e);
      }
    }
    public void setTableName(String name){
        tableNameLabel.setText(name);
        tableName =name;
        this.setName(name);
    }

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {
        if(!columns.isEmpty())
        setPreferredSize(new Dimension(columns.get(0).getWidth()+15,this.getHeight()));
        mainPanel.getDiagramPanel().revalidate();
        mainPanel.getDiagramPanel().repaint();

    }

    public String getPKName(){
        for(Column column:columns) {
            if (column.getPKState()) {
                return column.getName();
            }
        }
        return null;
    }

    public void disablePKInTable(){
        for(Column column:columns)
            if(column.getPKState())
                column.disablePK();
    }

    public Column getColumnWithPK(){
        for(Column column:columns) {
            if (column.getPKState()) {
                return column;
            }
        }
        return null;
    }

    public boolean PKAvailable(){
        for(Column column:columns) {
            if (column.getPKState()) {
                return true;
            }
        }
            return false;
    }

    public javax.swing.JLabel getTableNameLabel(){
        return this.tableNameLabel;
    }
    public javax.swing.JPanel getColumnPanel(){
        return columnPanel;
    }
    public String getTableName(){return tableName;}
    public List<Column> getColumns() {
        return columns;
    }
    public List<JConnector> getjConnectors() {
        return jConnectors;
    }
    public List<Table> getSubTables() {
        return subTables;
    }
    public List<Table> getSuperTables() {
        return superTables;
    }

    private List<JConnector> jConnectors;
    private List<Column> columns;
    private List<Table> subTables;
    private List<Table> superTables;
    private Message message;
    private String tableName;
    private final MainMenu mainPanel;
    private javax.swing.JLabel tableNameLabel;
    private javax.swing.JPanel columnPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private JPopupMenu rightClickMenu;
    private JMenuItem rename,delete,add;
    private JMenu removeRelation;
}
