package builder;

public class LRDirector implements Director {
    private  LRCarBuilder builder;

    public LRDirector(LRCarBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Car directCar() {
       Engine e=builder.builderEngine();
       Seat s=builder.builderSeat();
       Tyre t=builder.builderTyre();

       Car car=new Car();
       car.setEngine(e);
       car.setSeat(s);
       car.setTyre(t);

       return car;
    }
}
