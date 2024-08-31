package cn.edu.tyut.service;

import cn.edu.tyut.dao.EmployeeMapper;
import cn.edu.tyut.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public boolean register(Employee employee) {
        int num = employeeMapper.insertEmployee(employee);
        if (num > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteEmployee(int eid) {
        int num = employeeMapper.deleteEmployee(eid);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int updateEmployee(Employee employee) {
        int num = employeeMapper.updateEmployee(employee);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Employee> selectEmployee(Employee employee) {
        List<Employee> list = employeeMapper.findEmployee(employee);
        return list;
    }

    @Override
    public Employee login(Employee employee) {
//        将接收到的职工号赋值给新对象，用职工号查询数据库
        Employee employee1 = new Employee();
        employee1.setEid(employee.getEid());
//        查询出数据库结果保存到employee2
        List<Employee> list = employeeMapper.findEmployee(employee1);
        if (list != null && list.size() > 0) {
            Employee employee2 = list.get(0);
            //        如果查询出的密码与接收的密码一致
            if (employee2.getPassword().equals(employee.getPassword())){
//            返回数据库中信息
                return employee2;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
