package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * oracle.jdbc.driver.OracleDriver
 */
public class Demo02 {
    public static void main(String[] args) {
        String driver="oracle.jdbc.driver.OracleDriver";
        String username="scott";
        String password="bjxst";
        String url="jdbc:oracle:thin:@//localhost:1521/XE";
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            stmt=conn.createStatement();
            String sname="张三三";
            String sql=" update student set SNAME='望山2' where SNUM=4";
            String sql2=" update student set SNAME2='望山' where SNUM=4";
            int i=stmt.executeUpdate(sql);
            int i2=stmt.executeUpdate(sql2);
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
