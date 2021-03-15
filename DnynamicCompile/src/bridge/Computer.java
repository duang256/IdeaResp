package bridge;

public class Computer {
    protected Brand brand;
    public  Computer(Brand b){
        this.brand=b;
    }


    public void sale(){
        brand.sale();
    }
}


class DeskTop extends Computer{
    public DeskTop(Brand b) {

        super(b);
        System.out.println("销售台式机");
    }
}

class Pad extends  Computer{

    public Pad(Brand b) {
        super(b);
        System.out.println("销售平板");
    }
}