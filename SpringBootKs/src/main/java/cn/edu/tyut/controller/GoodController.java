package cn.edu.tyut.controller;

import cn.edu.tyut.domain.*;
import cn.edu.tyut.service.AddressService;
import cn.edu.tyut.service.GoodImageService;
import cn.edu.tyut.service.GoodService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodImageService goodImageService;
    @Autowired
    private AddressService addressService;

    @RequestMapping("/toIndex.html")
    public String toIndex(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize",required = false,defaultValue = "20") Integer pageSize,
                          Model model){
        PageInfo<Good> goodList = goodService.findAllGood(pageNum,pageSize);

        int num = goodList.getPages();
        model.addAttribute("pageNum",num);
        model.addAttribute("flag",true);
        model.addAttribute("goodList", goodList);
        return "/user/index";
    }

    @RequestMapping("/user/goodId")
    public String userGoodId(Integer id, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        Good good = goodService.findGoodById(id);
        GoodImage goodImage = goodImageService.findGoodImage(id);
        model.addAttribute("good", good);
        model.addAttribute("goodImage", goodImage);
        return "/user/goodPages";
    }

    @PostMapping("/user/goodFind")
    public String userGoodFind(String goodName,Model model){
        if (goodName == null || goodName.equals("")){
            return toIndex(1,20,model);
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
        return "/user/index";
    }

    @PostMapping("/user/goodBuy")
    public String userGoodBuy(Integer goodId, Integer goodNum, Integer buyType, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }

        Good good = goodService.findGoodById(goodId);
        model.addAttribute("flag",true);
        if (good.getGoodNum() < goodNum){
            model.addAttribute("message","您购买的物品数量不足，请检查后下单");
        }
        List<Good> goodList = new ArrayList<>();
        goodList.add(good);
        List<Address> addressList = addressService.findByUserId(user.getUid());

        double money = 0;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(money));
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(good.getGoodPrice()));
        bigDecimal = bigDecimal1.multiply(BigDecimal.valueOf(goodNum));

        List<ShopCar> shopCarList = new ArrayList<>();
        ShopCar shopCar = new ShopCar(user.getUid(),good.getGoodId(),goodNum);
        shopCarList.add(shopCar);

        model.addAttribute("buyType",buyType);
        model.addAttribute("shopCarList", shopCarList);
        model.addAttribute("goodList", goodList);
        model.addAttribute("addressList", addressList);
        model.addAttribute("money",bigDecimal.doubleValue());
        return "/user/buyCheckBuy";
    }
}
