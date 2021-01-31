package org.java.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreparedStatementTest {

    final static String DRIVER = "com.mysql.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/test";
    final static String USER = "root";
    final static String PWD = "123456";

    @Test
    public void JdbcTest() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
//        addInfo(connection,5,"小法",16);
//        updateInfo(connection,5,"小法法",11);
//        delInfo(connection,4);
        getInfo(connection);
        connection.close();
    }

    private static void getInfo(Connection connection,Integer... id) throws SQLException {
        List<Map<String,Object>> mapList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM INFO ");
        if(id.length>0){
            sql.append("WHERE id = ?");
        }
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        if(id.length>0){
            preparedStatement.setInt(1,id[0]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        for (int i = 0;resultSet.next(); i++) {
            Map map = new HashMap();
            map.put("id",resultSet.getString("id"));
            map.put("name",resultSet.getString("name"));
            map.put("age",resultSet.getString("age"));
            mapList.add(map);
        }
        System.out.println(mapList);
        resultSet.close();
    }

    private static void addInfo(Connection connection,Object... Infos) throws SQLException{
        String sql = "INSERT INTO INFO(id,name,age) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (Integer) Infos[0]);
        preparedStatement.setString(2, (String) Infos[1]);
        preparedStatement.setInt(3, (Integer) Infos[2]);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    private static void updateInfo(Connection connection,Object... Infos) throws  SQLException{
        String sql = "UPDATE INFO SET name = ?,age = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, (String) Infos[1]);
        preparedStatement.setInt(2, (Integer) Infos[2]);
        preparedStatement.setInt(3, (Integer) Infos[0]);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    private static void delInfo(Connection connection,Integer id) throws  SQLException{
        String sql = "DELETE FROM INFO WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
}
