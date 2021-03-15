package iterator;

public class Demo01 {
    public static void main(String[] args) {
        ConcreteMyAggregate cma=new ConcreteMyAggregate();
        cma.addObj("aa");
        cma.addObj("bb");
        cma.addObj("cc");

        MyIterator iter=cma.createIterator();
        while(iter.hasNext()){
            System.out.println(iter.getCurrentObj());
            iter.next();
        }
    }

}
