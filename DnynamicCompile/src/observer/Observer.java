package observer;



public interface Observer {
    void update(Sub subject);

}



class ObserveA implements Observer{

    private int myState;
    @Override
    public void update(Sub subject) {
        myState=((ConcreteSub)subject).getState();
        System.out.println(myState);
    }
}


