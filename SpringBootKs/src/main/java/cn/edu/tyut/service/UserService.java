package cn.edu.tyut.service;

import cn.edu.tyut.domain.User;

import java.util.List;

public interface UserService {
    int deleteUser(int id);
    int updateUser(User user);
    User findUserById(int id);
    User findUserByUsername(String username);
    List<User> findAllUser();
    int registerUser(User user);
    User loginUser(User user);
}
