package chain;

public class Demo01 {
    public static void main(String[] args) {
        Leader leader=new Director("项目组长");
        leader.handleRequest(new LeaveRequest("颜技术",20000,"不缺钱"));
    }
}
