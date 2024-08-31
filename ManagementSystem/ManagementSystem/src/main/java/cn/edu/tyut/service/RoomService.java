package cn.edu.tyut.service;


import cn.edu.tyut.pojo.Room;

import java.util.List;

public interface RoomService {
    List<Room> selectRoom(Room room);
}
