package org.example.design.patterns.proxy;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        Employee employee = new Employee("Vijay", "Lather");
        employeeDao.create("ADMIN", employee);
        employeeDao.create("USER", employee);
    }
}