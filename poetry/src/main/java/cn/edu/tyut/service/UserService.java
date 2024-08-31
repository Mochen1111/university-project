package cn.edu.tyut.service;

import cn.edu.tyut.model.User;

import java.util.List;

public interface UserService {
    public User login(User user);
    public User register(User user);
    public User update(User user);
    public int delete(User user);
    public User findByUserId(int id);
    public List<User> findAllUser();
}
