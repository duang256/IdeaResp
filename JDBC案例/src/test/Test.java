package test;

import serviceImpl.EmpServiceImpl;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        EmpServiceImpl es=new EmpServiceImpl();
        do{
            System.out.println("*******************欢迎访问员工管理系统：请选择服务**************************");
            System.out.println("*********************************************");
            System.out.println("1.查询所有员工信息");
            System.out.println("2.根据编号查询员工信息");
            System.out.println("3.新增员工信息");
            System.out.println("4.修改员工姓名");
            System.out.println("5.删除员工信息");
            System.out.println("6.退出系统");
            Scanner sc=new Scanner(System.in);
            int ch=sc.nextInt();
            switch (ch){
                case 1:es.searchAllEmp();
                break;
                case 2:es.searchEmp();
                    break;
                case 3:es.insEmp();
                    break;
                case 4:es.upEmp();
                    break;
                case 5:es.delEmp();
                    break;
                case 6:
                    System.out.println("谢谢使用");return;
                default:
                    System.out.println("输入有误");
                    break;
            }

        }while (true);

    }

}
