package Dao;

import pojo.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDaoImpl {
    public  int UpdateName(String newName){

        String driver="oracle.jdbc.driver.OracleDriver";
        String username="scott";
        String password="bjxst";
        String url="jdbc:oracle:thin:@//localhost:1521/XE";
        String sql=" update student set SNAME='"+newName+"' where SNUM=1";
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            stmt=conn.createStatement();

            int i=stmt.executeUpdate(sql);
            return i;
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
            return -1;
        }

    }




    public ArrayList Search() throws ClassNotFoundException, SQLException {
        //声明List集合
        ArrayList<Student>list=new ArrayList<>();
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","scott","bjxst");
        //创建SQL命令对象
        Statement stmt=conn.createStatement();
        //创建SQL命令
        String sql="select *from student";
        //执行SQL命令
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            Student stu=new Student();
            stu.setSnum(rs.getInt("snum"));
            stu.setSname(rs.getString("sname"));
            stu.setSage(rs.getInt("sage"));
            list.add(stu);
        }
        return list;
    }










}
