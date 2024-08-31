package cn.edu.tyut.controller;

import cn.edu.tyut.domain.Address;
import cn.edu.tyut.domain.User;
import cn.edu.tyut.service.AddressService;
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
    private GoodController goodController;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AdminController adminController;

    @PostMapping("/register")
    public String register(User user,Model model){
        int flag = 0;
        flag = userService.registerUser(user);
        model.addAttribute("flag", true);
        if (flag > 0){
            return "/login";
        }else{
            model.addAttribute("message","提示：用户名已存在，请选择其他用户名");
            return "/register";
        }
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("flag", true);
        User userCheck = userService.loginUser(user);
        if (userCheck.getUsername().equals(username) && userCheck.getPassword().equals(password)){
            session.setAttribute("user", userCheck);
            if (userCheck.getAuth().equals(1)){
                return adminController.index(model);
            }else {
                return goodController.toIndex(1,2,model);
            }
        }else {
            model.addAttribute("message",userCheck.getUsername());
            return "/login";
        }
    }

    @RequestMapping("/user/center")
    public String center(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        List<Address> addressList = addressService.findByUserId(user.getUid());
        if (addressList == null || addressList.isEmpty()){
            model.addAttribute("flag",true);
            model.addAttribute("message","您还没有收货地址，请先添加地址");
        }
        model.addAttribute("addressList", addressList);
        model.addAttribute("user",user);
        return "/user/center";
    }

    @PostMapping("/user/update")
    public String update(User user,Model model,HttpSession session){
        User userSession = (User) session.getAttribute("user");
        user.setUid(userSession.getUid());
        user.setUsername(userSession.getUsername());
        user.setAuth(userSession.getAuth());
        int i = userService.updateUser(user);
        List<Address> addressList = addressService.findByUserId(user.getUid());
        model.addAttribute("addressList", addressList);
        model.addAttribute("flag",true);
        if (i > 0){
            session.setAttribute("user", user);
            model.addAttribute("message","您的个人信息修改成功");
        }else {
            model.addAttribute("message","您的个人信息修改失败");
        }
        return "/user/center";
    }

    @RequestMapping("/user/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "/login";
    }
}
