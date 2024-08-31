package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.Stu_Apart;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.weaver.Dump;

import java.util.List;

@Mapper
public interface Stu_ApartMapper {
    int insertStuA(Stu_Apart stuApart);
    int deleteStuA(Stu_Apart stuApart);
    List<Stu_Apart> selectStuA(Stu_Apart stuApart);
}
