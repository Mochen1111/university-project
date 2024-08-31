package cn.edu.tyut.dao;

import cn.edu.tyut.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // 插入用户信息
    @Insert("INSERT INTO users(user_name, user_password, user_email, user_phone, auth) VALUES(#{userName}, #{userPassword}, #{userEmail}, #{userPhone}, #{auth})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    int insertUser(User user);

    // 根据用户ID查询用户信息
    @Select("SELECT * FROM users WHERE user_id = #{userId}")
    User selectUserById(Integer userId);

    // 查询所有用户信息
    @Select("SELECT * FROM users")
    List<User> selectAllUsers();

    // 根据用户名查询用户信息
    @Select("SELECT * FROM users WHERE user_name = #{userName}")
    User selectUserByName(String userName);

    // 更新用户信息
    @Update("UPDATE users SET user_password=#{userPassword}, user_email=#{userEmail}, user_phone=#{userPhone}, auth=#{auth} WHERE user_id=#{userId}")
    int updateUser(User user);

    // 删除用户信息
    @Delete("DELETE FROM users WHERE user_id = #{userId}")
    int deleteUser(Integer userId);
}