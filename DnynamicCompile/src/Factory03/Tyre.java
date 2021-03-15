package Factory03;

public interface Tyre {
    void revolve();
}


class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("不磨损");
    }
}
class LowerTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("磨损快");
    }
}

