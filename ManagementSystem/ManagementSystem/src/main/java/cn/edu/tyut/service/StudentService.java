package cn.edu.tyut.service;

import cn.edu.tyut.pojo.Student;

import java.util.List;

public interface StudentService {
    int insertStudent(Student student);
    int deleteStudent(Student student);
    int updateStudent(Student student);
    List<Student> selectStudent(Student student);
    Student allocation(Student student);
}
