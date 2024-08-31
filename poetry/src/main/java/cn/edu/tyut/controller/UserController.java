package cn.edu.tyut.controller;

import cn.edu.tyut.model.User;
import cn.edu.tyut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleController articleController;

    // 登录
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        // 判断用户名和密码是否正确
        User userCheck = userService.login(user);
        model.addAttribute("flag",true);
        // 登录失败，提示错误信息
        if (userCheck == null){
            model.addAttribute("message","用户名或密码错误");
            return "/login";
        }else {
            // 登录成功，保存用户信息到session
            session.setAttribute("user",userCheck);
            if (userCheck.getAuth() == 1){
                // 登录成功，跳转到管理员首页
                return toAdminIndex();
            }else {
                // 登录成功，跳转到用户首页
                model.addAttribute("message", "登录成功，欢迎回来！");
                return articleController.index(1, 10, model);
            }
        }
    }

    // 注册
    @PostMapping("/register")
    public String register(User user,Model model){
        // 判断用户名是否重复
        User userCheck = userService.register(user);
        model.addAttribute("flag",true);
        // 用户名重复，提示错误信息
        if (userCheck == null){
            model.addAttribute("message","用户名已存在");
            return "/register";
        }else {
            // 用户名不存在，注册成功，提示信息
            model.addAttribute("message","注册成功，您的用户名为："+userCheck.getUserName());
            return "/login";
        }
    }

    // 跳转到注册页面
    @RequestMapping("/toRegister")
    public String toRegister(Model model) {
        model.addAttribute("flag", false);
        return "/register";
    }

    // 登出
    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("user");
        return "/login";
    }

    // 跳转到管理员首页
    @RequestMapping("/toAdminIndex")
    public String toAdminIndex() {
        return "/adminIndex";
    }

    // 跳转到用户中心
    @RequestMapping("/userCenter")
    public String center(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        model.addAttribute("user",user);
        return "/userCenter";
    }

    // 修改用户信息
    @PostMapping("/userUpdate")
    public String userUpdate(User user, HttpSession session, Model model){
        User userCheck = (User) session.getAttribute("user");
        if (userCheck == null){
            return "/login";
        }
        // 修改用户信息
        userCheck.setUserPassword(user.getUserPassword());
        userCheck.setUserEmail(user.getUserEmail());
        userCheck.setUserPhone(user.getUserPhone());
        User updated = userService.update(userCheck);
        model.addAttribute("flag",true);
        if (updated == null){
            // 修改失败，提示错误信息
            model.addAttribute("message","修改失败");
        }else {
            // 修改成功，更新session中的用户信息
            session.setAttribute("user",updated);
            model.addAttribute("message","修改成功");
        }
        // 跳转到用户中心
        return center(session,model);
    }
}

