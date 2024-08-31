package cn.edu.tyut.service;

import cn.edu.tyut.dao.CommentMapper;
import cn.edu.tyut.model.Comment;
import cn.edu.tyut.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    // 插入评论信息
    @Override
    public int add(User user, Integer articleId, String commentContent) {
        // 获取当前时间
        Date date = new Date();
        Comment comment = new Comment(articleId, user.getUserId(), commentContent, date);
        int result = commentMapper.insertComment(comment);
        return result;
    }

    // 更新评论信息
    @Override
    public int update(Comment comment) {
        int result = commentMapper.updateComment(comment);
        return result;
    }

    // 删除评论信息
    @Override
    public int delete(int id) {
        int result = commentMapper.deleteComment(id);
        return result;
    }

    // 查询所有评论信息
    @Override
    public List<Comment> getComments() {
        List<Comment> comments = commentMapper.selectAllComments();
        if (comments == null || comments.isEmpty()) {
            return Collections.emptyList();
        }else {
            return comments;
        }
    }

    // 根据评论ID查询评论信息
    @Override
    public Comment getCommentById(int id) {
        Comment comment = commentMapper.selectCommentById(id);
        if (comment == null) {
            return null;
        }else {
            return comment;
        }
    }

    // 根据文章ID查询评论信息
    @Override
    public List<Comment> getCommentsByArticleId(int articleId) {
        List<Comment> comments = commentMapper.selectCommentsByArticleId(articleId);
        if (comments == null || comments.isEmpty()) {
            return Collections.emptyList();
        }else {
            return comments;
        }
    }
}
