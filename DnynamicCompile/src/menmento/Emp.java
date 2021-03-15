package menmento;

//源发器类
public class Emp {
    private  String eName;
    private  int age;
    private double salary;

    public EmpMenmento menmento(){
        return new EmpMenmento(this);
    }

    public void recover(EmpMenmento mmt){
        this.age=mmt.getAge();
        this.eName=mmt.geteName();
        this.salary=mmt.getSalary();
    }




    public Emp(String eName, int age, double salary) {
        this.eName = eName;
        this.age = age;
        this.salary = salary;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Emp() {
    }
}
