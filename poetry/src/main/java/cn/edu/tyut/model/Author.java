package cn.edu.tyut.model;

public class Author {
    private Integer authorId;
    private String authorName;
    private String authorContent;

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorContent='" + authorContent + '\'' +
                '}';
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorContent() {
        return authorContent;
    }

    public void setAuthorContent(String authorContent) {
        this.authorContent = authorContent;
    }

    public Author() {
    }

    public Author(String authorName, String authorContent) {
        this.authorName = authorName;
        this.authorContent = authorContent;
    }
}
