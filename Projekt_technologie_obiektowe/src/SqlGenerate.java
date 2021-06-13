import java.util.ArrayList;

public class SqlGenerate {

    public SqlGenerate(ArrayList<Table> tables){
        this.tables =tables;
    }

    public String generateSqlTables(){
        String sql="";
        for(Table table :tables){
            sql= sql+"CREATE TABLE " +table.getTableName()+" (\n";
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
                    if(column.getPKState()) {
                        sql = sql + "ALTER TABLE " + table1.getTableName() + " ADD CONSTRAINT " + getRandomString(10) + " FOREIGN KEY (" + table1.getPKName() + ") " + "REFERENCES " + table.getTableName() + "(" + column.getName() + ");\n";
                        break;
                    }
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
        constrainsString=constrainsString.replaceAll(" $","");
        constrainsString=constrainsString+",";

        return constrainsString;
    }

    private final ArrayList<Table> tables;
}
