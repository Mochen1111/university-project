package cn.edu.tyut.service;

import cn.edu.tyut.domain.AList;
import cn.edu.tyut.repository.AListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AListServiceImpl implements AListService {
    @Autowired
    private AListMapper aListMapper;

    @Override
    public AList findById(Integer id) {
        //通过订单ID查询订单
        return aListMapper.findAListById(id);
    }

    @Override
    public List<AList> findAll() {
        //查询所有订单
        List<AList> list = aListMapper.findAll();
        return list;
    }

    @Override
    public List<AList> findByStatus(String status) {
        //通过订单状态查询订单
        List<AList> list = aListMapper.findByStatus(status);
        return list;
    }

    @Override
    public List<AList> findByUserId(Integer userId) {
        //通过用户ID查询该用户的订单
        List<AList> list = aListMapper.findAListsByUserId(userId);
        return list;
    }

    @Override
    public int updateList(AList list) {
        //更新订单信息
        return aListMapper.updateAList(list);
    }

    @Override
    public int delete(Integer id) {
        //删除订单
        return aListMapper.deleteAList(id);
    }
}
