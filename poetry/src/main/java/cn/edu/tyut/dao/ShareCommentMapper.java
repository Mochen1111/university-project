package cn.edu.tyut.dao;

import cn.edu.tyut.model.ShareComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShareCommentMapper {

    // 插入分享评论信息
    @Insert("INSERT INTO share_comments(user_id, share_id, scomment_content) VALUES(#{userId}, #{shareId}, #{scommentContent})")
    @Options(useGeneratedKeys = true, keyProperty = "scId", keyColumn = "sc_id")
    int insertShareComment(ShareComment shareComment);

    // 根据分享评论ID查询分享评论信息
    @Select("SELECT * FROM share_comments WHERE sc_id = #{scId}")
    ShareComment selectShareCommentById(Integer scId);

    // 查询所有分享评论信息
    @Select("SELECT * FROM share_comments")
    List<ShareComment> selectAllShareComments();

    // 根据分享ID查询分享评论信息
    @Select("SELECT * FROM share_comments WHERE share_id = #{shareId}")
    List<ShareComment> selectShareCommentsByShareId(Integer shareId);

    // 根据用户ID查询分享评论信息
    @Select("SELECT * FROM share_comments WHERE user_id = #{userId}")
    List<ShareComment> selectShareCommentsByUserId(Integer userId);

    // 更新分享评论信息
    @Update("UPDATE share_comments SET scomment_content=#{scommentContent} WHERE sc_id=#{scId}")
    int updateShareComment(ShareComment shareComment);

    // 删除分享评论信息
    @Delete("DELETE FROM share_comments WHERE user_id = #{userId} AND share_id = #{shareId}")
    int deleteShareComment(@Param("userId") Integer userId, @Param("shareId") Integer shareId);
}