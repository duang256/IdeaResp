package JDBC;

import java.sql.*;

//测试跟数据库进行连接
public class Demo01 {
    public static void main(String[] args)  {
        Connection conn=null;
        Statement stm=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/textjdbc","root", "123456");
            conn.setAutoCommit(false);
            stm=conn.createStatement();
            for (int i=0;i<1000;i++){
                stm.addBatch("insert into u_name(u_age,u_name)values(20,'精神小伙"+i+"')");

            }
            stm.executeBatch();
            conn.commit();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
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
