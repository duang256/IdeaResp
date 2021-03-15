package observer02;

import java.util.Observable;
import java.util.Observer;

//Observer用于信息的接收者
public class ObserverA implements Observer {
    private int state;
    @Override
    public void update(Observable o, Object arg) {
        state=((ConcreteSub)o).getState();
    }

    public int getState() {
        return state;
    }
}
