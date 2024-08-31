package cn.edu.tyut.dao;

import cn.edu.tyut.pojo.Apartment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApartmentMapper {
    int insertApartment(Apartment apartment);
    int updateApartment(Apartment apartment);
    List<Apartment> selectApartment(Apartment apartment);
}
