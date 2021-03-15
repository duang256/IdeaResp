package dao;

public interface EmpServiceDao {
    //更新用户信息
    public void upEmp();
    //新增员工信息
    public void insEmp();
    //删除员工信息
    public void delEmp();
    //按编号查询员工信息
    public void searchEmp();
    //查询全部员工信息
    public void searchAllEmp();
}
