package template;

public class Demo01 {
    public static void main(String[] args) {
        BankTemplateMethod btm=new DrawMoney();
        btm.process();
    }
}

class DrawMoney extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("取钱");
    }
}