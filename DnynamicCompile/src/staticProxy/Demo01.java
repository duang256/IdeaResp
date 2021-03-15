package staticProxy;

public class Demo01 {
    public static void main(String[] args) {
        Lovers lovers=new Lovers();
        Wedding wedding=new WeedingCompany(lovers);
        wedding.ready();
        wedding.kiss();
        wedding.over();
    }
}
