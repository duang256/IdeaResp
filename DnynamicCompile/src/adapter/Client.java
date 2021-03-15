package adapter;



//客户类
public class Client {

    public void test(Target t){
        t.handleRequest();
    }

    public static void main(String[] args) {
        Client c=new Client();
        Adpatee a=new Adpatee();
        Target t=  new Adapter(a);
        c.test(t);
    }

}