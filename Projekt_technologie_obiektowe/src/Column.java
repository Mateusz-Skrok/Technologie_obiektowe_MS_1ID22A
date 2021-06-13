
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;


public class Column extends javax.swing.JPanel {


    public Column(Table table) {
        initComponents();
        this.table=table;
    }



    private void initComponents() {

        relation = new ArrayList<>();
        columnName = new javax.swing.JLabel();
        columnType = new javax.swing.JComboBox<>();
        columnAttributes = new javax.swing.JButton();
        PK= new JCheckBoxMenuItem("PRIMARY KEY");
        FK= new JCheckBoxMenuItem("FOREIGN KEY");
        NotNull= new JCheckBoxMenuItem("NOT NULL");
        Unique= new JCheckBoxMenuItem("UNIQUE");
        Rename= new JMenuItem("Zmien nazwe");
        Delete= new JMenuItem("Usun");

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        columnName.setText("jLabel1");

        columnType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"NUMBER","CHAR", "NCHAR", "VARCHAR2","VARCHAR","NVARCHAR2","CLOB","NCLOB","LONG","DATE","BLOB",
        "BFILE","RAW"}));
        columnType.setMaximumSize( columnType.getPreferredSize() );
        buttonPopup = new JPopupMenu();
        buttonPopup.add(PK);
        buttonPopup.add(FK);
        buttonPopup.add(NotNull);
        buttonPopup.add(Unique);
        FK.setEnabled(false);

        RMCPopup = new JPopupMenu();
        RMCPopup.add(Rename);
        RMCPopup.add(Delete);


        PK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                for(Column column:table.getColumns()){
                    if(column!=Column.this&&column.getPKState()||!table.getSuperTables().isEmpty()) {
                        Message message = new Message();
                        message.setText("Tylko jeden klucz głowny");
                        message.setVisible(true);
                        PK.setState(false);
                        break;
                    }
                }
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
                if(PK.isEnabled()&&!FK.getState()) {
                    table.getColumnPanel().remove(Column.this);
                    table.getColumnPanel().revalidate();
                    table.getColumnPanel().repaint();
                    table.getColumns().remove(Column.this);
                }
            }
        });

        columnAttributes.setText("jButton1");
        columnAttributes.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                buttonPopup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        setBackground(Color.yellow);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(columnName)
                                .addGap(32, 32, 32)
                                .addComponent(columnType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(columnAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(columnName)
                                .addComponent(columnType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(columnAttributes))
        );
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        if(SwingUtilities.isRightMouseButton(evt))
        RMCPopup.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    public void setName(String name1){
        name=name1;
        columnName.setText(name1);
    }

    public String getName(){return name;}

    public boolean getPKState(){
        return PK.getState();
    }
    public boolean getUniqueState(){return Unique.getState();}
    public boolean getNotNullState(){return NotNull.getState();}


    public void setPKState(){
        PK.setState(true);
    }

    public void disablePK(){
        PK.setEnabled(false);
    }
    public void enablePK(){
        if(!PK.isEnabled())
            PK.setEnabled(true);
    }

    public void FKChangeStateToTrue(){
        FK.setState(true);
    }

    public void FKChangeStateToFalse(){
        FK.setState(false);
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

        return attributs;
    }


    public String getColumType(){
        String columnTypeString=columnType.getItemAt(columnType.getSelectedIndex());
        if(columnTypeString.equals("VARCHAR2")||columnTypeString.equals("VARCHAR")||columnTypeString.equals("NVARCHAR2")||columnTypeString.equals("RAW"))
            columnTypeString=columnTypeString+"(100)";
        return columnTypeString;
    }

    public boolean getFKState(){
        return FK.getState();
    }

    private ArrayList<ArrayList<Object>> relation;
    private final Table table;
    private JPopupMenu buttonPopup;
    private JPopupMenu RMCPopup;
    private String name;
    private javax.swing.JButton columnAttributes;
    private javax.swing.JComboBox<String> columnType;
    private javax.swing.JLabel columnName;
    private JCheckBoxMenuItem PK,NotNull,Unique,FK;
    private JMenuItem Rename,Delete;

}
