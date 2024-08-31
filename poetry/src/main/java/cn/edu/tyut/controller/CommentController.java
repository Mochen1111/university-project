package cn.edu.tyut.controller;

import cn.edu.tyut.model.User;
import cn.edu.tyut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    private UserService usersService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleController articleController;

    @PostMapping("/article/addComment")
    public String addComment(int articleId, String commentContent, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "/login";
        }
        // 添加评论
        int flag = commentService.add(user, articleId, commentContent);
        model.addAttribute("flag", true);
        if(flag == 0){
            model.addAttribute("message", "评论失败");
        }else {
            model.addAttribute("message", "评论成功");
        }
        return articleController.article(articleId, model, session);
    }
}
