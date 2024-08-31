package cn.edu.tyut.dao;

import cn.edu.tyut.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 插入文章信息
    @Insert("INSERT INTO articles(article_title, article_content, article_translation) VALUES(#{articleTitle}, #{articleContent}, #{articleTranslation})")
    @Options(useGeneratedKeys = true, keyProperty = "articleId", keyColumn = "article_id")
    int insertArticle(Article article);

    // 根据文章标题查询文章列表
    @Select("SELECT * FROM articles WHERE article_title like CONCAT('%',#{articleTitle},'%') OR article_content like CONCAT('%',#{articleTitle},'%')")
    List<Article> selectArticleByTitle(String articleTitle);

    // 根据文章ID查询文章信息
    @Select("SELECT * FROM articles WHERE article_id = #{articleId}")
    Article selectArticleById(Integer articleId);

    // 查询所有文章信息
    @Select("SELECT * FROM articles")
    List<Article> selectAllArticles();

    // 更新文章信息
    @Update("UPDATE articles SET article_title=#{articleTitle}, article_content=#{articleContent}, article_translation=#{articleTranslation} WHERE article_id=#{articleId}")
    int updateArticle(Article article);

    // 删除文章信息
    @Delete("DELETE FROM articles WHERE article_id = #{articleId}")
    int deleteArticle(Integer articleId);
}