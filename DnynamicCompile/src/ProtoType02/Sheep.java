package ProtoType02;

import java.sql.Date;


public class Sheep implements Cloneable{
    private String sname;
    private Date birthday;

    public Sheep() {
    }

    public Sheep(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj=super.clone();  //直接调用Object的clone方法
        //添加如下代码实现deep clone
        //s代表的就是克隆的
        Sheep s= (Sheep) obj;
        s.birthday= (Date) this.birthday.clone();
        return obj;
    }
}
