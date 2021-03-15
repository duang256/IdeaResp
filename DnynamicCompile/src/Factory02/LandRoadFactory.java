package Factory02;

public class LandRoadFactory implements CarFactory {
    @Override
    public Car creatCar() {
        return new LandRoad();
    }
}
