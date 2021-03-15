package builder;

public class Demo01 {
    public static void main(String[] args) {
        //先把原料都建造好
        LRCarBuilder lrCarBuilder=new LRCarBuilder();
        //进行组装
        Director director= new LRDirector(lrCarBuilder);
        Car car=director.directCar();
        car.launch();
    }
}
