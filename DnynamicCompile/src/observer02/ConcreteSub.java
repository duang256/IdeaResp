package observer02;


import java.util.Observable;

//Observable用于信息的发布者
public class ConcreteSub extends Observable {
    private int state;
    public void setState(int state){
         this.state=state;
         //表示目标对象已经做了更改
         setChanged();
         //通知所有的观察者
         notifyObservers(state);
    }

    public int getState() {
        return state;
    }
}
