package Factory03;

public interface Engine {
   void run();
}


class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("V8");
    }

}

class  LowEngine implements Engine{

    @Override
    public void run() {
        System.out.println("V2");
    }
}