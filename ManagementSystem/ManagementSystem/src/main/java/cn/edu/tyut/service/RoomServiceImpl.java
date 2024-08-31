package cn.edu.tyut.service;

import cn.edu.tyut.dao.RoomMapper;
import cn.edu.tyut.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Room> selectRoom(Room room) {
        List<Room> list = roomMapper.selectRoom(room);
        return list;
    }
}
