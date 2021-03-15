package ProtoType;

import java.sql.Date;
/**
 * 原型模式  被克隆类必须实现Cloneable接口
 * 浅克隆
 */
public class Demo01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date=new Date(342415323L);
        Sheep sheep=new Sheep("少利",date);
        System.out.println(sheep.getBirthday());

        Sheep sheepClone= (Sheep) sheep.clone();
        //改变对象的值
        date.setTime(5786898L);
        System.out.println(sheep.getBirthday());
        System.out.println(sheepClone.getBirthday());
    }
}
