package cn.edu.tyut.service;

import cn.edu.tyut.dao.ArticleAuthorMapper;
import cn.edu.tyut.dao.ArticleMapper;
import cn.edu.tyut.dao.AuthorMapper;
import cn.edu.tyut.model.ArticleAuthor;
import cn.edu.tyut.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleAuthorMapper articleAuthorMapper;

    // 查询所有作者信息
    @Override
    public List<Author> findAll() {
        List<Author> authors = authorMapper.selectAllAuthors();
        if (authors == null) {
            return Collections.emptyList();
        }else {
            return authors;
        }
    }

    // 根据作者ID查询作者信息
    @Override
    public Author findById(int id) {
        Author author = authorMapper.selectAuthorById(id);
        if (author == null) {
            return new Author();
        }else {
            return author;
        }
    }

    // 根据作者姓名查询作者信息
    @Override
    public List<Author> findByName(String authorName) {
        List<Author> authors = authorMapper.selectAuthorByName(authorName);
        if (authors == null) {
            return Collections.emptyList();
        }else {
            return authors;
        }
    }

    // 插入作者信息
    @Override
    public int add(Author author) {
        if (author == null) {
            return 0;
        }
        // 判断作者是否存在
        List<Author> authors = findByName(author.getAuthorName());
        if (authors == null || authors.isEmpty()) {
            // 如果作者不存在，则插入作者信息
            int flag = authorMapper.insertAuthor(author);
            if (flag > 0) {
                return flag;
            }else {
                return 0;
            }
        }else {
            return 0;
        }
    }

    // 更新作者信息
    @Override
    public int update(Author author) {
        if (author == null) {
            return 0;
        }
        int flag = authorMapper.updateAuthor(author);
        return flag;
    }

    // 删除作者信息
    @Override
    public int deleteById(int id) {
        int flag = authorMapper.deleteAuthor(id);
        return flag;
    }

    // 根据文章ID查询作者信息
    @Override
    public Author findAuthorByArticleId(int articleId) {
        // 根据文章ID查询作者关联信息
        ArticleAuthor articleAuthor = articleAuthorMapper.selectArticleAuthorsByArticleId(articleId);
        if (articleAuthor == null) {
            return new Author();
        }else {
            // 根据作者ID查询作者信息
            Author author = authorMapper.selectAuthorById(articleAuthor.getAuthorId());
            if (author == null) {
                return new Author();
            }else {
                return author;
            }
        }
    }
}
