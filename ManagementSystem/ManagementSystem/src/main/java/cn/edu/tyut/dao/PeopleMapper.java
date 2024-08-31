package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.People;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleMapper {
//     动态SQL条件查询
     List<People> findPeople(People people);
     int insertPeople(People people);
}
