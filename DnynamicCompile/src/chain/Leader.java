package chain;

//抽象类 领导者
 public abstract class Leader {
     protected String name;
     public Leader(String name) {
            this.name = name;
      }

      //责任后继对象
     protected Leader nextLeader;

     public void setNextLeader(Leader nextLeader){
         this.nextLeader=nextLeader;
     }
     //处理请求的方法，传入请求
    public abstract void handleRequest(LeaveRequest request);
}



class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        setNextLeader(new Manager("项目经理"));
        if(request.getLeaveDays()<3){
            System.out.println(request.getName()+"请假"+request.getLeaveDays()+"天,"+name+"审批通过");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }

}

class Manager extends Leader{

     public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        setNextLeader(new GeneralManager("总裁"));
        if(request.getLeaveDays()>3&&request.getLeaveDays()<10){
            System.out.println(request.getName()+"请假"+request.getLeaveDays()+"天,"+name+"审批通过");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}


class GeneralManager extends Leader{

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays()>10){
            System.out.println(request.getName()+"请假"+request.getLeaveDays()+"天,"+name+"审批通过");
        }
    }
 }
