package adapter;

//适配器
public class Adapter  implements Target{

    private Adpatee adpatee;

    public Adapter(Adpatee adpatee) {
        this.adpatee=adpatee;
    }

    @Override
    public void handleRequest() {
        this.adpatee.request();
    }
}
