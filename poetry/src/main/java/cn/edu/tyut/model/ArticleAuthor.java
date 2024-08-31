package cn.edu.tyut.model;

public class ArticleAuthor {
    private Integer aaId;
    private Integer articleId;
    private Integer authorId;

    @Override
    public String toString() {
        return "Article_author{" +
                "aaId=" + aaId +
                ", articleId=" + articleId +
                ", authorId=" + authorId +
                '}';
    }

    public Integer getAaId() {
        return aaId;
    }

    public void setAaId(Integer aaId) {
        this.aaId = aaId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public ArticleAuthor() {
    }

    public ArticleAuthor(Integer articleId, Integer authorId) {
        this.articleId = articleId;
        this.authorId = authorId;
    }
}
