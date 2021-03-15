package menmento;

public class EmpMenmento {
    private  String eName;
    private  int age;
    private double salary;

    public EmpMenmento( Emp e) {
        this.eName=e.geteName();
        this.age=e.getAge();
        this.salary=e.getSalary();
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


}
