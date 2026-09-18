package MySQL_system.db_config;


import java.util.ArrayList;
import java.util.Properties;


public abstract class DBConfig {
    
    protected String dbName;
    protected String hostIP;
    protected String port;

    protected String username;
    protected String password;

    protected ArrayList<String> paramList;


    protected static final String configErr = "failed to create MySQL configuration object";


    public DBConfig(Properties props) {
        if (props == null) {
            throw new IllegalArgumentException(configErr + ": Properties cannot be null");
        }

        this.dbName = props.getProperty("db.name", null);
        this.hostIP = props.getProperty("db.host", null);
        this.port = props.getProperty("db.port", null);
        this.username = props.getProperty("db.username", null);
        this.password = props.getProperty("db.password", null);
        this.paramList = new ArrayList<>();
        for (String key : props.stringPropertyNames()) {
            if (key.startsWith("db.param.")) {
                String paramName = key.substring("db.param.".length());
                String paramValue = props.getProperty(key);
                paramList.add(paramName + "=" + paramValue);
            }
        }
    }

    public Boolean isValid() {
        return this.dbName != null && !this.dbName.isBlank() && 
               this.hostIP != null && !this.hostIP.isBlank() &&
               this.password != null && !this.password.isBlank() &&
               this.port != null && !this.port.isBlank() &&
               this.username != null && !this.username.isBlank();
    }

    public String getClassName() {
        return "DBConfig";
    }

    public String getUsername() {
        return this.username;
    }

    public  String getPassword() {
        return this.password;
    }

    public String getDBName() {
        return this.dbName;
    }


    public abstract String getDBURL();


    protected String buildParams() {
        if (paramList == null || paramList.isEmpty()) {
            return "";
        }

        return "?" + String.join("&", paramList);
    }

}
