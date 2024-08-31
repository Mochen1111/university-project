package cn.edu.tyut.service;

import cn.edu.tyut.model.Article;

import java.util.List;

public interface ArticleService {
    public Article addArticle(Article article, Integer[] labelId, Integer authorId);
    public Article getArticle(int id);
    public Article updateArticle(Article article);
    public int deleteArticle(int id);
    public List<Article> getAllArticle();
    public List<Article> getArticleByTitle(String title);
    public List<Article> getArticleByAuthor(String author);
    public List<Article> getArticleByLabel(String label);
}
