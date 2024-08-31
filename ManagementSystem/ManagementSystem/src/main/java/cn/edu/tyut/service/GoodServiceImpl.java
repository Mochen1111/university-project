package cn.edu.tyut.service;

import cn.edu.tyut.dao.Room_GoodMapper;
import cn.edu.tyut.pojo.Room_Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{
    @Autowired
    private Room_GoodMapper roomGoodMapper;
    @Override
    public int insertGood(Room_Good roomGood) {
        int num = roomGoodMapper.insertGood(roomGood);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteGood(Room_Good roomGood) {
        int num = roomGoodMapper.deleteGood(roomGood);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int updateGood(Room_Good roomGood) {
        int num = roomGoodMapper.updateGood(roomGood);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Room_Good> selectGood(int aid) {
        Room_Good roomGood = new Room_Good();
        roomGood.setAid(aid);
        List<Room_Good> list = roomGoodMapper.selectGood(roomGood);
        return list;
    }
}
