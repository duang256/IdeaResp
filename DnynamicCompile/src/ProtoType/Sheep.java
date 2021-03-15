package ProtoType;

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
    public Object clone() throws CloneNotSupportedException {
        Object obj=super.clone();  //直接调用Object的clone方法
        return obj;
    }
}
