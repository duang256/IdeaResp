package Factory02;

/**
 * 工厂设计模式
 * 增加新的实现类就可以新建一个新的车型
 * 实际上可以认为是简单工厂模式的扩大版，讲方法扩大成了单独的实现类
 */
public class Demo01 {
    public static void main(String[] args) {
        Car c1=new LandRoadFactory().creatCar();
        Car c2=new ToyotaFactory().creatCar();
    }
}
