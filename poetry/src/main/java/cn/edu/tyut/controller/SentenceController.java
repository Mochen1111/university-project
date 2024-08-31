package cn.edu.tyut.controller;

import cn.edu.tyut.model.Sentence;
import cn.edu.tyut.model.User;
import cn.edu.tyut.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SentenceController {
    @Autowired
    private SentenceService sentenceService;

    @RequestMapping("/sentence")
    public String sentence(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/login";
        }
        List<Sentence> sentences = sentenceService.getSentences();
        model.addAttribute("Sentences", sentences);
        return "/sentence";
    }
}
