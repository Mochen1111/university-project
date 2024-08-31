package cn.edu.tyut.service;

import cn.edu.tyut.model.Article;
import cn.edu.tyut.model.Comment;
import cn.edu.tyut.model.User;

import java.util.List;

public interface CommentService {
    public int add(User user, Integer articleId, String commentContent);
    public int update(Comment comment);
    public int delete(int id);
    public List<Comment> getComments();
    public Comment getCommentById(int id);
    public List<Comment> getCommentsByArticleId(int articleId);
}
