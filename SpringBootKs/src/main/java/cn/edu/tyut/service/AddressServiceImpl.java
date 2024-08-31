package cn.edu.tyut.service;

import cn.edu.tyut.domain.Address;
import cn.edu.tyut.repository.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> findByUserId(Integer userId) {
        //通过用户ID查询地址列表
        return addressMapper.findAddressesByUserId(userId);
    }

    @Override
    public Address findById(Integer id) {
        //通过地址ID查询地址
        return addressMapper.findAddressById(id);
    }

    @Override
    public Address insert(Address address) {
        //增加地址
        addressMapper.insertAddress(address);
        return address;
    }

    @Override
    public int update(Address address) {
        //修改地址
        return addressMapper.updateAddress(address);
    }

    @Override
    public int delete(Integer id) {
        //删除地址
        return addressMapper.deleteAddress(id);
    }
}
