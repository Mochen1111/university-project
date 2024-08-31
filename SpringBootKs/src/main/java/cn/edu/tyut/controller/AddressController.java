package cn.edu.tyut.controller;

import cn.edu.tyut.domain.Address;
import cn.edu.tyut.domain.User;
import cn.edu.tyut.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/user/address")
    public String addAddress(String address, HttpSession session, Model model) {
        // 从会话中获取当前用户信息
        User user = (User) session.getAttribute("user");
        // 如果用户不存在，则重定向到登录页面
        if (user == null) {
            return "/login";
        }

        // 创建一个新的地址对象
        Address address1 = new Address();
        // 设置地址对象的地址属性
        address1.setAddress(address);
        // 设置地址对象的用户ID属性
        address1.setUid(user.getUid());
        // 调用地址服务插入地址对象，并返回插入后的地址对象
        address1 = addressService.insert(address1);
        // 调用地址服务根据用户ID查找地址列表
        List<Address> addressList = addressService.findByUserId(user.getUid());

        model.addAttribute("flag",true);
        // 向模型中添加属性"addressList"，表示地址列表
        model.addAttribute("addressList", addressList);
        // 向模型中添加属性"user"，表示当前用户
        model.addAttribute("user", user);
        // 如果地址对象不为空，则添加成功消息到模型
        if (address1 != null){
            model.addAttribute("message","地址添加成功");
        }else {
            // 否则添加失败消息到模型
            model.addAttribute("message","地址添加失败");
        }
        // 返回用户中心页面的视图名称
        return "/user/center";
    }

    @PostMapping("/user/updateAddressMessage")
    public String updateAddressMessage(Integer addressId, String address, HttpSession session, Model model) {
        // 从会话中获取当前用户
        User user = (User) session.getAttribute("user");
        // 如果用户不存在，则重定向到登录页面
        if (user == null) {
            return "/login";
        }

        // 根据地址ID查询地址对象
        Address addressDomain = addressService.findById(addressId);
        // 修改地址对象的地址属性
        addressDomain.setAddress(address);
        // 更新地址对象到数据库，并获取更新结果
        int flag = addressService.update(addressDomain);
        // 根据用户ID查询地址列表
        List<Address> addressList = addressService.findByUserId(user.getUid());

        model.addAttribute("flag",true);
        // 根据更新结果判断操作是否成功，并设置相应的消息到模型中
        if (flag == 0){
            model.addAttribute("message", "地址修改失败");
        }else {
            model.addAttribute("message","地址修改成功");
        }
        // 向模型中添加属性"addressList"，表示地址列表
        model.addAttribute("addressList", addressList);
        // 向模型中添加属性"user"，表示当前用户
        model.addAttribute("user", user);

        // 返回用户中心页面
        return "/user/center";
    }

    @RequestMapping("/user/deleteAddress")
    public String deleteAddress(Integer addressId, HttpSession session, Model model) {
        // 从会话中获取当前用户
        User user = (User) session.getAttribute("user");
        // 如果用户不存在，则重定向到登录页面
        if (user == null) {
            return "/login";
        }

        // 调用地址服务删除指定地址
        int flag = addressService.delete(addressId);

        // 根据用户ID查询地址列表
        List<Address> addressList = addressService.findByUserId(user.getUid());

        // 将地址列表添加到模型中
        model.addAttribute("addressList", addressList);
        // 将当前用户添加到模型中
        model.addAttribute("user", user);
        model.addAttribute("flag",true);

        // 判断删除操作是否成功
        if (flag > 0){
            // 如果删除成功，则将成功消息添加到模型中
            model.addAttribute("message","地址删除成功");
        }else {
            // 如果删除失败，则将失败消息添加到模型中
            model.addAttribute("message","地址删除失败");
        }
        // 返回用户中心页面
        return "/user/center";
    }
}
