package cn.edu.tyut.controller;

import cn.edu.tyut.model.*;
import cn.edu.tyut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminLabelController {
    @Autowired
    private LabelService labelService;

    // 查询标签
    @RequestMapping("/admin/label")
    public String label(Model model){
        List<Label> labels = labelService.getAllLabel();

        model.addAttribute("labels", labels);
        return "/adminLabel";
    }

    // 删除标签
    @PostMapping("/adminLabelDelete")
    public String labelDelete(Integer labelId, Model model){
        int flag = labelService.deleteLabel(labelId);
        model.addAttribute("flag", true);
        if(flag == 1){
            model.addAttribute("message", "删除成功");
        }else {
            model.addAttribute("message", "删除失败");
        }
        return label(model);
    }

    // 添加标签
    @PostMapping("/adminAddLabel")
    public String addLabel(String labelName, Model model){
        int flag = labelService.addLabel(labelName);
        model.addAttribute("flag", true);
        if(flag == 0){
            model.addAttribute("message", "添加失败");
        }else{
            model.addAttribute("message", "添加成功");
        }
        return label(model);
    }
}
