package cn.edu.tyut.controller;

import cn.edu.tyut.domain.AList;
import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.User;
import cn.edu.tyut.service.AListService;
import cn.edu.tyut.service.GoodService;
import cn.edu.tyut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private AListService aListService;

    @RequestMapping("/admin/userList")
    public String userList(Model model){
        List<User> userList = userService.findAllUser();
        model.addAttribute("userList", userList);
        return "admin/userList";
    }

    @RequestMapping("/admin/UserId")
    public String userId(Integer id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "admin/userPage";
    }

    @RequestMapping("/admin/deleteId")
    public String deleteId(Integer id,Model model){
        // 调用userService的deleteUser方法删除指定id的用户，返回删除结果
        int flag = userService.deleteUser(id);
        // 调用userService的findUserById方法查找指定id的用户
        User user = userService.findUserById(id);

        // 如果删除成功且用户不存在
        if (flag > 0 && user == null){
            // 将flag属性添加到model中，表示删除成功
            model.addAttribute("flag", true);
            // 将message属性添加到model中，表示删除成功的消息
            model.addAttribute("message","删除成功");
            // 返回用户列表页面
            return userList(model);
        // 如果删除失败且用户不存在
        }else if (flag == 0 && user == null){
            // 返回用户列表页面
            return userList(model);
        // 如果删除失败但用户存在
        }else if (flag == 0 && user != null){
            // 将user属性添加到model中，表示删除失败的用户
            model.addAttribute("user", user);
            // 将flag属性添加到model中，表示删除失败
            model.addAttribute("flag", true);
            // 将message属性添加到model中，表示删除失败的消息
            model.addAttribute("message", "删除失败");
            // 返回用户详情页面
            return "/admin/userPage";
        // 其他情况
        }else {
            // 返回用户列表页面
            return userList(model);
        }
    }

    @PostMapping("/admin/update")
    public String update(Integer id,User user, Model model){
        User user1 = userService.findUserById(id);
        user1.setPassword(user.getPassword());
        user1.setPhone(user.getPhone());
        user1.setEmail(user.getEmail());
        user1.setAuth(user.getAuth());
        int flag = userService.updateUser(user1);
        model.addAttribute("user", user1);
        model.addAttribute("flag", true);
        if (flag > 0){
            model.addAttribute("message", "修改用户信息成功");
        }else {
            model.addAttribute("message", "修改用户信息失败");
        }
        return "/admin/userPage";
    }

    @RequestMapping("/admin/index")
    public String index(Model model){
        List<Good> goodList = goodService.findGoodNumIsNull();
        model.addAttribute("goodList", goodList);
        if (goodList != null && goodList.size() > 0){
            model.addAttribute("flagNum",true);
        }else {
            model.addAttribute("flagNum",false);
        }

        List<AList> aLists = aListService.findByStatus("已下单");
        aLists.addAll(aListService.findByStatus("已备货"));
        aLists.addAll(aListService.findByStatus("已配送"));
        model.addAttribute("aLists", aLists);
        if (aLists != null && aLists.size() > 0){
            model.addAttribute("flagStatus",true);
        }else {
            model.addAttribute("flagStatus",false);
        }
        return "/admin/aIndex";
    }
}
