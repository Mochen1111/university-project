package cn.edu.tyut.dao;

import cn.edu.tyut.model.LabelArticle;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LabelArticleMapper {

    // 插入标签与文章关联信息
    @Insert("INSERT INTO label_article(label_id, article_id) VALUES(#{labelId}, #{articleId})")
    @Options(useGeneratedKeys = true, keyProperty = "laId", keyColumn = "la_id")
    int insertLabelArticle(LabelArticle labelArticle);

    // 根据标签ID查询关联的文章ID列表
    @Select("SELECT article_id FROM label_article WHERE label_id = #{labelId}")
    List<Integer> selectArticleIdsByLabelId(Integer labelId);

    // 根据文章ID查询关联的标签ID列表
    @Select("SELECT label_id FROM label_article WHERE article_id = #{articleId}")
    List<Integer> selectLabelIdsByArticleId(Integer articleId);

    // 根据关联ID查询标签与文章关联信息
    @Select("SELECT * FROM label_article WHERE la_id = #{laId}")
    LabelArticle selectLabelArticleByLaId(Integer laId);

    // 更新标签与文章关联信息
    @Update("UPDATE label_article SET label_id=#{labelId}, article_id=#{articleId} WHERE la_id=#{laId}")
    int updateLabelArticle(LabelArticle labelArticle);

    // 删除标签与文章关联信息
    @Delete("DELETE FROM label_article WHERE la_id = #{laId}")
    int deleteLabelArticle(Integer laId);
}