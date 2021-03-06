package mediator;

import java.util.HashMap;

public interface Mediator {
    void register(String dname,Department d);
    void command(String dname);
}



class President implements Mediator{

    private HashMap<String ,Department>map=new HashMap<>();
    @Override
    public void register(String dname, Department d) {
        map.put(dname,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();
    }
}