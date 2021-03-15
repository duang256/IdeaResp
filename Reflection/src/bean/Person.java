package bean;

public class Person {
    public String pname;
    protected  int page;
    String pfav;
    private  String psex;
    public String pHi(){
        return "reflect";
    }
    public  String  pHi(int num,String str) {
        return str+num;
    }
    protected void  pHello(){
        System.out.println("Student.pHello");
    }
    private void  pHello1(){
        System.out.println("pHello1");
    }
    void  pHello2(){
        System.out.println("pHello2");
    }
}
