package MySQL_system.SQLServer.query_interface;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import MySQL_system.db_config.*;

public class MutipleQuery implements Query {
    
    @Override
    public ArrayList<HashMap<String, Object>> executeQuery(DBConfig dbConfig, String sql, Object... params) {
        ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
    
        try (
            Connection conn = DriverManager.getConnection(dbConfig.getDBURL(), dbConfig.getUsername(), dbConfig.getPassword());
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            System.out.println("\nConnect to database " + dbConfig.getDBName() + " successfully...\n");
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
        
            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (rs.next()) {
                    HashMap<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) row.put(metaData.getColumnLabel(i), rs.getObject(i));
                    resultList.add(row);
                }
            }
        } catch (SQLException e) {
            System.err.println("query error: " + e.getMessage());
            e.printStackTrace();
        }
        return resultList;
    }

}
