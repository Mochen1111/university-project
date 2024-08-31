package cn.edu.tyut.controller;

import cn.edu.tyut.model.*;
import cn.edu.tyut.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserCollectionService userCollectionService;

    // 首页
    @RequestMapping("/index.html")
    public String index(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize ,
                        Model model) {
        // 获取文章进行分页处理
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.getAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        List<Article> articleList = pageInfo.getList();
        model.addAttribute("ArticleList", articleList);
        // 获取标签
        List<Label> labels = labelService.getAllLabel();
        model.addAttribute("LabelList", labels);
        // 获取分页信息
        model.addAttribute("pageNum", pageInfo.getPages());
        return "/index";
    }

    // 文章详情页
    @RequestMapping("/article/articleId")
    public String article(Integer articleId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("flag", true);
            model.addAttribute("message", "请登录");
            return "/login";
        }
        // 获取文章
        Article article = articleService.getArticle(articleId);
        model.addAttribute("Article", article);
        // 获取作者
        Author author = authorService.findAuthorByArticleId(articleId);
        model.addAttribute("Author", author);
        // 获取标签
        List<Label> labels = labelService.getLabelByArticleId(articleId);
        model.addAttribute("LabelList", labels);
        // 获取评论
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        if (comments.size() > 19) {
            model.addAttribute("CommentList", comments.subList(0, 19));
        }else {
            model.addAttribute("CommentList", comments);
        }
        return "/articlePage";
    }

    // 文章标签查询
    @RequestMapping("/article/labelName")
    public String articleByLabel(String labelName, Model model) {
        PageHelper.startPage(1, 10);
        List<Article> articles = articleService.getArticleByLabel(labelName);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        model.addAttribute("ArticleList", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPages());

        List<Label> labels = labelService.getAllLabel();
        model.addAttribute("LabelList", labels);
        return "/index";
    }

    // 文章名称查询
    @PostMapping("/article/articleName")
    public String articleByTitle(String articleName, Model model) {
        if (articleName == null || articleName.trim().isEmpty()) {
            return index(1, 10, model);
        }
        // 获取文章
        PageHelper.startPage(1, 10);
        List<Article> articles = articleService.getArticleByTitle(articleName);
        if (articles.isEmpty()) {
            model.addAttribute("flag", true);
            model.addAttribute("message", "没有找到相关诗文");
            return index(1, 10, model);
        }
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        model.addAttribute("ArticleList", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPages());
        List<Label> labels = labelService.getAllLabel();
        model.addAttribute("LabelList", labels);
        return "/index";
    }

    // 添加收藏夹
    @RequestMapping("/article/addCollection")
    public String addCollection(Integer articleId,Model model,HttpSession session) {
        // 获取用户
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("flag", true);
            model.addAttribute("message", "请登录");
            return "/login";
        }
        // 添加收藏
        int flag = userCollectionService.addCollection(user.getUserId(), articleId);
        model.addAttribute("flag", true);
        if (flag > 0) {
            model.addAttribute("message", "收藏成功");
        }else if (flag < 0){
            model.addAttribute("message", "您已经收藏过了");
        }else {
            model.addAttribute("message", "收藏失败");
        }
        return article(articleId, model, session);
    }

    // 古诗资源下载
    @RequestMapping("/article/download")
    public void articleDownload(Integer articleId, HttpServletResponse response) throws IOException {
        // 获取文章
        Article article = articleService.getArticle(articleId);
        // 获取作者
        Author author = authorService.findAuthorByArticleId(articleId);
        // 获取标签
        List<Label> labels = labelService.getLabelByArticleId(articleId);
        String label = "";
        for (Label lab : labels) {
            label += lab.getLabelName() + ",";
        }
        // 文件名
        byte[] bytes = article.getArticleTitle().getBytes(StandardCharsets.UTF_8);
        String fileName = new String(bytes,0, bytes.length,StandardCharsets.ISO_8859_1);
        // 文件类型
        response.setHeader( "Content-Disposition","attachment; filename=" + fileName + ".txt");
        response.setContentType("text/plain;charset=utf-8");
        OutputStream outputStream = response.getOutputStream();
        // 文件内容
        String fileContent = "诗名：" + article.getArticleTitle() + "\n"
                + "诗人：" + author.getAuthorName() + "\n"
                + "标签：" + label + "\n"
                + "原文：" + "\n" + article.getArticleContent() + "\n" + "\n"
                + "译文：" + "\n" + article.getArticleTranslation();
        // 输出
        StreamUtils.copy(fileContent.getBytes(), outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
