package dao;

import pojo.Emp;

import java.util.ArrayList;

public interface EmpDao {
    //查询所有员工信息
    public ArrayList<Emp> selAllEmpInfo();
    //按编号查询员工信息
    public Emp selEmpInfoByEmpno(int empno);
    //添加员工信息
    public int insEmpInfo(int empno,String ename,String job,int mgr,java.util.Date hiredate,double sal,double comm,int deptno);
    //更新员工信息
    public int upEmp(String newname,int empno);
    //删除员工信息
    public int delEmp(int empno);
}
