package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    int insertEmployee(Employee employee);
    int updateEmployee(Employee employee);
    int deleteEmployee(int eid);
    List<Employee> findEmployee(Employee employee);
}
