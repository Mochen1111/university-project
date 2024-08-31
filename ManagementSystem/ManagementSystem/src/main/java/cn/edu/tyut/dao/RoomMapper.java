package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.Room;
import cn.edu.tyut.pojo.Room_Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    int insertRoom(Room room);
    int updateRoom(Room room);
    List<Room> selectRoom(Room room);
}
