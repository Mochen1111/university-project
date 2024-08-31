package cn.edu.tyut.model;

public class ShareComment {
    private Integer scId;
    private Integer userId;
    private Integer shareId;
    private String scommentContent;

    @Override
    public String toString() {
        return "Share_comment{" +
                "scId=" + scId +
                ", userId=" + userId +
                ", shareId=" + shareId +
                ", scommentContent='" + scommentContent + '\'' +
                '}';
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public String getScommentContent() {
        return scommentContent;
    }

    public void setScommentContent(String scommentContent) {
        this.scommentContent = scommentContent;
    }

    public ShareComment() {
    }

    public ShareComment(Integer userId, Integer shareId, String scommentContent) {
        this.userId = userId;
        this.shareId = shareId;
        this.scommentContent = scommentContent;
    }
}