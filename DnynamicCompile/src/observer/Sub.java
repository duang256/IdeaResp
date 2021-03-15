package observer;

import java.util.ArrayList;
import java.util.List;

public class Sub {
    protected List<Observer>list=new ArrayList<>();
    public void register(Observer obs){
        list.add(obs);
    }
    public void removeObserver(Observer obs){
        list.remove(obs);
    }
    public void notifyAllObserver(){
        for (Observer objs:list
             ) {
            objs.update(this);
        }

    }
}
