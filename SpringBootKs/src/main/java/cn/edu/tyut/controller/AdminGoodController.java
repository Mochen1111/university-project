package cn.edu.tyut.controller;

import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.GoodImage;
import cn.edu.tyut.service.GoodImageService;
import cn.edu.tyut.service.GoodService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AdminGoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodImageService goodImageService;

    @RequestMapping("/admin/goodList")
    public String goodList(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "20") Integer pageSize,
                           Model model){
        PageInfo<Good> goodListlist = goodService.findAllGood(pageNum,pageSize);

        model.addAttribute("flag",true);
        model.addAttribute("pageNum",goodListlist.getPages());
        model.addAttribute("goodList", goodListlist);
        return "/admin/goodList";
    }

    @RequestMapping("/admin/goodAddList")
    public String goodAddList(Model model,HttpSession session){
        return "/admin/goodAddList";
    }

    @RequestMapping("/admin/goodId")
    public String goodId(Integer id,Model model){
        Good good = goodService.findGoodById(id);
        GoodImage goodImage = goodImageService.findGoodImage(id);
        model.addAttribute("good", good);
        model.addAttribute("goodImage", goodImage);
        return "/admin/goodPages";
    }

    @RequestMapping("/admin/deleteGood")
    public String deleteGood(Integer id,Model model){
        int flag = goodService.deleteGood(id);
        int flag1 = goodImageService.deleteGoodImage(id);
        model.addAttribute("flag",true);
        if(flag>0 && flag1>0){
            model.addAttribute("message", "商品下架成功");
        }else {
            model.addAttribute("message","商品下架失败");
        }
        return goodList(1,20,model);
    }

    @PostMapping("/admin/goodFind")
    public String userGoodFind(String goodName,Model model){
        if (goodName == null || goodName.equals("")){
            return goodList(1,20,model);
        }
        List<Good> goodList = goodService.findGoodByName(goodName);
        List<Good> goodList1 = goodService.findGoodByType(goodName);

        goodList.addAll(goodList1);
        PageInfo<Good> goodPageInfo = new PageInfo<>(goodList);
        model.addAttribute("goodList", goodPageInfo);
        model.addAttribute("pageNum",goodPageInfo.getPages());

        if (!goodList.isEmpty()){
            model.addAttribute("flag",true);
        }else {
            model.addAttribute("flag",false);
        }
        return "/admin/goodList";
    }
}
