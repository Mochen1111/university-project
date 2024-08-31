package cn.edu.tyut.dao;

import cn.edu.tyut.model.UCollection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UCollectionMapper {

    // 插入收藏信息
    @Insert("INSERT INTO collections(collection_id, article_id) VALUES(#{collectionId}, #{articleId})")
    @Options(useGeneratedKeys = true, keyProperty = "ucId", keyColumn = "uc_id")
    int insertUCollection(UCollection uCollection);

    // 根据ID查询收藏信息
    @Select("SELECT * FROM collections WHERE uc_id = #{ucId}")
    UCollection selectUCollectionById(Integer ucId);

    // 查询所有收藏信息
    @Select("SELECT * FROM collections")
    List<UCollection> selectAllUCollections();

    // 根据文章ID查询收藏信息
    @Select("SELECT * FROM collections WHERE article_id = #{articleId}")
    List<UCollection> selectUCollectionsByArticleId(Integer articleId);

    // 根据收藏夹ID查询收藏的文章ID
    @Select("SELECT article_id FROM collections WHERE collection_id = #{collectionId}")
    List<Integer> selectArticleIdsByCollectionId(Integer collectionId);

    // 删除收藏信息
    @Delete("DELETE FROM collections WHERE collection_id = #{collectionId} AND article_id = #{articleId}")
    int deleteUCollection(@Param("collectionId") Integer collectionId,@Param("articleId") Integer articleId);

    // 根据收藏夹ID文章ID查询
    @Select("SELECT uc_id FROM collections WHERE collection_id = #{collectionId} AND article_id = #{articleId};")
    Integer selectUcIdByCollectionIdAndArticleId(@Param("collectionId") Integer collectionId, @Param("articleId") Integer articleId);
}