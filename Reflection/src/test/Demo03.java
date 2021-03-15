package test;

import bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo03 {
    public static void main(String[] args) {
        String path="bean.User";
        Class clazz= null;
        try {
          clazz=Class.forName(path);
            System.out.println(clazz.getSimpleName());
            System.out.println(clazz.getName());
            System.out.println(clazz.hashCode());

            //属性Field
            Field field=clazz.getDeclaredField("Uname");
            Field[] fields=clazz.getDeclaredFields();
            //方法Method
            Method method=clazz.getDeclaredMethod("setUname", String.class);
            Method []method1=clazz.getDeclaredMethods();
            //构造器
            Constructor cc=clazz.getConstructor(int.class,int.class,String.class);
            Constructor[]constructors=clazz.getDeclaredConstructors();


            //创建和调用
            //1
            User u= (User) clazz.newInstance();
            //2
            Constructor constructor=clazz.getConstructor(int.class,int.class,String.class);
            constructor.newInstance();

            //属性Field
            Field field1=clazz.getDeclaredField("age");
            //私有属性不能外部类调用，此方法是调用时不对这个属性进行安全检查
            field.setAccessible(true);
            User u3= (User) clazz.newInstance();
            field1.set(u3,18);

            //方法Method
            Method method2=clazz.getDeclaredMethod("setUname", String.class);
            User u4= (User) clazz.newInstance();
            method2.invoke(u4,"颜太");




        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
