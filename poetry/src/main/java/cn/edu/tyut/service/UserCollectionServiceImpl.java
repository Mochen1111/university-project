package cn.edu.tyut.service;

import cn.edu.tyut.dao.*;
import cn.edu.tyut.model.Article;
import cn.edu.tyut.model.UCollection;
import cn.edu.tyut.model.User;
import cn.edu.tyut.model.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserCollectionServiceImpl implements UserCollectionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UCollectionMapper collectionMapper;
    @Autowired
    private UserCollectionMapper userCollectionMapper;
    @Autowired
    private ArticleMapper articleMapper;

    // 添加收藏
    @Override
    public int addCollection(Integer userId, Integer articleId) {
        UserCollection userCollection = userCollectionMapper.selectUserCollectionsByUserId(userId);
        // 判断是否已经收藏
        Integer ucId = collectionMapper.selectUcIdByCollectionIdAndArticleId(userCollection.getCollectionId(), articleId);
        if (ucId != null) {
            return -1;
        }
        // 插入收藏信息
        UCollection collection = new UCollection(userCollection.getCollectionId(), articleId);
        int flag = collectionMapper.insertUCollection(collection);
        return flag;
    }

    // 删除收藏
    @Override
    public int deleteCollection(Integer userId, Integer articleId) {
        // 查询收藏信息
        UserCollection userCollection = userCollectionMapper.selectUserCollectionsByUserId(userId);
        int flag = collectionMapper.deleteUCollection(userCollection.getCollectionId(), articleId);
        return flag;
    }

    // 查询收藏
    @Override
    public List<Article> selectCollection(User user) {
        // 查询收藏信息
        UserCollection userCollection = userCollectionMapper.selectUserCollectionsByUserId(user.getUserId());
        List<Integer> articleIds = collectionMapper.selectArticleIdsByCollectionId(userCollection.getCollectionId());
        List<Article> articles = new ArrayList<Article>();
        // 查询文章信息
        if (articleIds == null || articleIds.isEmpty()) {
            return Collections.emptyList();
        }else {
            for (Integer articleId : articleIds) {
                Article article = articleMapper.selectArticleById(articleId);
                articles.add(article);
            }
        }
        return articles;
    }
}
