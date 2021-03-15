package Factory03;

public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}


class LuxuryCar implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return  new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return  new LuxuryTyre();
    }
}

class Lower implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowerSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowerTyre();
    }
}