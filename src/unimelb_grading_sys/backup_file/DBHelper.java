package unimelb_grading_sys.backup_file;

import java.sql.*;
import java.util.*;
import java.util.function.Consumer;

public class DBHelper {

    private static String databaseName = "cjy_test_db";
    //use your database name

    private static String IP = "192.168.64.1";
    //use >>>ip route show default | awk '{print $3}'>>> to get your IP address

    private static String url = "jdbc:mysql://" + IP + ":3306/" + databaseName +
                        "?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8" +
                        "&allowPublicKeyRetrieval=true";

    private static String username = "root";
    private static String password = "Jerry20080515";

    public static String resultIterateError = "result error of SQL query or No query result returned (matched)";
    

    public static List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> resultList = new ArrayList<>();
    
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            System.out.println("\nConnect to database " + databaseName + " successfully...\n");
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
        
            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
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

    public static int executeUpdate(String sql, Consumer<PreparedStatement> paramSetter) {
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
    }

}
