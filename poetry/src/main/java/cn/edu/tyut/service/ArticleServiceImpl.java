package cn.edu.tyut.service;

import cn.edu.tyut.dao.*;
import cn.edu.tyut.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private ArticleAuthorMapper articleAuthorMapper;
    @Autowired
    private LabelArticleMapper labelArticleMapper;

    // 插入文章信息
    @Override
    public Article addArticle(Article article,Integer[] labelId,Integer authorId) {
        // 插入文章信息
        int flag = articleMapper.insertArticle(article);
        // 插入文章作者关联信息
        int flag2 = articleAuthorMapper.insertArticleAuthor(new ArticleAuthor(article.getArticleId(),authorId));
        // 插入标签与文章关联信息
        for (Integer label : labelId){
            labelArticleMapper.insertLabelArticle(new LabelArticle(label,article.getArticleId()));
        }
        if (flag > 0 && flag2 > 0) {
            return article;
        }else {
            return null;
        }
    }

    // 根据文章ID查询文章信息
    @Override
    public Article getArticle(int id) {
        return articleMapper.selectArticleById(id);
    }

    // 更新文章信息
    @Override
    public Article updateArticle(Article article) {
        int flag = articleMapper.updateArticle(article);
        if (flag > 0) {
            return article;
        }else {
            return null;
        }
    }

    // 删除文章信息
    @Override
    public int deleteArticle(int id) {
        return articleMapper.deleteArticle(id);
    }

    // 查询所有文章信息
    @Override
    public List<Article> getAllArticle() {
        List<Article> articles = articleMapper.selectAllArticles();
        if (articles == null || articles.isEmpty()) {
            return Collections.emptyList();
        }
        return articles;
    }

    // 根据文章标题查询文章列表
    @Override
    public List<Article> getArticleByTitle(String title) {
        List<Article> articles = articleMapper.selectArticleByTitle(title);
        if (articles == null || articles.isEmpty()) {
            return Collections.emptyList();
        }
        return articles;
    }

    // 根据作者姓名查询文章列表
    @Override
    public List<Article> getArticleByAuthor(String author) {
        // 根据作者姓名查询作者信息
        List<Author> authors = authorMapper.selectAuthorByName(author);
        if (authors == null || authors.isEmpty()) {
            return Collections.emptyList();
        }
        List<Article> articles = new ArrayList<>();
        // 根据作者ID查询文章信息
        for (Author author1 : authors) {
            List<ArticleAuthor> articleAuthors = articleAuthorMapper.selectArticleAuthorsByAuthorId(author1.getAuthorId());
            if (articleAuthors != null && !articleAuthors.isEmpty()) {
                for (ArticleAuthor articleAuthor : articleAuthors) {
                    articles.add(articleMapper.selectArticleById(articleAuthor.getArticleId()));
                }
            }
        }
        return articles;
    }

    // 根据标签名查询文章列表
    @Override
    public List<Article> getArticleByLabel(String label) {
        // 根据标签名查询标签信息
        Label label1 = labelMapper.selectLabelByName(label);
        if (label1 == null) {
            return Collections.emptyList();
        }
        // 根据标签ID查询关联的文章ID列表
        List<Integer> articlesId = labelArticleMapper.selectArticleIdsByLabelId(label1.getLabelId());
        if (articlesId == null || articlesId.isEmpty()) {
            return Collections.emptyList();
        }
        // 根据文章ID查询文章信息
        List<Article> articles = new ArrayList<>();
        for (Integer articleId : articlesId) {
            articles.add(articleMapper.selectArticleById(articleId));
        }
        return articles;
    }
}
