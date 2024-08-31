package cn.edu.tyut.service;

import cn.edu.tyut.pojo.Room_Good;

import java.util.List;

public interface GoodService {
    int insertGood(Room_Good roomGood);
    int deleteGood(Room_Good roomGood);
    int updateGood(Room_Good roomGood);
    List<Room_Good> selectGood(int aid);
}
