package cn.edu.tyut.service;

import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.SList;
import cn.edu.tyut.domain.ShopCar;
import cn.edu.tyut.domain.User;
import cn.edu.tyut.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService{
    @Autowired
    private ShopCarMapper shopCarMapper;

    // 添加购物车
    @Override
    public int insertShopCar(int uid, int goodId, int num) {
        // 创建一个购物车对象
        ShopCar shopCar = new ShopCar();
        shopCar.setUid(uid);
        shopCar.setGoodId(goodId);
        shopCar.setGoodNum(num);

        int flag = 0;
        // 根据用户ID和商品ID查询购物车信息
        ShopCar shopCarByUidAndGoodId = shopCarMapper.findShopCarByUidAndGoodId(uid, goodId);

        // 购物车中有该商品时要增加相应数量
        if(shopCarByUidAndGoodId != null){
            // 获取购物车中的商品数量
            int after = shopCarByUidAndGoodId.getGoodNum();
            // 更新购物车中的商品数量
            after = after + num;
            // 创建一个新的购物车对象用于更新
            ShopCar shopCarAfter = new ShopCar();

            shopCarAfter.setUid(uid);
            shopCarAfter.setGoodId(goodId);
            // 设置更新后的商品数量
            shopCarAfter.setGoodNum(after);
            // 更新购物车信息
            flag = shopCarMapper.updateShopCar(shopCarAfter);
        }else {
            // 插入新的购物车信息
            flag = shopCarMapper.insertShopCar(shopCar);
        }
        if (flag > 0){
            return 1;
        }else {
            return 0;
        }
    }

    public ShopCar findShopCarByUidAndGoodId(int uid, int goodId) {
        return shopCarMapper.findShopCarByUidAndGoodId(uid, goodId);
    }

    public List<ShopCar> findShopCarByUid(int uid) {
        // 调用shopCarMapper的findShopCarByUid方法，传入用户ID作为参数
        return shopCarMapper.findShopCarByUid(uid);
    }

    public int deleteShopCarByUid(int uid,int goodId) {
        // 定义标志位变量flag，初始值为0
        int flag = 0;
        // 调用shopCarMapper的deleteShopCar方法，传入用户ID和商品ID作为参数，将返回值赋给flag
        flag = shopCarMapper.deleteShopCar(uid,goodId);
        // 返回标志位flag的值
        return flag;
    }

    public int updateShopCar(ShopCar shopCar) {
        int flag = 0;
        flag = shopCarMapper.updateShopCar(shopCar);
        return flag;
    }
}
