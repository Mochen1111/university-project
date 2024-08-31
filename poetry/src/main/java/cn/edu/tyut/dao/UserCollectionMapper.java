package cn.edu.tyut.dao;

import cn.edu.tyut.model.UserCollection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserCollectionMapper {

    // 插入用户收藏信息
    @Insert("INSERT INTO user_collection(user_id) VALUES(#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "collectionId", keyColumn = "collection_id")
    int insertUserCollection(UserCollection userCollection);

    // 根据收藏ID查询用户收藏信息
    @Select("SELECT * FROM user_collection WHERE collection_id = #{collectionId}")
    UserCollection selectUserCollectionById(Integer collectionId);

    // 查询所有用户收藏信息
    @Select("SELECT * FROM user_collection")
    List<UserCollection> selectAllUserCollections();

    // 根据用户ID查询收藏信息
    @Select("SELECT * FROM user_collection WHERE user_id = #{userId}")
    UserCollection selectUserCollectionsByUserId(Integer userId);

    // 删除用户收藏信息
    @Delete("DELETE FROM user_collection WHERE collection_id = #{collectionId}")
    int deleteUserCollection(Integer collectionId);
}