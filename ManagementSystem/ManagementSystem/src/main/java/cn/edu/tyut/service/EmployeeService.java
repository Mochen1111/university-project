package cn.edu.tyut.service;

import cn.edu.tyut.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    boolean register(Employee employee);
    int deleteEmployee(int eid);
    int updateEmployee(Employee employee);
    List<Employee> selectEmployee(Employee employee);
    Employee login(Employee employee);
}
