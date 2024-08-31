package cn.edu.tyut.controller;

import cn.edu.tyut.model.Sentence;
import cn.edu.tyut.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminSentenceController {
    @Autowired
    private SentenceService sentenceService;

    @RequestMapping("/adminSentence")
    public String adminSentence(Model model) {
        List<Sentence> sentences = sentenceService.getSentences();
        model.addAttribute("Sentences", sentences);
        return "/adminSentence";
    }

    @RequestMapping("/adminAddSentence")
    public String adminAddSentence(String sentence, Model model) {
        Sentence sentence1 = new Sentence(sentence);
        int flag = sentenceService.insertSentence(sentence1);
        model.addAttribute("flag", true);
        if (flag > 0) {
            model.addAttribute("message", "添加成功");
        }else {
            model.addAttribute("message", "添加失败");
        }
        return adminSentence(model);
    }

    @RequestMapping("/adminDeleteSentence")
    public String adminDeleteSentence(Integer sentenceId, Model model) {
        System.out.println(sentenceId);
        int flag = sentenceService.deleteSentence(sentenceId);
        model.addAttribute("flag", true);
        if (flag > 0) {
            model.addAttribute("message", "删除成功");
        }else {
            model.addAttribute("message", "删除失败");
        }
        return adminSentence(model);
    }
}

