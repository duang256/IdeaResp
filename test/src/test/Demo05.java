package test;

import Dao.StudentDaoImpl2;

import java.sql.SQLException;
import java.util.ArrayList;

public class Demo05 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       //创建Dao层对象
        StudentDaoImpl2 sd2=new StudentDaoImpl2();
       // 查询
        ArrayList list=sd2.getStudentInfo();
        System.out.println(list.get(2));
        //删除
//        sd2.delStu(1);
        //更改
//        sd2.upStu(2,"张三");
        //增加
//        sd2.insStu("你爷爷我",78);
    }
}
