package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static  String driver;
    private static String url;
    private static String pwd;
    private static String user;
    //获取属性文件的内容，类加载驱动
    static {
        //创建properties对象获取属性文件的内容
        Properties p=new Properties();
        //获取属性文件的读取流对象(JdbcUtil.class.会动态定位目前的项目src目录)
        InputStream is=JdbcUtil.class.getResourceAsStream("/db.properties");
        //加载属性配置文件
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver= p.getProperty("driver");
        url= p.getProperty("url");
        pwd= p.getProperty("pwd");
        user= p.getProperty("user");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //解决Connection冗余
    public static Connection getConn(){
        Connection conn=null;
        try {
             conn= DriverManager.getConnection(url,user,pwd);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }



    //解决Statement冗余

    public static PreparedStatement getPreSta( Connection conn,String sql){
        PreparedStatement ps=null;
        try {
             ps=conn.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;

    }

    public static Statement getSta(Connection conn,String sql){
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
            return stmt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public static void closeAll(Connection conn,ResultSet rs,Statement stmt){
        //关闭资源
        try {
            rs.close();
        } catch (SQLException e) {

        }
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

    public static int excuteDml(String sql,Object...objs){

            Connection conn=null;
            PreparedStatement ps=null;
            try {
                //获取数据库连接对象
                conn= JdbcUtil.getConn();
                conn.setAutoCommit(false);
                //获取sql命令对象
                ps= conn.prepareStatement(sql);
                for(int i=0;i<objs.length;i++){
                    ps.setObject(i+1,objs[i]);
                }
                int i=ps.executeUpdate();
                conn.commit();
                JdbcUtil.closeAll(conn,null,ps);
                return i;
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
            return 0;

    }



}
