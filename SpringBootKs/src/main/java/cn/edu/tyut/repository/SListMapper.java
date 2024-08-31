package cn.edu.tyut.repository;

import cn.edu.tyut.domain.SList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SListMapper {
    // 根据sid查询子订单信息
    @Select("SELECT * FROM s_list WHERE sid = #{sid}")
    SList findSListById(@Param("sid") Integer sid);

    // 根据总订单ID查询子订单列表
    @Select("SELECT * FROM s_list WHERE aid = #{aid}")
    List<SList> findSListsByAId(@Param("aid") Integer aid);

    // 根据用户ID查询子订单列表
    @Select("SELECT * FROM s_list WHERE uid = #{uid}")
    List<SList> findSListsByUserId(@Param("uid") Integer uid);

    // 插入子订单信息
    @Insert("INSERT INTO s_list(aid, uid, goodId, goodNum, goodPriceWithNum) VALUES(#{aid}, #{uid}, #{goodId}, #{goodNum}, #{goodPriceWithNum})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "sid", before = false, resultType = Integer.class)
    int insertSList(SList sList);

    // 更新子订单信息
    @Update("UPDATE s_list SET aid=#{aid}, uid=#{uid}, goodId=#{goodId}, goodNum=#{goodNum}, goodPriceWithNum=#{goodPriceWithNum} WHERE sid=#{sid}")
    int updateSList(SList sList);

    // 删除子订单信息
    @Delete("DELETE FROM s_list WHERE sid=#{sid}")
    int deleteSList(@Param("sid") Integer sid);
}