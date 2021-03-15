package observer;

public class Demo01 {
    public static void main(String[] args) {
        ConcreteSub concreteSub=new ConcreteSub();
        Observer observer1=new ObserveA();
        Observer observer2=new ObserveA();
        Observer observer3=new ObserveA();
        concreteSub.register(observer1);
        concreteSub.register(observer2);
        concreteSub.register(observer3);
        concreteSub.setState(15000);
        concreteSub.setState(2000);



    }
}
