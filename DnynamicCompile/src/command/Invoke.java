package command;

public class Invoke {
    //可以放很多命令
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void call(){
        command.execute();
    }

}
