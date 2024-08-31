package cn.edu.tyut.model;

import java.util.Date;

public class Comment {
    private Integer commentId;
    private Integer articleId;
    private Integer userId;
    private String commentContent;
    private Date commentTime;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Comment() {
    }

    public Comment(Integer articleId, Integer userId, String commentContent, Date commentTime) {
        this.articleId = articleId;
        this.userId = userId;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }
}
