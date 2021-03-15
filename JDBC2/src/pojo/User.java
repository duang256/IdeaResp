package pojo;

import java.util.Objects;

public class User {
    private int unum;
    private String uname;
    private String upwd;

    public User(int unum, String uname, String upwd) {
        this.unum = unum;
        this.uname = uname;
        this.upwd = upwd;
    }

    public int getUnum() {
        return unum;
    }

    public void setUnum(int unum) {
        this.unum = unum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return unum == user.unum &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(upwd, user.upwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unum, uname, upwd);
    }

    @Override
    public String toString() {
        return "User{" +
                "unum=" + unum +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
