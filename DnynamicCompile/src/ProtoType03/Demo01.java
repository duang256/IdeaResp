package ProtoType03;

import java.io.*;
import java.sql.Date;

/**
 * 序列化，反序列化深度克隆
 */
public class Demo01 {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Date date=new Date(342415323L);
        Sheep sheep=new Sheep("少利",date);



        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(sheep);
        byte[]datas=baos.toByteArray();

        ByteArrayInputStream bais=new ByteArrayInputStream(datas);
        ObjectInputStream ois=new ObjectInputStream(bais);


        Sheep sheepClone= (Sheep) ois.readObject();

        System.out.println(sheep.getBirthday());
        System.out.println(sheepClone.getBirthday());


        date.setTime(356346545345L);

        System.out.println(sheep.getBirthday());
        System.out.println(sheepClone.getBirthday());


    }
}
