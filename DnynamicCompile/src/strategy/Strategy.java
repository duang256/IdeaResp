package strategy;

public interface Strategy {
    public double getPrice(double price);
}


class NewFew implements Strategy{
    @Override
    public double getPrice(double price) {
        return price;
    }
}


class NewMany implements Strategy{
    @Override
    public double getPrice(double price) {
        return 0.9*price;
    }
}

class OldFew implements  Strategy{
    @Override
    public double getPrice(double price) {
        return 0.85+price;
    }
}

class OldMany implements Strategy{
    @Override
    public double getPrice(double price) {
        return 0.8*price;
    }
}