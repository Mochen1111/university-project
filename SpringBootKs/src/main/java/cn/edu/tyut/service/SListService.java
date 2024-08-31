package cn.edu.tyut.service;

import cn.edu.tyut.domain.SList;

import java.util.List;

public interface SListService {
    SList findBySid(Integer id);
    List<SList> findByAid(Integer aid);
    int deleteBySid(Integer id);
}
