package org.java.jdbc;

import java.sql.*;
import java.util.*;

public class StatementTest {

    final static String DRIVER = "com.mysql.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/test";
    final static String USER = "root";
    final static String PWD = "123456";

    public static void main(String[] args) throws Exception{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL,USER,PWD);
        Statement statement = connection.createStatement();
        selectInfo(statement);
    }

    private static void selectInfo(Statement statement) throws SQLException{
        String sql = "SELECT * FROM INFO";
        List<Map> ListMap = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(sql);
        for (int i = 0;resultSet.next(); i++) {
            Map map = new HashMap();
            map.put("id",resultSet.getString("id"));
            map.put("name",resultSet.getString("name"));
            map.put("age",resultSet.getString("age"));
            ListMap.add(map);;
        }
        System.out.println(ListMap);
    }
    private static void insertInfo(Statement statement) throws SQLException{
        String sql = "insert into info (id,name,age) values(2,'小红',12)";
        int bool = statement.executeUpdate(sql);
        System.out.println(bool);
    }
    private static void updateInfo(Statement statement) throws SQLException {
        String sql = "update info set name='小明',age=15 where id = 2";
        int bool = statement.executeUpdate(sql);
        System.out.println(bool);
    }
    private static void deleteInfo(Statement statement) throws SQLException{
        String sql = "delete from info where id = 2";
        int bool = statement.executeUpdate(sql);
        System.out.println(bool);
    }

}
