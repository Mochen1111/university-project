package cn.edu.tyut.model;

public class LabelArticle {
    private Integer laId;
    private Integer labelId;
    private Integer articleId;

    @Override
    public String toString() {
        return "Label_article{" +
                "laId=" + laId +
                ", labelId=" + labelId +
                ", articleId=" + articleId +
                '}';
    }

    public Integer getLaId() {
        return laId;
    }

    public void setLaId(Integer laId) {
        this.laId = laId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public LabelArticle() {
    }

    public LabelArticle(Integer labelId, Integer articleId) {
        this.labelId = labelId;
        this.articleId = articleId;
    }
}
