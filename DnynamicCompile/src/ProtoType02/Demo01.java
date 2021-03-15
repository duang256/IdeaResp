package ProtoType02;
import java.sql.Date;

/**
 * 原型模式  被克隆类必须实现Cloneable接口
 * 深克隆
 */
public class Demo01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date=new Date(342415323L);
        Sheep sheep=new Sheep("少利",date);
        Sheep sheepClone= (Sheep) sheep.clone();
        System.out.println("克隆完");

        System.out.println(sheep.getBirthday());
        System.out.println(sheepClone.getBirthday());
        //改变对象的值
        date.setTime(5786898L);
        System.out.println(sheep.getBirthday());
        System.out.println(sheepClone.getBirthday());



    }
}
