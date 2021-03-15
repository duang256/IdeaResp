package observer02;

public class Demo01 {
    public static void main(String[] args) {
        ConcreteSub cs=new ConcreteSub();
        ObserverA oa=new ObserverA();
        ObserverA oa2=new ObserverA();
        ObserverA oa3=new ObserverA();
        cs.addObserver(oa);
        cs.addObserver(oa2);
        cs.addObserver(oa3);
        cs.setState(999);
        System.out.println(oa.getState());

        System.out.println(oa2.getState());

        System.out.println(oa3.getState());

    }
}
