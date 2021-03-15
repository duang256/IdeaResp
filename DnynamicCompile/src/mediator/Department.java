package mediator;

public interface Department {
    void selfAction();
    void outAction();
}




class Development implements Department{

    private Mediator m;

    Development(Mediator m) {
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心研发");
    }

    @Override
    public void outAction() {
        System.out.println("需要资金支持");
        m.command("financial");
    }
}


class Financial implements Department{
    private Mediator m;

    Financial(Mediator m) {
        this.m = m;
        m.register("financial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱");
    }

    @Override
    public void outAction() {
        System.out.println("提交报表");
    }
}
class Market implements Department{
    private Mediator m;

    Market(Mediator m) {
        this.m = m;
        m.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("卖产品");
    }

    @Override
    public void outAction() {
        System.out.println("销售报告");
    }
}