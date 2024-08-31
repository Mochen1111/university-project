package cn.edu.tyut.service;

import cn.edu.tyut.domain.AList;

import java.util.List;

public interface AListService {
    AList findById(Integer id);
    List<AList> findAll();
    List<AList> findByStatus(String status);
    List<AList> findByUserId(Integer userId);
    int updateList(AList list);
    int delete(Integer id);
}
