package MySQL_system.SQLServer;

import MySQL_system.db_config.*;
import MySQL_system.SQLServer.query_interface.*;


public class SQLServer {

    protected Query queryMethod;

    protected static final String resultIterateError = "result error of SQL query or No query result returned (matched)";

    public SQLServer(Query queryMethod) {
        this.queryMethod = queryMethod;
    }

    public Object executeQuery(DBConfig dbConfig, String sql, Object... params) {
        return queryMethod.executeQuery(dbConfig, sql, params);
    }

}


/* public static int executeUpdate(String sql, Consumer<PreparedStatement> paramSetter) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("\nConnect to database " + databaseName + " successfully...\n");

            conn.setAutoCommit(false); 
            pstmt = conn.prepareStatement(sql);
            paramSetter.accept(pstmt); 
            int rows = pstmt.executeUpdate();
            conn.commit();
            
            System.out.println("update successfully, affected rows: " + rows);
            return rows;

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.err.println("insert, delete or update error: " + e.getMessage());
            return -1;

        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }

    public static int[] executeBatch(String sql, List<Object[]> paramsList) {

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            System.out.println("\nConnect to database " + databaseName + " successfully...\n");
            conn.setAutoCommit(false);
        
            for (Object[] params : paramsList) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
                pstmt.addBatch();
            }
        
            int[] results = pstmt.executeBatch();
            conn.commit();
            return results;
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    } */