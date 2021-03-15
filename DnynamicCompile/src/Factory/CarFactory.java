package Factory;

public  class CarFactory {
//    public static Car creatCar(String  type){
//        if("揽胜".equals(type)){
//            return new LandRoad();
//        }else if("陆地巡洋舰".equals(type)){
//            return new Toyota();
//        }else if("大G".equals(type)){
//            return new Benz();
//        }else if("捷豹".equals(type)){
//            return new Jaguar();
//        }else{
//            return null;
//        }
//        }
        public static Car creatLandRoad() {
            return  new LandRoad();
        }
        public static Car creatBenz() {
            return  new Benz();
        }
        public static Car creatToyota() {
            return  new Toyota();
        }
        public static Car creatJaguar() {
            return  new Jaguar();
        }

}
