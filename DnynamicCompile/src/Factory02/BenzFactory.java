package Factory02;

public class BenzFactory implements CarFactory {

    @Override
    public Car creatCar() {
        return new Benz();
    }
}
