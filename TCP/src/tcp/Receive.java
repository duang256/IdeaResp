package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
    private boolean isRunning=true;
    private Socket client=null;
    private BufferedReader br=null;
    private DataInputStream dis=null;

    public Receive(Socket client) {
        this.client = client;
        try {
            dis=new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            release();
        }
    }

    public String  receive(){
        String response= null;
        try {
            response = dis.readUTF();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
    public void release(){
        this.isRunning=false;
        Utils.close(dis,client);
    }

    @Override
    public void run() {
        while(isRunning){
            String  msg=receive();
            if(!msg.equals("")){
                System.out.println(msg);
            }

        }
        release();
    }
}
