package cn.edu.tyut.controller;

import cn.edu.tyut.model.Share;
import cn.edu.tyut.model.ShareComment;
import cn.edu.tyut.model.User;
import cn.edu.tyut.service.ShareCommentService;
import cn.edu.tyut.service.ShareCommentServiceImpl;
import cn.edu.tyut.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ShareController {
    @Autowired
    private ShareService shareService;
    @Autowired
    private ShareCommentService shareCommentService;

    // 展示鉴赏列表
    @RequestMapping("/share")
    public String share(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        List<Share> list = shareService.getShareList();
        model.addAttribute("ShareList", list);
        return "/share";
    }

    // 展示详细内容
    @RequestMapping("share/shareId")
    public String shareId(Integer shareId,Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        model.addAttribute("user", user);
        Share share = shareService.getShareListByShareId(shareId);
        model.addAttribute("Share", share);
        List<ShareComment> shareCommentList = shareCommentService.getShareComment(shareId);
        model.addAttribute("ShareCommentList", shareCommentList);
        return "/sharePage";
    }

    // 添加评论
    @PostMapping("/shareComment/addComment")
    public String addComment(String shareCommentContent,Integer shareId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        int flag = shareCommentService.addShareComment(user, shareCommentContent,shareId);
        model.addAttribute("flag", true);
        if (flag == 0){
            model.addAttribute("message", "评论失败");
        }else {
            model.addAttribute("message", "评论成功");
        }
        return shareId(shareId, model, session);
    }


    @RequestMapping("/share/addShare")
    public String addShare(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        return "/addShare";
    }

    @PostMapping("share/AddShare")
    public String AddShare(String shareContent, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        Date date = new Date();
        Share share = new Share(user.getUserId(), shareContent, date);
        int shareId = shareService.addShare(share);
        model.addAttribute("flag", true);
        if (shareId == 0){
            model.addAttribute("message", "添加失败");
        }else {
            model.addAttribute("message", "添加成功");
        }
        return shareId(shareId, model, session);
    }
}
