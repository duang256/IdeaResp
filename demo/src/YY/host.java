package YY;

public class host {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999,"京东")).start();
        new Thread(new TalkSend(7777,"localhost",5555)).start();
    }
}
