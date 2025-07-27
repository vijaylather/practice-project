package org.example.design.patterns.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
    private final EmployeeDao employeeDao;

    EmployeeDaoProxy(){
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String user, Employee employee) throws Exception {
        if (user.equals("ADMIN")) {
            employeeDao.create(user, employee);
        }
        else{
            throw new Exception("Access Denied");
        }
    }
}
