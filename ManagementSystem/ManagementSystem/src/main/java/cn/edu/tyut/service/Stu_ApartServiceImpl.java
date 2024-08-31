package cn.edu.tyut.service;

import cn.edu.tyut.dao.Stu_ApartMapper;
import cn.edu.tyut.pojo.Stu_Apart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Stu_ApartServiceImpl implements Stu_ApartService{
    @Autowired
    private Stu_ApartMapper stuApartMapper;
    @Override
    public List<Stu_Apart> selectStu(Stu_Apart stuApart) {
        List<Stu_Apart> list = stuApartMapper.selectStuA(stuApart);
        if (list != null){
            return list;
        }else {
            return null;
        }
    }
}
