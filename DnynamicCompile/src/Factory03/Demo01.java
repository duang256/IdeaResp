package Factory03;

public class Demo01 {
    public static void main(String[] args) {
        CarFactory factory=new LuxuryCar();
        Engine e=factory.createEngine();
        e.run();
    }
}
