package org.example.design.patterns.proxy;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create (String user, Employee employee) {
        System.out.println("Create employee entry for employee : " + employee.firstName + " " + employee.lastName);
    }
}
