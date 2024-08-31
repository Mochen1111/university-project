package cn.edu.tyut.dao;

import cn.edu.tyut.model.Share;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShareMapper {

    // 插入分享信息
    @Insert("INSERT INTO shares(user_id, share_content, share_time) VALUES(#{userId}, #{shareContent}, #{shareTime})")
    @Options(useGeneratedKeys = true, keyProperty = "shareId", keyColumn = "share_id")
    int insertShare(Share share);

    // 根据分享ID查询分享信息
    @Select("SELECT * FROM shares WHERE share_id = #{shareId}")
    Share selectShareById(Integer shareId);

    // 查询所有分享信息
    @Select("SELECT * FROM shares")
    List<Share> selectAllShares();

    // 根据用户ID查询分享信息
    @Select("SELECT * FROM shares WHERE user_id = #{userId}")
    List<Share> selectSharesByUserId(Integer userId);

    // 更新分享信息
    @Update("UPDATE shares SET share_content=#{shareContent}, share_time=#{shareTime} WHERE share_id=#{shareId}")
    int updateShare(Share share);

    // 删除分享信息
    @Delete("DELETE FROM shares WHERE share_id = #{shareId}")
    int deleteShare(Integer shareId);
}