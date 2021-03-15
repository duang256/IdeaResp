package state;

public class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("已入住");
    }
}
