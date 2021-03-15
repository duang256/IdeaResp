package menmento;

public class Demo01 {
    public static void main(String[] args) {
        CareTaker taker=new CareTaker();
        Emp emp=new Emp("颜悦",19,0);
        System.out.println(emp.getAge());

        taker.setMenmento(emp.menmento());
        emp.setAge(30);

        System.out.println(emp.getAge());

        emp.recover(taker.getMenmento());
        System.out.println(emp.getAge());


    }
}
