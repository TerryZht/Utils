package main.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseManager {
    private static Pool pool = new Pool();

    public static Connection getConnection(){
        return pool.getConnection();
    }

    public static void close(ResultSet rs, PreparedStatement pst, Connection connection){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.close(connection);
    }

    public static void close(PreparedStatement pst, Connection connection){
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.close(connection);
    }
    public static  void close(Connection connection){
        pool.close(connection);
    }




}
