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
