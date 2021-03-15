package state;

public class Demo01 {
    public static void main(String[] args) {
        HomeContext context=new HomeContext();
        context.setState(new FreeState());
    }
}
