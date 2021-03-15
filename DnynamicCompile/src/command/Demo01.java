package command;

public class Demo01 {
    public static void main(String[] args) {
        Receiver receiver=new Receiver();
        Command command=new ConcreteCommand(receiver);
        Invoke invoke=new Invoke(command);
        invoke.call();
    }
}
