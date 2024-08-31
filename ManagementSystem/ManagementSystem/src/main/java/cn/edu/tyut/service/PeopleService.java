package cn.edu.tyut.service;

import cn.edu.tyut.pojo.People;

import java.util.List;

public interface PeopleService {
    int insertPeople(People people);
    List<People> selectPeople(People people);
}
