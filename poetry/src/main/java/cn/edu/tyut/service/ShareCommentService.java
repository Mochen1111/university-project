package cn.edu.tyut.service;

import cn.edu.tyut.model.ShareComment;
import cn.edu.tyut.model.User;

import java.util.List;

public interface ShareCommentService {
    public int addShareComment(User user, String comment,Integer shareId);
    public int deleteShareComment(User user, Integer shareId);
    public List<ShareComment> getShareComment(Integer shareId);
}
