package cn.edu.tyut.controller;

import cn.edu.tyut.model.*;
import cn.edu.tyut.service.ArticleService;
import cn.edu.tyut.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminAuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ArticleService articleService;

    // 管理员管理诗人
    @RequestMapping("/adminAuthor")
    public String adminAuthor(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("Authors", authors);
        return "/adminAuthor";
    }

    // 管理员添加诗人页面跳转
    @RequestMapping("/adminAddAuthor")
    public String adminAddAuthor(Model model) {
        return "/adminAddAuthor";
    }

    // 管理员添加诗人
    @PostMapping("/admin/AddAuthor")
    public String adminAddAuthor1(Author author,Model model) {
        int flag = authorService.add(author);
        model.addAttribute("flag", true);
        if (flag > 0) {
            model.addAttribute("message", "添加成功");
        }else {
            model.addAttribute("message", "添加失败");
        }
        return adminAddAuthor(model);
    }

    // 管理员修改诗人信息页面跳转
    @RequestMapping("/admin/authorId")
    public String adminAuthorId(Model model,int authorId) {
        Author author = authorService.findById(authorId);
        model.addAttribute("Author", author);
        return "/adminAuthorPage";
    }

    // 管理员修改诗人信息
    @PostMapping("/admin/updateAuthor")
    public String adminUpdateAuthor(Author author,Model model) {
        int flag = authorService.update(author);
        model.addAttribute("flag", true);
        if (flag > 0) {
            model.addAttribute("message", "修改成功");
        }else {
            model.addAttribute("message", "修改失败");
        }
        return adminAuthorId(model, author.getAuthorId());
    }
}
