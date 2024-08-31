package cn.edu.tyut.service;

import cn.edu.tyut.domain.SList;
import cn.edu.tyut.repository.SListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SListServiceImpl implements SListService {
    @Autowired
    private SListMapper sListMapper;

    @Override
    public SList findBySid(Integer id) {
        return sListMapper.findSListById(id);
    }

    @Override
    public List<SList> findByAid(Integer aid) {
        List<SList> sLists = sListMapper.findSListsByAId(aid);
        return sLists;
    }

    @Override
    public int deleteBySid(Integer id) {
        return sListMapper.deleteSList(id);
    }
}
