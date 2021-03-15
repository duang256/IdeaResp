package state;

import Factory03.Seat;

public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲");
    }
}
