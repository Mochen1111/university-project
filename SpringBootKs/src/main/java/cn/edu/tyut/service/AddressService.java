package cn.edu.tyut.service;

import cn.edu.tyut.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> findByUserId(Integer userId);
    Address findById(Integer id);
    Address insert(Address address);
    int update(Address address);
    int delete(Integer id);
}
