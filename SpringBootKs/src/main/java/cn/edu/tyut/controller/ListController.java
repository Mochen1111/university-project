package cn.edu.tyut.controller;

import cn.edu.tyut.domain.AList;
import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.SList;
import cn.edu.tyut.domain.User;
import cn.edu.tyut.service.AListService;
import cn.edu.tyut.service.GoodService;
import cn.edu.tyut.service.SListService;
import cn.edu.tyut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {
    @Autowired
    private UserService userService;
    @Autowired
    private AListService aListService;
    @Autowired
    private SListService sListService;
    @Autowired
    private GoodService goodService;

    @RequestMapping("/user/aList")
    public String aList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        List<AList> aListList = aListService.findByUserId(user.getUid());
        model.addAttribute("aListList", aListList);
        return "user/aList";
    }

    @RequestMapping("/user/aListId")
    public String aListId(Integer aid,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        AList aList = aListService.findById(aid);
        List<SList> sLists = sListService.findByAid(aid);
        List<Good> goodList = new ArrayList<Good>();

        for (SList sList : sLists) {
            Good good = goodService.findGoodById(sList.getGoodId());
            goodList.add(good);
        }

        model.addAttribute("goodList", goodList);
        model.addAttribute("sLists", sLists);
        model.addAttribute("aList", aList);
        model.addAttribute("user", user);
        return "user/aListPage";
    }

    @RequestMapping("/user/confirm")
    public String confirm(Integer aid,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        AList aList = aListService.findById(aid);

        List<SList> sLists = sListService.findByAid(aid);
        aList.setStatus("已完成");
        int flag = aListService.updateList(aList);

        model.addAttribute("sLists", sLists);
        model.addAttribute("aList", aList);
        model.addAttribute("user", user);
        if(flag == 1){
            model.addAttribute("flag",true);
            model.addAttribute("message","您的订单已完成，感谢您的购买");
        }
        return aList(session,model);
    }

    @RequestMapping("/user/deleteList")
    public String deleteList(Integer aid,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        int flag1 = 0;
        int flag = aListService.delete(aid);
        List<SList> sList = sListService.findByAid(aid);
        List<Integer> sidList = new ArrayList<>();
        for (SList s : sList) {
            sidList.add(s.getSid());
        }
        if (!sidList.isEmpty()) {
            for (Integer i : sidList) {
                sListService.deleteBySid(i);
            }
            flag1 = 1;
        }
        if (flag == 1 && flag1 == 1) {
            model.addAttribute("flag",true);
            model.addAttribute("message","订单删除成功");
            return aList(session,model);
        }else {
            model.addAttribute("flag",false);
            model.addAttribute("message","订单删除失败");
            return aList(session,model);
        }
    }
}
