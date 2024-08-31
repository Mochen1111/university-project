package cn.edu.tyut.model;

public class Article {
    private Integer articleId;
    private String articleTitle;
    private String articleContent;
    private String articleTranslation;

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleTranslation='" + articleTranslation + '\'' +
                '}';
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTranslation() {
        return articleTranslation;
    }

    public void setArticleTranslation(String articleTranslation) {
        this.articleTranslation = articleTranslation;
    }

    public Article() {
    }

    public Article(String articleTitle, String articleContent, String articleTranslation) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleTranslation = articleTranslation;
    }
}
