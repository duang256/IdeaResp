package command;

public interface Command {
    void execute();
}

class ConcreteCommand implements Command{


    private Receiver receiver;

    ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}