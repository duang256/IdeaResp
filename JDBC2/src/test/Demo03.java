package test;

import preparedStatementImpl.UserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDaoImpl ud=new UserDaoImpl();
        System.out.println(ud.insUser(8,"奥特曼","变身"));
    }
}
