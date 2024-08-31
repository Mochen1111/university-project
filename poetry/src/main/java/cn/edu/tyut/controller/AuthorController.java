package cn.edu.tyut.controller;

import cn.edu.tyut.model.*;
import cn.edu.tyut.service.ArticleService;
import cn.edu.tyut.service.AuthorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ArticleService articleService;

    // 查询诗人
    @RequestMapping("/userAuthor")
    public String userAuthor(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model) {

        PageHelper.startPage(pageNum,pageSize);
        List<Author> authors = authorService.findAll();
        PageInfo<Author> pageInfo = new PageInfo<>(authors);
        model.addAttribute("Authors", pageInfo.getList());
        // 获取分页信息
        model.addAttribute("pageNum", pageInfo.getPages());
        return "/author";
    }

    // 查询诗人的详细信息
    @RequestMapping("/author/authorId")
    public String authorId(Integer authorId, Model model) {
        Author author = authorService.findById(authorId);
        model.addAttribute("Author", author);
        List<Article> articleList = articleService.getArticleByAuthor(author.getAuthorName());
        model.addAttribute("ArticleList", articleList);
        return "/authorPage";
    }
}
