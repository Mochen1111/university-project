package cn.edu.tyut.dao;

import cn.edu.tyut.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 插入评论信息
    @Insert("INSERT INTO comments(article_id, user_id, comment_content, comment_time) VALUES(#{articleId}, #{userId}, #{commentContent}, #{commentTime})")
    @Options(useGeneratedKeys = true, keyProperty = "commentId", keyColumn = "comment_id")
    int insertComment(Comment comment);

    // 根据评论ID查询评论信息
    @Select("SELECT * FROM comments WHERE comment_id = #{commentId}")
    Comment selectCommentById(Integer commentId);

    // 查询所有评论信息
    @Select("SELECT * FROM comments")
    List<Comment> selectAllComments();

    // 根据文章ID查询评论信息
    @Select("SELECT * FROM comments WHERE article_id = #{articleId} ORDER BY comment_time DESC")
    List<Comment> selectCommentsByArticleId(Integer articleId);

    // 更新评论信息
    @Update("UPDATE comments SET comment_content=#{commentContent}, comment_time=#{commentTime} WHERE comment_id=#{commentId}")
    int updateComment(Comment comment);

    // 删除评论信息
    @Delete("DELETE FROM comments WHERE comment_id = #{commentId}")
    int deleteComment(Integer commentId);
}