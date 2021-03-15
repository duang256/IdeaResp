package Factory02;

public class JaguarFactory implements CarFactory {
    @Override
    public Car creatCar() {
        return new Jaguar();
    }
}
