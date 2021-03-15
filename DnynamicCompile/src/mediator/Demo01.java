package mediator;

public class Demo01 {
    public static void main(String[] args) {
        Mediator m=new President();
        Market market=new Market(m);
        Development development=new Development(m);
        Financial financial=new Financial(m);

        development.selfAction();
        development.outAction();

    }


}
