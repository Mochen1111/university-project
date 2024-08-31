package cn.edu.tyut.controller;

import cn.edu.tyut.model.*;
import cn.edu.tyut.service.ArticleService;
import cn.edu.tyut.service.AuthorService;
import cn.edu.tyut.service.LabelService;
import cn.edu.tyut.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/adminArticle")
    public String adminArticle(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize ,
                               Model model) {
        // 获取文章进行分页处理
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.getAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        List<Article> articleList = pageInfo.getList();
        model.addAttribute("ArticleList", articleList);
        model.addAttribute("pageNum",pageInfo.getPages());
        return "/adminArticle";
    }

    // 跳转到添加诗文页面，携带诗人和标签
    @RequestMapping("/adminAddArticle")
    public String adminAddArticle(Model model) {
        // 获取标签
        List<Label> labels = labelService.getAllLabel();
        model.addAttribute("LabelList", labels);
        // 获取诗人
        List<Author> authors = authorService.findAll();
        model.addAttribute("AuthorList", authors);
        return "/adminAddArticle";
    }

    // 添加诗文
    @PostMapping("/admin/AddArticle")
    public String adminAddArticle1(Article article,Integer[] labelId,Integer authorId,Model model) {
        Article article1 = articleService.addArticle(article, labelId, authorId);
        model.addAttribute("flag", true);
        if (article1 != null) {
            model.addAttribute("message", "添加成功");
        }else {
            model.addAttribute("message", "添加失败");
        }
        return adminAddArticle(model);
    }

    // 查看诗文详情
    @RequestMapping("/admin/articleId")
    public String articleId(int articleId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("message", "请先登录");
            return "/login";
        }
        if (user.getAuth() != 1) {
            model.addAttribute("message", "权限不足");
            return "/login";
        }
        Article article = articleService.getArticle(articleId);
        model.addAttribute("Article", article);
        return "/adminArticlePage";
    }

    // 修改文章
    @PostMapping("/admin/articleUpdate")
    public String adminArticleUpdate(Article article,Model model,HttpSession session) {
        // 修改文章
        Article article1 = articleService.updateArticle(article);
        model.addAttribute("flag", true);
        if (article1 != null) {
            // 修改成功
            model.addAttribute("message", "修改成功");
        }else {
            // 修改失败
            model.addAttribute("message", "修改失败");
        }
        return articleId(article.getArticleId(),model,session);
    }
}
