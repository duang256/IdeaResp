package Factory02;

import Factory02.Car;

public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("大G");
    }
}
