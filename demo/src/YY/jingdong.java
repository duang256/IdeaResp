package YY;

public class jingdong {
    public static void main(String[] args) {
        new Thread(new TalkSend(8888,"localhost",9999)).start();
        new Thread(new TalkReceive(5555,"颜主人")).start();
    }
}
