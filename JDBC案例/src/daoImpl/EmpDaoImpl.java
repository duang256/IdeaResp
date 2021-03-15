package daoImpl;

import dao.EmpDao;
import pojo.Emp;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //查询员工信息
    public ArrayList<Emp> selAllEmpInfo(){
        //声明集合对象
        ArrayList<Emp> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn= JdbcUtil.getConn();
            String sql="select *from emp";
            ps=JdbcUtil.getPreSta(conn,sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setComm(rs.getInt("comm"));
                emp.setDate(rs.getDate("hiredate"));
                emp.setDeptno(rs.getInt("Deptno"));
                emp.setEname(rs.getString("Ename"));
                emp.setJob(rs.getString("Job"));
                emp.setMgr(rs.getString("Mgr"));
                emp.setSal(rs.getInt("Sal"));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(conn,rs,ps);
        }
        return list;
    }
    //根据编号查询员工信息
    public Emp selEmpInfoByEmpno(int empno){
        //声明jdbc变量
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Emp e=null;

        try {
            conn=JdbcUtil.getConn();
            String sql="select *from emp where empno=?";
            ps=JdbcUtil.getPreSta(conn,sql);
            ps.setObject(1,empno);
            rs=ps.executeQuery();
            if(rs.next()){
                e=new Emp();
                e.setEmpno(rs.getInt("empno"));
                e.setComm(rs.getInt("comm"));
                e.setDate(rs.getDate("hiredate"));
                e.setDeptno(rs.getInt("Deptno"));
                e.setEname(rs.getString("Ename"));
                e.setJob(rs.getString("Job"));
                e.setMgr(rs.getString("Mgr"));
                e.setSal(rs.getInt("Sal"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            JdbcUtil.closeAll(conn,rs,ps);
        }
        return e;
    }
    //添加员工信息
    public int insEmpInfo(int empno,String ename,String job,int mgr,java.util.Date hiredate,double sal,double comm,int deptno){
        String sql="insert into emp values(?,?,?,?,?,?,?,?)";
        //将util Date 转化成sql date,固定操作
        java.sql.Date d=new java.sql.Date(hiredate.getTime());
        int i=JdbcUtil.excuteDml(sql,empno,ename,job,mgr,d,sal,comm,deptno);
        return i;
    }
    //更改员工姓名
    public int upEmp(String newname,int empno){
        return  JdbcUtil.excuteDml("update emp set ename=? where empno=?",newname,empno);

    }
    //删除员工信息
    public int delEmp(int empno){
        return  JdbcUtil.excuteDml("delete from emp where empno=?",empno);
    }


}
