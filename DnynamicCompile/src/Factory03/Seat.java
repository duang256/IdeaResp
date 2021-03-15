package Factory03;

public interface Seat {
    void massage();
}



class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("能按摩");
    }
}

class LowerSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("不能按摩");
    }
}
