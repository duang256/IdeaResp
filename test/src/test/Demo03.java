package test;

import Dao.StudentDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入新的昵称： ");
        String newName=sc.next();
        StudentDaoImpl sd=new StudentDaoImpl();
        int i=sd.UpdateName(newName);
        //业务逻辑不能写到数据库操作当中
        if(i>0){
            System.out.println("昵称更改成功");
        }
    }
}


