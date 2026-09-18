package MySQL_system;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import MySQL_system.SQLServer.SQLServer;
import MySQL_system.SQLServer.query_interface.MutipleQuery;
import MySQL_system.SQLServer.query_interface.Query;
import MySQL_system.db_config.*;
import unimelb_grading_sys.backup_file.DBHelper;
import MySQL_system.SQLServer.SQLServer;

public class Test {

    public static final String property_url = "/home/cjy/OOSD_2026S2_Jerry.C/src/MySQL_system/DBInfo.properties";
    
    public static void main(String[] args) {
        
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Path.of(property_url))) {
            props.load(in);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        DBConfig config = new MySQLConfig(props);

        System.out.println(config.getDBURL());

        System.out.println(config.getUsername());
        System.out.println(config.getPassword());

        System.out.println(config.getClassName());


        /* String insertSQL = "insert into subject (fieldPrefix, subjectCode, subjectName, creditPoint) values (?, ?, ?, ?)";
        String[] params = {"INFO", "30006", "Information Security and Privacy", "12.5"};
        DBHelper.executeUpdate(insertSQL, pstmt -> {
            try {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setString(i + 1, params[i]);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }); */


        String sql = "select * from subject order by subjectCode asc";
        String[] keyOrder = {"fieldPrefix", "subjectCode", "creditPoint", "subjectName"};
        SQLServer dbServer = new SQLServer(new MutipleQuery());
        List<Map<String, Object>> rl = (List<Map<String, Object>>)dbServer.executeQuery(config, sql,null);

        for (Map<String, Object> map : rl) {
            for (String key : keyOrder) {
                Object value = map.get(key);
                System.out.printf("%-15s", value);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");


        System.exit(0);
    }

}
