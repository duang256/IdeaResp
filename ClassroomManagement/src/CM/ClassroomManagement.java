package CM;

import java.util.Scanner;


public class ClassroomManagement {
    static final int floor=5;
    static final int order=10;
    private static int floorcounter;
    private static int ordercounter;
    static String [][]rooms=new String[floor][order];


    public static void main(String[] args) {
        System.out.println("welcome to WIT ClassroomManagement System");
        Scanner scan = new Scanner(System.in);
        String temp = null;

        for(int i=0;i<floor;i++){
            for (int j=0;j<order;j++){
                rooms[i][j]="空教室";
            }
        }

        while (true) {
            System.out.println("options:\n1.in\n2.out\n3.search\n4.quit");
            System.out.println("input a word");
            int room;
            temp = scan.next();

                if (temp.equals("in")) {
                    System.out.println("input the number of the classroom you want to predict");
                    while (true) {
                        room = scan.nextInt();
                        if (isright(room, 0)) {  //如果room存在则返回true继续执行
                            inroom(room);
                                break;
                        }

                    }
                } else if (temp.equals("out")) {
                    System.out.println("input the number of the classroom you want to check out:");
                    while (true) {
                        room = scan.nextInt();
                        if (isright(room, 1)) {  //如果room存在则返回true继续执行
                              outroom(room);
                                break;
                        }
                        System.out.println("input wrong room,input again:");

                    }
                } else if (temp.equals("search")) {
                    System.out.println("input the number of the classroom you want to search(input -1 to scan all rooms)");
                    while (true) {
                        room = scan.nextInt();
                        if (isright(room, 2)) {
                            search(room);
                                break;
                        }
                    }
                } else if (temp.equals("quit")) {
                    System.out.println("bye bye!");
                    break;
                } else {
                    System.out.println("wrong word!");
                }
            }
        }





    public static boolean isright(int room, int is){
        boolean i;
        floorcounter=room/100-1;
        ordercounter=room%100-1;
        if(floorcounter<0||floorcounter>=floor||ordercounter<0||ordercounter>=order){
            if (room!=-1) {
                System.out.println("input wrong");
                return false;
            }
        }

            if(is==0){
                if(rooms[floorcounter][ordercounter]!="空教室"){
                    System.out.println("This class has be predicted,input again:");
                    return false;
                }
                else{
                    return true;
                }
            }
            if(is==1){
                if(rooms[floorcounter][ordercounter]=="空教室"){
                    System.out.println("You haven't made a reservation \n");
                    return false;
                }
                else{
                    return true;
                }
            }
            if(is==2){
                if(floorcounter>=0&&floorcounter<floor&&ordercounter>=0&&ordercounter<order){
                    return true;
                }
                else if(room==-1){
                    return true;
                }
                else
                {
                    return false;
                }
            }
            return true;
    }




    public static void inroom(int room){
        floorcounter=room/100-1;
        ordercounter=room%100-1;    //教室序号从1开始101 102 201
        rooms[floorcounter][ordercounter]="已预定";
        System.out.println("successful booking!");
    }
    public static void outroom(int room){
        floorcounter=room/100-1;
        ordercounter=room%100-1;
        rooms[floorcounter][ordercounter]="空教室";
        System.out.println("successful check-out!");
    }
    public static void search(int room){
        if(room==-1){
            for(int i=0;i<floor;i++){
                for (int j=0;j<order;j++){
                    System.out.println((i+1)*100+j+1+" "+rooms[i][j]);
                }
            }
        }
        else{
            floorcounter=room/100-1;
            ordercounter=room%100-1;
            System.out.println(room+" "+rooms[floorcounter][ordercounter]);
        }
    }
}
