package test;

import Dao.StudentDaoImpl;
import pojo.Student;

import java.sql.*;
import java.util.ArrayList;

public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //声明List集合
        StudentDaoImpl sd=new StudentDaoImpl();
        ArrayList<Student>list=sd.Search();
        System.out.println(list.get(2));


    }
}
