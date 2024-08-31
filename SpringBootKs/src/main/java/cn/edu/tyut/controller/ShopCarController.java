package cn.edu.tyut.controller;

import cn.edu.tyut.domain.*;
import cn.edu.tyut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ShopCarController {
    @Autowired
    private ShopCarService shopCarService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private GoodImageService goodImageService;
    @Autowired
    private ListController listController;

    @RequestMapping("/user/shopCar")
    public String shopCar(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/login";
        }
        List<ShopCar> shopCarList = shopCarService.findShopCarByUid(user.getUid());
        List<Good> goodList = new ArrayList<Good>();
        for (ShopCar shopCar : shopCarList) {
            Good good = new Good();
            goodList.add(goodService.findGoodById(shopCar.getGoodId()));
        }

        model.addAttribute("shopCarList", shopCarList);
        model.addAttribute("goodList", goodList);
        return "/user/shopCar";
    }

    @PostMapping("/user/buyCheck")
    public String buy(Integer[] goodId,Integer[] shopCarNum,Model model, HttpSession session) {
        // 从session中获取用户信息
        User user = (User) session.getAttribute("user");

        //开始进行地址验证
        // 根据用户ID查找收货地址列表
        List<Address> addressList = addressService.findByUserId(user.getUid());

        // 如果收货地址列表为空或没有地址，则返回添加地址页面并提示用户添加地址
        if (addressList == null || addressList.isEmpty()){
            model.addAttribute("addressList", addressList);
            model.addAttribute("user", user);
            model.addAttribute("flag",true);
            model.addAttribute("message","您还没有收货地址，请先添加地址");
            return "/user/center";
        }

        //开始进行库存验证
        // 根据用户ID查找购物车列表
        List<ShopCar> shopCarListReturn = shopCarService.findShopCarByUid(user.getUid());
        List<Good> goodListReturn = new ArrayList<Good>();
        for (ShopCar shopCar : shopCarListReturn) {
            Good good = new Good();
            // 根据购物车中的商品ID查找商品信息并添加到商品列表中
            goodListReturn.add(goodService.findGoodById(shopCar.getGoodId()));
        }

        // 将购物车列表和商品列表添加到模型中
        model.addAttribute("shopCarList", shopCarListReturn);
        model.addAttribute("goodList", goodListReturn);

        // 将收货地址列表和用户信息添加到模型中
        model.addAttribute("addressList", addressList);
        model.addAttribute("user", user);

        double money = 0;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(money));

        List<Good> goodList = new ArrayList<>();
        List<ShopCar> shopCarList = new ArrayList<>();

        // 遍历传入的商品ID数组
        for (int i = 0; i < goodId.length; i++) {
            // 根据商品ID查找商品信息
            Good good = goodService.findGoodById(goodId[i]);
            // 将商品添加到商品列表中
            goodList.add(good);
            // 根据用户ID和商品ID查找购物车信息
            ShopCar shopCar = shopCarService.findShopCarByUidAndGoodId(user.getUid(), goodId[i]);

            // 获取商品数量和购物车中的商品数量
            int goodNum = good.getGoodNum();

            // 如果购物车中的商品数量大于库存数量，则返回购物车页面并提示用户库存不足
            if (shopCarNum[i] > goodNum){
                model.addAttribute("message","您购买的"+good.getGoodName()+"库存不足，请重新修改数量后下单");
                model.addAttribute("flag", true);
                return "/user/shopCar";
            }

            shopCar.setGoodNum(shopCarNum[i]);
            shopCarService.updateShopCar(shopCar);

            // 将购物车添加到购物车列表中
            shopCarList.add(shopCar);

            // 计算总价
            BigDecimal bigDecimal1 = new BigDecimal(Double.toString(good.getGoodPrice()));
            bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(shopCarNum[i]));
            bigDecimal = bigDecimal.add(bigDecimal1);
        }

        //验证通过，返回商品列表和总价等信息
        // 将商品列表、购物车列表和总价添加到模型中
        model.addAttribute("goodList", goodList);
        model.addAttribute("shopCarList", shopCarList);
        model.addAttribute("money", bigDecimal.doubleValue());

        // 返回购买确认页面
        return "/user/buyCheck";
    }

    @PostMapping("/user/RealBuy")
    public String realBuy(Integer[] goodId, Integer getMethod,Integer addressId,Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Address address = addressService.findById(addressId);

        model.addAttribute("user", user);

        int aid = goodService.buyGood(user,getMethod,address,goodId);
            model.addAttribute("flag",true);
            model.addAttribute("message","购买成功");
            return listController.aListId(aid,session,model);

    }

    @PostMapping("/user/RealBuyMethod2")
    public String realBuy2(Integer[] goodId, Integer getMethod, Integer goodNum, Integer addressId,Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        Address address = addressService.findById(addressId);
        model.addAttribute("user", user);
        int aid = goodService.buyGoodMethod(user,getMethod,goodNum,address,goodId[0]);
        model.addAttribute("flag",true);
        model.addAttribute("message","购买成功");
        return listController.aListId(aid,session,model);
    }

    @RequestMapping("/user/deleteShopCar")
    public String deleteShopCar(Integer goodId,Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        shopCarService.deleteShopCarByUid(user.getUid(), goodId);
        return shopCar(model,session);
    }

    @PostMapping("/user/addShopCar")
    public String addShopCar(Integer goodId, Integer goodNum, Integer buyType, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Good good = goodService.findGoodById(goodId);
        GoodImage goodImage = goodImageService.findGoodImage(goodId);
        int flag = shopCarService.insertShopCar(user.getUid(), goodId,goodNum);
        model.addAttribute("goodImage", goodImage);
        model.addAttribute("good",good);
        model.addAttribute("flag",true);
        if (flag > 0){
            model.addAttribute("message","商品已添加到购物车");
        }else {
            model.addAttribute("message","商品添加到购物车失败");
        }
        return "/user/goodPages";
    }
}
