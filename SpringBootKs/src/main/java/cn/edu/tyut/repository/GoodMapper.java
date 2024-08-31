package cn.edu.tyut.repository;

import cn.edu.tyut.domain.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {
    // 根据商品ID查询商品信息
    @Select("SELECT * FROM goods WHERE goodId = #{goodId}")
    Good findGoodById(@Param("goodId") Integer goodId);

    // 根据商品名称模糊查询商品信息
    @Select("SELECT * FROM goods WHERE goodName like CONCAT('%',#{goodName},'%')")
    List<Good> findGoodByName(String goodName);

    // 根据商品类型模糊查询商品信息
    @Select("SELECT * FROM goods WHERE goodType like CONCAT('%',#{goodType},'%')")
    List<Good> findGoodByType(String goodType);

    @Select("SELECT * FROM goods WHERE goodNum = '0'")
    List<Good> findNumIsNull();

    // 查询所有商品信息
    @Select("SELECT * FROM goods")
    List<Good> findAllGoods();

    // 查询部分商品信息
    @Select("SELECT * FROM goods limit #{begin},#{end}")
    List<Good> findGoodsBySE(@Param(value = "begin") Integer begin,@Param(value = "end") Integer end);

    // 插入新商品信息
    @Insert("INSERT INTO goods(goodName, goodPrice, goodContext, goodCover, goodType, goodNum) VALUES(#{goodName}, #{goodPrice}, #{goodContext}, #{goodCover}, #{goodType}, #{goodNum})")
    @SelectKey(statement ={" select last_insert_id()"},keyColumn = "goodid",keyProperty = "goodId", before = false, resultType = Integer.class)
    int insertGood(Good good);

    // 更新商品信息
    @Update("UPDATE goods SET goodName=#{goodName}, goodPrice=#{goodPrice}, goodContext=#{goodContext}, goodCover=#{goodCover}, goodType=#{goodType}, goodNum=#{goodNum} WHERE goodId=#{goodId}")
    int updateGood(Good good);

    // 删除商品信息
    @Delete("DELETE FROM goods WHERE goodId=#{goodId}")
    int deleteGood(@Param("goodId") Integer goodId);
}