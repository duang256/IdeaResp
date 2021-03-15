package test;

/**
 * 测试java.lang.Class对象的获取方式
 */
@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cla=Class.forName("");
        System.out.println("获取类对象的包名"+cla.getPackage());
        System.out.println("获取类的修饰符"+cla.getModifiers());
        System.out.println("获取类的名称（全限定）"+cla.getName());
        System.out.println("获取类名"+cla.getSimpleName());
        System.out.println("获取父类类对象"+cla.getSuperclass());


        String path="bean.User";
        try {
            //一个类只对应一个反射对象
            Class clazz=Class.forName(path);
            System.out.println(clazz);
            System.out.println(clazz.hashCode());
            System.out.println(clazz.getName());


            Class strClazz=String.class;
            Class strClazz2=path.getClass();

            System.out.println(strClazz);
            System.out.println(strClazz2);
            System.out.println(strClazz==strClazz2);

            Class intClazz =int.class;

            int [] a=new int[10];
            int []array=new int[30];
            int [][]array2=new int[2][4];

            System.out.println(a.getClass().hashCode());
            System.out.println(array.getClass().hashCode());
            System.out.println(array.getClass().hashCode());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
