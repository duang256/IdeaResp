package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取类对象
        Class cla=Class.forName("bean.Student");
        //获取类属性
        Field[]fds=cla.getFields();
        //高级for循环    getFields中获取的全部是public修饰符所修饰的
//        for(Field f:fds){
//            //获取子类和父类中的属性名称
//            System.out.println("获取属性名---》"+f.getName());
//            //修饰符表示的数字
//            System.out.println("获取修饰符"+f.getModifiers());
//            //获取属性类型   返回属性类型的Class对象  java.lang.String   int
//            System.out.println("获取属性类型"+f.getType());
//            //获取指定字段   只能获取本类和父类公共字段属性
//            Field field=cla.getField("pname");
//            System.out.println(field.getName());
//            //获取父类指定非公共字段属性
//            Field field1=cla.getSuperclass().getDeclaredField("pname");
//            System.out.println(field1.getName());
//
//            //操作字段值
//              //操作静态字段
//            Field field2=cla.getDeclaredField("money");
//            field2.set(null,30000);
//            //获取静态属性值     get(null)表示是静态属性，不用传递对象名，如果操作非静态就需要传递对象
//            System.out.println(field2.get(null));
//             //操作非静态字段
//            Field field3=cla.getDeclaredField("sname");
//            field3.set(cla.newInstance(),"james");
//            //获取非静态属性值
//            System.out.println(field3.get(cla.newInstance()));
//        }


        //获取方法对象，同样的和属性一样，有getMethod和getDeclareMethod
            //获取所有声明的方法
        Method[] methods=cla.getDeclaredMethods();
        for (Method m:methods
             ) {
            System.out.println(m.getName());
        }
        System.out.println("**************************************");
            //获取本类和父类所有公共方法
        Method[] methods2=cla.getMethods();
        for (Method m:methods2
        ) {
            System.out.println(m.getName());
        }
            //获取指定的公共方法
        Method md=cla.getDeclaredMethod("sHi",int.class,String.class);
        System.out.println(md.getName());
            //调用静态方法
        Method md2=cla.getDeclaredMethod("sHiStatic", int.class);
        md2.invoke(null,1);
            //调用非静态方法
        Method md3=cla.getDeclaredMethod("sHi",null);
        md3.invoke(cla.newInstance());













    }
}
