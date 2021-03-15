package pojo;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private int snum;
    private String sname;
    private int sage;

    public Student(int snum, String sname, int sage) {
        this.snum = snum;
        this.sname = sname;
        this.sage = sage;
    }

    public Student() {
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return snum == student.snum &&
                sage == student.sage &&
                Objects.equals(sname, student.sname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snum, sname, sage);
    }

    @Override
    public String toString() {
        return "Student{" +
                "snum=" + snum +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                '}';
    }
}
