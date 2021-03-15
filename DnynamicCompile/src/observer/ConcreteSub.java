package observer;

public class ConcreteSub extends Sub{
    //state 是传递的消息
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //目标值发生变化，通知所有的观察者
        this.notifyAllObserver();
    }
}
