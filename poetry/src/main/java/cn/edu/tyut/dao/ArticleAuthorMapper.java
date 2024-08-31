package cn.edu.tyut.dao;

import cn.edu.tyut.model.ArticleAuthor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleAuthorMapper {

    // 插入文章作者关联信息
    @Insert("INSERT INTO article_author(article_id, author_id) VALUES(#{articleId}, #{authorId})")
    @Options(useGeneratedKeys = true, keyProperty = "aaId", keyColumn = "aa_id")
    int insertArticleAuthor(ArticleAuthor articleAuthor);

    // 根据文章ID和作者ID查询关联信息
    @Select("SELECT * FROM article_author WHERE article_id = #{articleId} AND author_id = #{authorId}")
    ArticleAuthor selectArticleAuthorByArticleIdAndAuthorId(@Param("articleId") Integer articleId, @Param("authorId") Integer authorId);

    // 根据关联ID查询关联信息
    @Select("SELECT * FROM article_author WHERE aa_id = #{aaId}")
    ArticleAuthor selectArticleAuthorById(Integer aaId);

    // 查询某篇文章的所有作者关联信息
    @Select("SELECT * FROM article_author WHERE article_id = #{articleId}")
    ArticleAuthor selectArticleAuthorsByArticleId(Integer articleId);

    // 查询某个作者的所有文章关联信息
    @Select("SELECT * FROM article_author WHERE author_id = #{authorId}")
    List<ArticleAuthor> selectArticleAuthorsByAuthorId(Integer authorId);

    // 更新文章作者关联信息
    @Update("UPDATE article_author SET article_id=#{articleId}, author_id=#{authorId} WHERE aa_id=#{aaId}")
    int updateArticleAuthor(ArticleAuthor articleAuthor);

    // 删除文章作者关联信息
    @Delete("DELETE FROM article_author WHERE aa_id = #{aaId}")
    int deleteArticleAuthor(Integer aaId);
}