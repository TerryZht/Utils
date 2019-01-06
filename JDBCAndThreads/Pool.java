package main.com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Pool {
    private static DBConfigure conf;
    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("main/com/jdbc/db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        conf = new DBConfigure();
        conf.setUrl(properties.getProperty("url"));
        conf.setUsername(properties.getProperty("username"));
        conf.setMin_pool(properties.getProperty("min_pool"));
        conf.setMax_pool(properties.getProperty("max_pool"));
        conf.setPwd(properties.getProperty("password"));
        conf.setDirver(properties.getProperty("driver"));
        conf.setDbnum(Integer.parseInt(properties.getProperty("dbnum").trim()));
        conf.setDbsplit(Integer.parseInt(properties.getProperty("dbsplit").trim()));
    }
    private static List<Connection> pool;
    private int max_pool = Integer.parseInt(conf.getMax_pool().trim());
    private int min_pool = Integer.parseInt(conf.getMin_pool().trim());
    private Connection createConnection(){
        Connection connection = null;
        try {
            Class.forName(conf.getDirver());
            connection = DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPwd());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void InitPool(){
        if(pool==null){
            pool=new ArrayList<>();
        }
        while (pool.size()<min_pool){
            pool.add(createConnection());
        }
    }
    public synchronized Connection getConnection(){
        int lastindex = pool.size()-1;
        Connection connection = pool.get(lastindex);
        pool.remove(lastindex);
        return connection;
    }
    public synchronized void close(Connection connection){
        if(pool.size()>=max_pool){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.add(connection);

    }
    public static DBConfigure getConfig(){
        return conf;
    }
    public Pool(){
        InitPool();
    }



}
