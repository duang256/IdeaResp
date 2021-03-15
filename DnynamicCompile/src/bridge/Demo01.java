package bridge;

public class Demo01 {
    public static void main(String[] args) {
        //用组合代替继承关系
        Computer c=new Pad(new Lenovo());
        c.sale();
    }
}
