package testAnnotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo03{
    public static void main(String[] args) {
        try {
            Class clazz=Class.forName("testAnnotation.SxtStudent");
            //获得这个类上面所有的注解，放进注解数组当中
            Annotation[] annotations= clazz.getAnnotations();

            for (Annotation a:annotations
                 ) {
                System.out.println(a);
            }

            //第二种方式，直接获得类的指定注解
            SxtTable st= (SxtTable) clazz.getAnnotation(SxtTable.class);
            System.out.println(st);
            System.out.println(st.value());

            //获得类的属性的注解（方法同理）
            Field f=clazz.getDeclaredField("studentName");
            SxtField sxtField=f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());

            //根据获得的这些信息拼出DD语句，使用JDBC执行SQL，在数据空中形成表
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



