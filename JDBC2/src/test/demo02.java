package test;

import pojo.User;

import java.sql.*;

public class demo02 {
    public static void main(String[] args) {

        Connection conn=null;
        Statement stmt=null;

        //加载驱动
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接对象
            conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","scott","bjxst");
            //创建SQL命令对象
            stmt=conn.createStatement();

            //创建SQL命令
            String sql="update tuser set uname='朱古力' where unum=9 ";
            int i = stmt.executeUpdate(sql);
            System.out.println(i);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
