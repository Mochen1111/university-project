package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.Room_Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Room_GoodMapper {
    int insertGood(Room_Good roomGood);
//    动态SQL删除楼内财产，where aid为管理员权限楼号，rid为宿舍
    int deleteGood(Room_Good roomGood);
    int updateGood(Room_Good roomGood);
//    查楼内所有财产，按宿舍分组
//    动态SQL查
   List<Room_Good> selectGood(Room_Good roomGood);
}
