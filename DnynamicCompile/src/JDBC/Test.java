package JDBC;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class Test {

    static Properties pros=null;
    static {
        pros=new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConn(){
        try {
            Class.forName(pros.getProperty("msqlDriver"));
            return DriverManager.getConnection
                    (pros.getProperty("msqlURL"),pros.getProperty("msqlUser"), pros.getProperty("msqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public static void close(ResultSet rs, Connection conn, PreparedStatement ps){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close( Connection conn, PreparedStatement ps){

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
