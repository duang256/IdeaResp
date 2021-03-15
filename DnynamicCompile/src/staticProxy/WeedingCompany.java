package staticProxy;

public class WeedingCompany implements Wedding{
    private Lovers lovers;

    public WeedingCompany(Lovers lovers) {
        this.lovers = lovers;
    }

    public WeedingCompany() {
    }

    @Override
    public void ready() {
        System.out.println("前期准备");
    }

    @Override
    public void kiss() {
        this.lovers.kiss();
    }

    @Override
    public void over() {
        System.out.println("善后工作");
    }
}
