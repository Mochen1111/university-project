package cn.edu.tyut.model;

import java.util.Date;

public class Share {
    private Integer shareId;
    private Integer userId;
    private String shareContent;
    private Date shareTime;

    @Override
    public String toString() {
        return "Share{" +
                "shareId=" + shareId +
                ", userId=" + userId +
                ", shareContent='" + shareContent + '\'' +
                ", shareTime=" + shareTime +
                '}';
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public Share() {
    }

    public Share(Integer userId, String shareContent, Date shareTime) {
        this.userId = userId;
        this.shareContent = shareContent;
        this.shareTime = shareTime;
    }
}
