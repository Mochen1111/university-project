package cn.edu.tyut.service;

import cn.edu.tyut.domain.Address;
import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodService {
    Good findGoodById(int id);
    PageInfo<Good> findAllGood(Integer pageNum, Integer pageSize);
    List<Good> findGoodByName(String goodName);
    List<Good> findGoodByType(String goodType);
    List<Good> findGoodNumIsNull();
    Good addGood(Good good);
    int updateGood(Good good);
    int deleteGood(int id);
    int buyGood(User user, Integer getMethod, Address address,Integer[] goodId);
    int buyGoodMethod(User user, Integer getMethod, Integer goodNum, Address address, Integer goodId);
}
