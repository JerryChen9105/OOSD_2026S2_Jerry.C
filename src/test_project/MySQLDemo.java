package test_project;

import java.sql.*;
//import java.time.LocalDate;

public class MySQLDemo {
    public static void main(String[] args) {
        // ==========================================
        // ⚠️ 必须修改的配置区域
        // ==========================================
        // 这里请填你之前在 Workbench 里面创建的**本地数据库名称**

        String databaseName = "cjy_test_db";

        String IP = "192.168.64.1";
        //use >>>ip route show default | awk '{print $3}'>>> to get your IP address

        String url = "jdbc:mysql://" + IP + ":3306/" + databaseName +
                     "?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";//&allowPublicKeyRetrieval=true";
        
        String username = "root";       // 默认账号
        String password = "Jerry20080515"; // 你安装 MySQL 时设置的密码
        
        // ==========================================

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. 加载驱动 (MySQL 8.0+ 专用)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 建立连接
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功！开始读取 subject 表中的数据...\n");

            // 3. 编写查询 SQL
            String sql = "SELECT * FROM subject";

            // 4. 执行查询
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 5. 打印表头（为了好看，我给它对齐了一下）
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-12s %-40s %-10s%n", "fieldPrefix", "subjectCode", "subjectName", "creditPoint");
            System.out.println("-----------------------------------------------------------------------------------------");

            // 6. 遍历结果集并打印（跟你的截图一模一样的数据

            //query SQL
            while (rs.next()) {
                String prefix = rs.getString("fieldPrefix");
                int code = rs.getInt("subjectCode");
                String name = rs.getString("subjectName");
                float credit = rs.getFloat("creditPoint");

                // 使用 printf 格式化输出，让表格对齐
                System.out.printf("%-10s %-12d %-40s %-10.1f%n", prefix, code, name, credit);
            }
            System.out.println("-----------------------------------------------------------------------------------------");

            String sql2 = "select fieldName, subjectName\n" + //
                          "from subject inner join study_field\n" + //
                          "\ton subject.fieldPrefix = study_field.fieldPrefix;";
            
            pstmt = conn.prepareStatement(sql2);
            rs = pstmt.executeQuery();

            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("%-35s %-40s%n", "fieldName", "subjectName");
            System.out.println("-----------------------------------------------------------------------------------------");
            while (rs.next()) {
                String fieldName = rs.getString("fieldName");
                String subjectName = rs.getString("subjectName");
                System.out.printf("%-35s %-40s%n", fieldName, subjectName);
            }
            System.out.println("-----------------------------------------------------------------------------------------");


            //delete SQL
            try {
                // 1. 为了安全，先关闭自动提交（防止删错数据直接写死进数据库）
                conn.setAutoCommit(false); 
    
                String deleteSql = "DELETE FROM student WHERE sid = ?";
                pstmt = conn.prepareStatement(deleteSql);
                pstmt.setInt(1, 1767173);
    
                int rowsAffected = pstmt.executeUpdate();
    
                if (rowsAffected > 0) {
                    // 2. 确实删了，才真正提交到数据库
                    conn.commit(); 
                    System.out.println(" 删除成功！");
                } else {
                    // 3. 没删到数据，回滚事务（虽然没删到，但回滚是个好习惯）
                    conn.rollback();
                    System.out.println(" 未找到目标学生，删除操作取消。");
                }
    
            } catch (SQLException e) {
                // 4. 删出错了（比如外键拦截），必须回滚，防止数据库状态变乱
                try {
                    if (conn != null) conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.err.println(" 删除异常，原因：" + e.getMessage());
                e.printStackTrace();
            }



        } catch (ClassNotFoundException e) {
            System.err.println(" 致命错误: 找不到 MySQL 驱动！");
            System.err.println(" 解决方法：请检查你的 Java 项目里是否添加了 'mysql-connector-j-8.x.x.jar' 文件。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(" 数据库操作异常！");
            System.err.println(" 可能的错误原因: 1.密码输错了; 2.数据库名字填错了; 3.MySQL 服务没启动");
            e.printStackTrace();
        } finally {
            // 7. 释放资源
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
