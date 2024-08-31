package cn.edu.tyut.service;

import cn.edu.tyut.dao.PeopleMapper;
import cn.edu.tyut.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeopleServiceImpl implements PeopleService{
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public List<People> selectPeople(People people){
        List<People> list = peopleMapper.findPeople(people);
        return list;
    }
    @Override
    public int insertPeople(People people){
        int num  =  peopleMapper.insertPeople(people);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }
}
