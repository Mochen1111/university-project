package cn.edu.tyut.dao;

import cn.edu.tyut.model.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorMapper {

    // 插入作者信息
    @Insert("INSERT INTO authors(author_name, author_content) VALUES(#{authorName}, #{authorContent})")
    @Options(useGeneratedKeys = true, keyProperty = "authorId", keyColumn = "author_id")
    int insertAuthor(Author author);

    // 根据作者ID查询作者信息
    @Select("SELECT * FROM authors WHERE author_id = #{authorId}")
    Author selectAuthorById(Integer authorId);

    // 根据作者姓名查询作者信息
    @Select("SELECT * FROM authors WHERE author_name = #{authorName}")
    List<Author> selectAuthorByName(String authorName);

    // 查询所有作者信息
    @Select("SELECT * FROM authors")
    List<Author> selectAllAuthors();

    // 更新作者信息
    @Update("UPDATE authors SET author_name=#{authorName}, author_content=#{authorContent} WHERE author_id=#{authorId}")
    int updateAuthor(Author author);

    // 删除作者信息
    @Delete("DELETE FROM authors WHERE author_id = #{authorId}")
    int deleteAuthor(Integer authorId);
}