package cn.edu.tyut.controller;

import cn.edu.tyut.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminShareController {
    @Autowired
    private ShareService shareService;

    @RequestMapping("/adminShare")
    public String adminShare(Model model){
        model.addAttribute("ShareList", shareService.getShareList());
        return "/adminShare";
    }

    @RequestMapping("/adminDeleteShare")
    public String adminDeleteShare(Integer shareId, Model model){
        int flag = shareService.deleteShare(shareId);
        model.addAttribute("flag",true);
        if (flag == 1){
            model.addAttribute("message","删除成功");
        }else {
            model.addAttribute("message","删除失败");
        }
        return adminShare(model);
    }
}
