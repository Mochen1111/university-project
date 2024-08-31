package cn.edu.tyut.service;

import cn.edu.tyut.dao.ShareCommentMapper;
import cn.edu.tyut.model.ShareComment;
import cn.edu.tyut.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShareCommentServiceImpl implements ShareCommentService {
    @Autowired
    private ShareCommentMapper shareCommentMapper;

    // 添加评论
    @Override
    public int addShareComment(User user, String comment, Integer shareId) {
        ShareComment shareComment = new ShareComment(user.getUserId(),shareId,comment);
        int flag = shareCommentMapper.insertShareComment(shareComment);
        if(flag == 1){
            return flag;
        }else {
            return 0;
        }
    }

    // 删除评论
    @Override
    public int deleteShareComment(User user, Integer shareId) {
        int flag = shareCommentMapper.deleteShareComment(user.getUserId(),shareId);
        return flag;
    }

    // 查询评论
    @Override
    public List<ShareComment> getShareComment(Integer shareId) {
        // 查询评论
        List<ShareComment> shareComments = shareCommentMapper.selectShareCommentsByShareId(shareId);
        if (!shareComments.isEmpty()) {
            return shareComments;
        }else {
            return Collections.emptyList();
        }
    }
}
