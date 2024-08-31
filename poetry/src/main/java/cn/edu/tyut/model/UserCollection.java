package cn.edu.tyut.model;

public class UserCollection {
    private Integer collectionId;
    private Integer userId;

    @Override
    public String toString() {
        return "User_collection{" +
                "collectionId=" + collectionId +
                ", userId=" + userId +
                '}';
    }

    public UserCollection() {
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserCollection(Integer userId) {
        this.userId = userId;
    }
}
