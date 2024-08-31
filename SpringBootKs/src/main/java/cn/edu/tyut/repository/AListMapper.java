package cn.edu.tyut.repository;

import cn.edu.tyut.domain.AList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AListMapper {
    // 根据aid查询订单信息
    @Select("SELECT * FROM a_list WHERE aid = #{aid}")
    AList findAListById(@Param("aid") Integer aid);


    @Select("SELECT * FROM a_list ORDER BY aid desc ")
    List<AList> findAll();

    @Select("SELECT * FROM a_list WHERE status = #{status} ORDER BY aid desc")
    List<AList> findByStatus(String status);

    // 根据用户ID查询订单列表
    @Select("SELECT * FROM a_list WHERE uid = #{uid} ORDER BY aid desc")
    List<AList> findAListsByUserId(@Param("uid") Integer uid);

    // 插入订单信息
    @Insert("INSERT INTO a_list(uid, sumPrice, createTime, status, getGoodMethod, address) VALUES(#{uid}, #{sumPrice}, #{createTime}, #{status}, #{getGoodMethod}, #{address})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "aid", before = false, resultType = Integer.class)
    int insertAList(AList aList);

    // 更新订单信息
    @Update("UPDATE a_list SET status=#{status} WHERE aid=#{aid}")
    int updateAList(AList aList);

    // 删除订单信息
    @Delete("DELETE FROM a_list WHERE aid=#{aid}")
    int deleteAList(@Param("aid") Integer aid);
}