package preparedStatementImpl;

import pojo.User;
import util.JdbcUtil;


import java.sql.*;
import java.util.ArrayList;

/**
 * 完成用户登录
 */
public class UserDaoImpl {


    //删除操作
    public int delUser(int unum){
        return JdbcUtil.excuteDml("delete tuser where unum=?",unum);

    }


    //增加数据
    public int insUser(int unum,String uname,String upwd){
        return JdbcUtil.excuteDml("insert into tuser values(?,?,?)",unum,uname,upwd);

    }


    //更新数据
    public int upUser(int unum,String upwd){
        return JdbcUtil.excuteDml("update tuser set upwd=? where unum=?",upwd,unum);

    }




    //查询一条数据
    public User getUserInfo(String uname,String upwd){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //加载类驱动
            //创建数据库连接
            conn=JdbcUtil.getConn();
            //创建SQL命令
            String sql="select *from tuser where uname=? and upwd=?";
            ps=conn.prepareStatement(sql);
            ps.setObject(1,uname);
            ps.setObject(2,upwd);
            //在进行查询的时候rs不要传入sql 而且要在占位符赋值之后进行操作
            rs=ps.executeQuery();
            while(rs.next()){
                User u=new User();
                u.setUname(uname);
                u.setUpwd(upwd);
                return u;
            }
            JdbcUtil.closeAll(conn,rs,ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}




