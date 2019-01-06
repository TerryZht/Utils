package main.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static   void exportTab(List<Integer> tabinfo){
        Connection connection = DataBaseManager.getConnection();
        int begin  = tabinfo.get(0);
        int end = tabinfo.get(1);
        String sql =  "insert into btest(b) select b from atest where id>=? and id<=?";
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,begin);
            preparedStatement.setInt(2,end);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.exit(1);
            e.printStackTrace();
        }

        DataBaseManager.close(preparedStatement,connection);
    }



}
