package MySQL_system.SQLServer.query_interface;


import java.sql.*;
import java.util.HashMap;

import MySQL_system.db_config.DBConfig;


public class SingleQuery implements Query {
    
    @Override
    public HashMap<String, Object> executeQuery(DBConfig dbConfig, String sql, Object... params) {
        HashMap<String, Object> resultRow = new HashMap<>();
    
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
                if (!rs.next()) return null;
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    resultRow.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
            }
        } catch (SQLException e) {
            System.err.println("query error: " + e.getMessage());
            e.printStackTrace();
        }
        return resultRow;
    }

}
