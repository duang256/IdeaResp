package Factory02;

public class ToyotaFactory implements CarFactory {
    @Override
    public Car creatCar() {
        return new Toyota();
    }
}
