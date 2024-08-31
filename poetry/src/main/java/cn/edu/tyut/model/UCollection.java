package cn.edu.tyut.model;

public class UCollection {
    private Integer ucId;
    private Integer collectionId;
    private Integer articleId;

    @Override
    public String toString() {
        return "UCollection{" +
                "ucId=" + ucId +
                ", collectionId=" + collectionId +
                ", articleId=" + articleId +
                '}';
    }

    public Integer getUcId() {
        return ucId;
    }

    public void setUcId(Integer ucId) {
        this.ucId = ucId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public UCollection() {
    }

    public UCollection(Integer collectionId, Integer articleId) {
        this.collectionId = collectionId;
        this.articleId = articleId;
    }
}
