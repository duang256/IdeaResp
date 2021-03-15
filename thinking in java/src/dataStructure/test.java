package dataStructure;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        List list=new MySingleLinkedList();
        Deque de;
        Queue qe;
        list.add(2);
        list.add(434);
        list.add(666);
        System.out.println(list.toString());
        System.out.println(list.get(2));
        LinkedList linkedList=new LinkedList();
        linkedList.add(123);
        List list1=  new dataStructure.ArrayList();
        list1.add(2);
        list1.add(434);
        list1.add(666);
        list1.add(0,1);
        System.out.println(list1);

        //将十进制转换成二进制
        int a=97;
        int t=a;
        Deque deque=new LinkedList();
        while(t>0){
            //t除以2得到商再赋给t，保存余数
            int b=t%2;
            //str往前面加
            deque.push(b);
            t=t/2;
            //输出余数
        }

        while(!deque.isEmpty()){
            System.out.print(deque.pop());
        }

        java.util.List list2=new ArrayList<>();
        list2.add(2);
        list2.add(434);
        list2.add(666);
        list2.add(0,1);
        System.out.println(list2);



    }
}
