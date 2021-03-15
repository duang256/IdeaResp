package strategy;

public class Demo01 {
    public static void main(String[] args) {
        Strategy strategy=new OldMany();
        Context context=new Context(strategy);
        context.printPrice(100000);
    }
}
