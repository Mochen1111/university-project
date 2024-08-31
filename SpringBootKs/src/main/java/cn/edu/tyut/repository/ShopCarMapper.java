package cn.edu.tyut.repository;

import cn.edu.tyut.domain.ShopCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopCarMapper {
    // 根据用户ID查询购物车信息
    @Select("SELECT * FROM shop_cars WHERE uid = #{uid}")
    List<ShopCar> findShopCarByUid(@Param("uid") Integer uid);

    // 根据用户ID和商品ID查询购物车信息
    @Select("SELECT * FROM shop_cars WHERE uid = #{uid} AND goodId = #{goodId}")
    ShopCar findShopCarByUidAndGoodId(@Param("uid") Integer uid,@Param("goodId") Integer goodId);

    // 插入新的购物车信息
    @Insert("INSERT INTO shop_cars(uid, goodId, goodNum) VALUES(#{uid}, #{goodId}, #{goodNum})")
    int insertShopCar(ShopCar shopCar);

    // 更新购物车信息
    @Update("UPDATE shop_cars SET goodNum=#{goodNum} WHERE uid=#{uid} AND goodId=#{goodId}")
    int updateShopCar(ShopCar shopCar);

    // 删除购物车信息
    @Delete("DELETE FROM shop_cars WHERE uid=#{uid} AND goodId=#{goodId}")
    int deleteShopCar(@Param("uid") Integer uid, @Param("goodId") Integer goodId);

}