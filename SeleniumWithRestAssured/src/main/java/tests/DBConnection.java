package tests;

import java.sql.*;

public class DBConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/FREEPDB1","ADITYA","aditya123");
        connection.getAutoCommit();
        String query = "Select * from projects";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}
