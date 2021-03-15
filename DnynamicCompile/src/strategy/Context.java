package strategy;

public class Context {
    //当前算法对象
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }


    public void printPrice(double s){
        System.out.println(strategy.getPrice(s));
    }
}
