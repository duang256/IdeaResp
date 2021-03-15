package tcp;

import java.io.*;
import java.net.Socket;

public class Send implements Runnable {

    private boolean isRunning=true;
    private Socket client;
    private BufferedReader br;
    private DataOutputStream dos=null;
    public Send(Socket client) {
        this.client=client;
        br=new BufferedReader(new InputStreamReader(System.in));
        try {
            dos=new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            this.release();
        }
    }



    public void release(){
        this.isRunning=false;
        Utils.close(dos,client);
    }
    public void send(String str){
        try {
            dos.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getMsg(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }


    @Override
    public void run() {
        try {
        dos.writeUTF(Thread.currentThread().getName());
    } catch (IOException e) {
        e.printStackTrace();
    }
        while(isRunning){

            String msg=getMsg();
            if(!msg.equals("")){
                send(msg);
            }
        }
        release();
    }

}
