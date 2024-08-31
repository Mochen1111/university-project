package cn.edu.tyut.service;

import cn.edu.tyut.domain.ShopCar;

import java.util.List;

public interface ShopCarService {
    int insertShopCar(int uid,int goodId,int num);
    ShopCar findShopCarByUidAndGoodId(int uid,int goodId);
    List<ShopCar> findShopCarByUid(int uid);
    int deleteShopCarByUid(int uid,int goodId);
    int updateShopCar(ShopCar shopCar);
}
