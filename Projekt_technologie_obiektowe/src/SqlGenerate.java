import java.util.ArrayList;
import java.util.Locale;

public class SqlGenerate {

    public SqlGenerate(ArrayList<Table> t){
        tables =t;
    }

    public String generateSqlTables(){
        String sql="";
        for(Table table :tables){
            sql= sql+"CREATE TABLE " +table.getTableName()+" (\n";
            if(table.getSuperTables()!=null)
                for(Table table1: table.getSuperTables())
                    for(Column column1:table1.getColumns()){
                        if(column1.PKState())
                            sql=sql+column1.getName()+" "+column1.getColumType()+" "+getConstrains(column1)+"\n";
                    }
            for(Column column:table.getColumns()){
                sql=sql+column.getName()+" "+column.getColumType()+" "+getConstrains(column)+"\n";
            }
            sql=sql.replaceAll(",$","");
            sql=sql+");\n\n";
        }
        return sql;
    }

        private String getRandomString(int n)
        {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }

            return sb.toString();
        }

    public String generateSqlForeignKey(){
        String sql="";

        for(Table table :tables) {
                for (Column column : table.getColumns()) {
                        for (int i = 0; i < column.getRelation().size(); i++) {
                            Table tmpTable = (Table) column.getRelation().get(i).get(0);
                            Column tmpColumn = (Column) column.getRelation().get(i).get(1);
                            sql = sql + "ALTER TABLE " + table.getTableName()+" ADD CONSTRAINT " + getRandomString(10) + " FOREIGN KEY (" + column.getName() + ") "+ "REFERENCES " + tmpTable.getTableName() + "(" + tmpColumn.getName() + ");\n";
                }
            }
        }
        sql=sql+"\n";

        for(Table table :tables) {
            for (Table table1 : table.getSubTables()) {
                for(Column column:table.getColumns()) {
                    if(column.PKState())
                    sql = sql + "ALTER TABLE " + table1.getTableName() + " ADD CONSTRAINT " + getRandomString(10) + " FOREIGN KEY (" + column.getName() + ") " + "REFERENCES " + table.getTableName() + "(" + column.getName() + ");\n";
                }
            }
        }

        return sql;

    }

    private String getConstrains(Column column){
        boolean[] constrains = column.attributState();
        String constrainsString="";
        if(constrains[0])
            constrainsString= constrainsString+"PRIMARY KEY ";
        if(constrains[1])
            constrainsString= constrainsString+"NOT NULL ";
        if(constrains[2])
            constrainsString= constrainsString+"UNIQUE ";
        if(constrains[3])
            constrainsString= constrainsString+"CHECK "+column.getCheckArgument()+" ";
        if(constrains[4])
            constrainsString= constrainsString+"DEFAULT '"+column.getDefaultArgument()+"' ";
        constrainsString=constrainsString.replaceAll(" $","");
        constrainsString=constrainsString+",";


        return constrainsString;
    }

    private ArrayList<Table> tables;
}
