package bean;

public class Student extends Person {
    //声明实体类的属性
    public String sname;
    protected int sage;
    String sfav;
    private String ssex;
    public static int money=10000;

    public Student() {
    }
    public String sHi(){
        System.out.println("123");
        return "reflect";
    }
    public  String sHi(int num,String str) {
        return str+num;
    }
    public  static  void sHiStatic(int num) {
        System.out.println(num);
    }
    protected void sHello(){
        System.out.println("Student.sHello");
    }
    private void sHello1(){
        System.out.println("sHello1");
    }
    void sHello2(){
        System.out.println("sHello2");
    }

}
