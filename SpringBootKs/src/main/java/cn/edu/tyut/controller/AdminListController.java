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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminListController {
    @Autowired
    private UserService userService;
    @Autowired
    private AListService aListService;
    @Autowired
    private SListService sListService;
    @Autowired
    private GoodService goodService;

    @RequestMapping("/admin/aList")
    public String aList(Model model) {
        List<AList> aListList = aListService.findAll();
        model.addAttribute("aListList", aListList);
        return "admin/aList";
    }

    @RequestMapping("/admin/confirm")
    public String confirm(Integer aid,Integer status, Model model){
        AList aList = aListService.findById(aid);
        if (status == 1){
            aList.setStatus("已备货");
        }else if (status == 2){
            aList.setStatus("已配送");
        }
        int flag = aListService.updateList(aList);

        model.addAttribute("aList", aList);
        if(flag == 1){
            model.addAttribute("flag",true);
            model.addAttribute("message","订单状态修改完成，状态为："+aList.getStatus());
        }
        return aList(model);
    }

    @RequestMapping("/admin/aListId")
    public String aListId(Integer aid,Model model){
        AList aList = aListService.findById(aid);
        List<SList> sLists = sListService.findByAid(aid);
        User user = userService.findUserById(aList.getUid());
        List<Good> goodList = new ArrayList<Good>();
        for (SList sList : sLists) {
            Good good = goodService.findGoodById(sList.getGoodId());
            goodList.add(good);
        }
        model.addAttribute("user", user);
        model.addAttribute("goodList", goodList);
        model.addAttribute("sLists", sLists);
        model.addAttribute("aList", aList);
        return "/admin/aListPage";
    }

    @PostMapping("/admin/listFind")
    public String listFind(Integer aid, Model model){
        List<AList> aListList = new ArrayList<>();
        if (aid == null){
            aListList = aListService.findAll();
            model.addAttribute("aListList", aListList);
            return "/admin/aList";
        }else {
            AList aList = aListService.findById(aid);
            if (aList == null){
                aListList = aListService.findAll();
                model.addAttribute("aListList", aListList);
                model.addAttribute("flag",true);
                model.addAttribute("message","您查找的订单不存在");
            }else {
                model.addAttribute("aListList", aList);
            }
            return "/admin/aList";
        }
    }

    @RequestMapping("/admin/findStatus")
    public String findStatus(String status,Model model){
        List<AList> aLists = new ArrayList<>();
        if (status.equals("未完成")){
            aLists = aListService.findByStatus("已下单");
            aLists.addAll(aListService.findByStatus("已备货"));
            aLists.addAll(aListService.findByStatus("已配送"));
            model.addAttribute("aListList", aLists);
        }else if(status.equals("已下单")){
            aLists = aListService.findByStatus(status);
            model.addAttribute("aListList", aLists);
        }
        return "/admin/aList";
    }
}
