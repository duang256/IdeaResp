package testAnnotation;

@SxtTable("tb_student")
public class SxtStudent {
    @SxtField(columnName = "id",type = "int",length = 10)
    private int id;
    @SxtField(columnName = "sname",type = "varchar",length = 10)
    private String studentName;
    @SxtField(columnName = "age",type = "int",length = 3)
    private int age;

    public SxtStudent(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
