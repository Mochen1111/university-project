package cn.edu.tyut.service;

import cn.edu.tyut.domain.User;
import cn.edu.tyut.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteUser(int id) {
        int flag = 0;
        flag = userMapper.deleteUser(id);
        return flag;
    }

    @Override
    public int updateUser(User user) {
        int flag = 0;
        flag = userMapper.updateUser(user);
        return flag;
    }

    @Override
    public User findUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        List<User> list = userMapper.findAllUsers();
        return list;
    }

    @Override
    public int registerUser(User user) {
        // 根据用户名查找用户
        User user1 = userMapper.findUserByUsername(user.getUsername());
        int flag = 0;
        // 如果找到了用户
        if(user1 != null){
            // 返回标志位0，表示注册失败
            return flag;
        }else {
            // 设置用户的权限为2
            user.setAuth(2);
            // 插入用户信息到数据库
            flag = userMapper.insertUser(user);
            // 返回标志位，表示注册成功或失败
            return flag;
        }
    }

    @Override
    public User loginUser(User user) {
        // 通过用户名查找用户
        User user1 = userMapper.findUserByUsername(user.getUsername());

        // 如果找到用户且密码匹配
        if (user1 != null && user1.getPassword().equals(user.getPassword())){
            // 返回找到的用户
            return user1;
        // 如果找不到用户
        } else if (user1 == null) {
            // 创建一个新的用户对象，设置用户名为"用户不存在"
            User userCheck = new User();
            userCheck.setUsername("用户不存在");
            // 返回新用户对象
            return userCheck;
        // 如果找到用户但密码不匹配
        } else {
            // 创建一个新的用户对象，设置用户名为"用户名或密码错误"
            User userCheck = new User();
            userCheck.setUsername("用户名或密码错误");
            // 返回新用户对象
            return userCheck;
        }
    }
}
