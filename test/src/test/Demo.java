package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 导入jdbc驱动包
 * 加载驱动  Class.forName("oracle.jdbc.OracleDriver");//包名+类名加载驱动
 * 获取数据库连接对象 （连接指定的数据库）
 * 获取SQL命令对象
 */
public class Demo {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@//localhost:1521/XE";
        String username="scott";
        String password="bjxst";
        try {
            Class.forName(driver);//包名+类名加载驱动
             conn= DriverManager.getConnection(url,username,password);
             stmt=conn.createStatement();// 这个类是conn连接数据库相关的//    编译并发送SQL命令给数据库
            String  sql="insert into city values(8,'麻将学院','北京')";
            //执行SQL命令
            //如果没有执行成功返回-1，如果成功返回更改的数据条数
            int i=stmt.executeUpdate(sql);
            //关闭资源
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
