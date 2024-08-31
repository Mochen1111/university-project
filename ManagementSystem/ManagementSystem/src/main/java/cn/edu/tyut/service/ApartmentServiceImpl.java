package cn.edu.tyut.service;

import cn.edu.tyut.dao.ApartmentMapper;
import cn.edu.tyut.dao.RoomMapper;
import cn.edu.tyut.pojo.Apartment;
import cn.edu.tyut.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService{
    @Autowired
    private ApartmentMapper apartmentMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public int insertApartment(Apartment apartment) {
        int num = apartmentMapper.insertApartment(apartment);
        if (num > 0){
            Room room = new Room();
            room.setRpeople(4);
            room.setNowrpeople(0);
            room.setAid(apartment.getAid());
            room.setSex(apartment.getAsex());
            for (int a = 1; a <= 4; a++){
                for (int b = 1; b <= 18; b++){
                    int rid = a * 100 + b;
                    room.setRid(rid);
                    int num1 = roomMapper.insertRoom(room);
                    if (num1 <= 0){
                        return 0;
                    }
                }
            }
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int updateApartment(Apartment apartment) {
        int num = apartmentMapper.updateApartment(apartment);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Apartment> selectApartment(Apartment apartment) {
        List<Apartment> list = apartmentMapper.selectApartment(apartment);
        return list;
    }
}
