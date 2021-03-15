package builder;

public class LRCarBuilder implements CarBuilder{

    @Override
    public Engine builderEngine() {
        return new Engine("路虎发动机");
    }

    @Override
    public Seat builderSeat() {
        return new Seat("路虎座椅");
    }

    @Override
    public Tyre builderTyre() {
        return new Tyre("路虎米其林轮胎");
    }
}
