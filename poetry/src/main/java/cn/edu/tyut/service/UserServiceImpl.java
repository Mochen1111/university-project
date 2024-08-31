package cn.edu.tyut.service;

import cn.edu.tyut.dao.UserCollectionMapper;
import cn.edu.tyut.dao.UserMapper;
import cn.edu.tyut.model.User;
import cn.edu.tyut.model.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCollectionMapper userCollectionMapper;

    // 登录用户
    @Override
    public User login(User user) {
        // 查询用户信息
        User userInfo = userMapper.selectUserByName(user.getUserName());
        // 判断用户是否存在
        if (userInfo != null) {
            // 判断密码是否正确
            if (userInfo.getUserPassword().equals(user.getUserPassword())) {
                return userInfo;
            } else {
                return null;
            }
        }
        return null;
    }

    // 注册用户
    @Override
    public User register(User user) {
        // 查询用户信息
        User userInfo = userMapper.selectUserByName(user.getUserName());
        // 判断用户是否存在
        if (userInfo == null) {
            user.setAuth(2);
            // 插入用户信息
            userMapper.insertUser(user);
            userCollectionMapper.insertUserCollection(new UserCollection(user.getUserId()));
            // 返回用户信息
            return user;
        } else {
            // 返回null
            return null;
        }
    }

    // 修改用户信息
    @Override
    public User update(User user) {
        User userInfo = userMapper.selectUserByName(user.getUserName());
        // 判断用户是否存在
        if (userInfo != null) {
            // 更新用户信息
            int flag = userMapper.updateUser(user);
            if (flag == 1) {
                return user;
            }
        }
        return null;
    }

    // 删除用户信息
    @Override
    public int delete(User user) {
        User userInfo = userMapper.selectUserByName(user.getUserName());
        // 判断用户是否存在
        if (userInfo != null) {
            // 删除用户信息
            int flag = userMapper.deleteUser(user.getUserId());
            if (flag == 1) {
                return 1;
            }
        }
        return 0;
    }

    // 根据用户ID查询用户信息
    @Override
    public User findByUserId(int id) {
        User userInfo = userMapper.selectUserById(id);
        if (userInfo != null) {
            return userInfo;
        }
        return null;
    }

    // 查询所有用户信息
    @Override
    public List<User> findAllUser() {
        List<User> userInfo = userMapper.selectAllUsers();
        if (userInfo != null) {
            return userInfo;
        }else {
            return Collections.emptyList();
        }
    }
}
