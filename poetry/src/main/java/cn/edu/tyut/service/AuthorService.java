package cn.edu.tyut.service;

import cn.edu.tyut.model.Article;
import cn.edu.tyut.model.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();
    public Author findById(int id);
    public List<Author> findByName(String authorName);
    public int add(Author author);
    public int update(Author author);
    public int deleteById(int id);
    public Author findAuthorByArticleId(int articleId);
}

