package MySQL_system.db_config;


import java.util.Properties;


public class MySQLConfig extends DBConfig {

    public MySQLConfig(Properties props) {
        super(props);
    }

    @Override
    public String getClassName() {
        return "MySQLConfig";
    }
    
    @Override
    public String getDBURL() {
        if (!this.isValid()) {
            throw new IllegalStateException(configErr + ": MySQL configuration is incomplete or invalid.");
        }

        return "jdbc:mysql://" + hostIP +
               ":" + port +
               "/" + dbName + 
               buildParams();
    }

}
