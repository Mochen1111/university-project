package cn.edu.tyut.repository;

import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    // 根据用户ID查询用户信息
    @Select("SELECT * FROM users WHERE uid = #{uid}")
    User findUserById(@Param("uid") Integer uid);

    // 查询所有用户信息
    @Select("SELECT * FROM users")
    List<User> findAllUsers();

    // 根据用户名查询用户信息
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findUserByUsername(@Param("username") String username);

    // 插入新用户信息
    @Insert("INSERT INTO users(username, password, phone, email, auth) VALUES(#{username}, #{password}, #{phone}, #{email}, #{auth})")
    int insertUser(User user);

    // 更新用户信息
    @Update("UPDATE users SET password=#{password}, phone=#{phone}, email=#{email}, auth=#{auth} WHERE uid=#{uid}")
    int updateUser(User user);

    // 删除用户信息
    @Delete("DELETE FROM users WHERE uid=#{uid}")
    int deleteUser(@Param("uid") Integer uid);
}