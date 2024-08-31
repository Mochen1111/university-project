package cn.edu.tyut.service;

import cn.edu.tyut.pojo.Apartment;

import java.util.List;

public interface ApartmentService {
    int insertApartment(Apartment apartment);
    int updateApartment(Apartment apartment);
    List<Apartment> selectApartment(Apartment apartment);
}
