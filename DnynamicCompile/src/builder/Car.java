package builder;

public class Car {
    private Engine engine;
    private Seat seat;
    private Tyre tyre;

    public Car() {
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public void launch(){
        System.out.println("坐上真皮座椅"+this.getSeat());
        System.out.println("发动机启动"+this.getEngine());
        System.out.println("车轮转动"+this.getTyre());
    }
}



class Engine {
    private String name;

    Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Seat {

    private String name;

    Seat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Tyre {
    private String name;

    Tyre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}