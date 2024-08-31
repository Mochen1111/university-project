package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insertStudent(Student student);
    int deleteStudent(int sid);
    int updateStudent(Student student);
//    动态SQL，各种查询
    List<Student> selectStudent(Student student);
}
