package test;

import pojo.User;
import preparedStatementImpl.UserDaoImpl;


import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname=sc.next();
        System.out.println("请输入密码：");
        String upwd=sc.next();
        System.out.println(uname+":"+upwd);

        UserDaoImpl ud=new UserDaoImpl();
        User u=ud.getUserInfo(uname,upwd);

        //判断返回值
        if(u!=null){
            System.out.println("用户登陆成功");
        }else{
            System.out.println("用户名或密码错误，请重新登录");
        }

    }
}
