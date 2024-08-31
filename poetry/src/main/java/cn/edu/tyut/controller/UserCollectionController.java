package cn.edu.tyut.controller;

import cn.edu.tyut.model.*;
import cn.edu.tyut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserCollectionController {
    @Autowired
    private UserCollectionService userCollectionService;

    //收藏
    @RequestMapping("/userCollection")
    public String userCollection(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/login";
        }
        List<Article> articleList = userCollectionService.selectCollection(user);
        if (articleList == null) {
            model.addAttribute("message", "您还没有收藏任何诗文");
        }
        model.addAttribute("ArticleList", articleList);
        return "/userCollection";
    }

    //取消收藏
    @RequestMapping("/userCollectionDelete")
    public String userCollectionDelete(Integer articleId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/login";
        }
        int result = userCollectionService.deleteCollection(user.getUserId(), articleId);
        model.addAttribute("flag", true);
        if (result == 1) {
            model.addAttribute("message", "取消收藏成功");
        }else {
            model.addAttribute("message", "取消收藏失败");
        }
        return userCollection(session, model);
    }
}
