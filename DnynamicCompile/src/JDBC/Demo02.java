package JDBC;

import javax.xml.soap.Text;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 测试事务
 */
public class Demo02 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn= Test.getMysqlConn();
            ps=conn.prepareStatement("select * from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
           List<Map<String ,Object>>list=new ArrayList<>() ;
           while(rs.next()){
                Map<String ,Object>row=new HashMap<>();
                row.put("name",rs.getObject(2));
                row.put("salary",rs.getObject(3));
                row.put("age",rs.getObject(5));
                list.add(row);
            }
            for (Map<String, Object> row :list
                    ) {
                for (String key :row.keySet()
                        ) {
                    System.out.print(row.get(key)+"\t");
                }
                System.out.println("");
            }




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Test.close(rs,conn,ps);
        }
    }


}
