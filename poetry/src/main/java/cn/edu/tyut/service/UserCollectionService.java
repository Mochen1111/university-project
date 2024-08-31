package cn.edu.tyut.service;

import cn.edu.tyut.model.*;

import java.util.List;

public interface UserCollectionService {
    public int addCollection(Integer userId, Integer articleId);
    public int deleteCollection(Integer userId, Integer articleId);
    public List<Article> selectCollection(User user);
}
