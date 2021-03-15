package serviceImpl;

import dao.EmpDao;
import dao.EmpServiceDao;
import daoImpl.EmpDaoImpl;
import pojo.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class EmpServiceImpl implements EmpServiceDao {
    EmpDao ed=  new EmpDaoImpl();
    //更新用户信息
    public void upEmp(){
        //获取用户数据
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户编号");
        int empno=sc.nextInt();
        System.out.println("请输入新的用户名");
        String newName=sc.next();//next无法输入带空格回车的字符串
        int i=ed.upEmp(newName,empno);
        //提示用户更新结果
        if(i>0){
            System.out.println("更新 成功");
        }else{
            System.out.println("更新 失败");
        }
    }
    public void insEmp(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户编号");
        int empno=sc.nextInt();
        System.out.println("请输入新增用户名");
        String ename=sc.next();
        System.out.println("请输入新增用户工作");
        String job=sc.next();
        System.out.println("请输入新增用户领导编号");
        int mgr=sc.nextInt();
        System.out.println("请输入新增用户的入职日期（YYYY-MM-DD）");
        String date=sc.next();
        System.out.println("请输入新增用户基本工资");
        double sal =sc.nextDouble();
        System.out.println("请输入新增用户提成");
        double comm =sc.nextDouble();
        System.out.println("请输入新增用户的部门编号");
        int deptno=sc.nextInt();
        //获取数据库操作对象
        //将字符串类型的日期转换成Date类型
        java.util.Date hiredate=null;
        try {
            hiredate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i=ed.insEmpInfo(empno,ename,job,mgr,hiredate,sal,comm,deptno);
        if(i>0){
            System.out.println("增加成功");
        }else{
            System.out.println("增加失败");
        }

    }
    public void delEmp(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的员工编号：");
        int empno=sc.nextInt();
        //获取数据库对象
        int i=ed.delEmp(empno);
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    //根据用户编号进行查询
    public void searchEmp(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要查询的员工编号");
        int empno=sc.nextInt();
        Emp emp=ed.selEmpInfoByEmpno(empno);
        System.out.println(emp);
    }

    //查询全部员工信息
    public void searchAllEmp(){
        List<Emp> list =ed.selAllEmpInfo();
        for(int i=0;i<list.size();i++){
            Emp emp=list.get(i);
            System.out.println(emp+"\n");
        }
    }
}
