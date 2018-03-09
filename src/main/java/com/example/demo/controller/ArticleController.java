package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.web.Article;
import com.example.demo.model.web.News;
import com.example.demo.service.ArticleService;
import com.example.demo.service.EnvService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/news")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    final private String articleDir = "model/article/";

    @RequestMapping("/top")
    public String showTopNewsStories(Model model) {
        model.addAttribute("articles", articleService.topNews());
        model.addAttribute("funName", "topNews");
        return articleDir + "list";
    }

    @RequestMapping("/top/{id}")
    public String topNewsStoriesDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.topNews().get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "topNews");
        return articleDir + "detail";
    }

    @RequestMapping("/category")
    public String showCategoryNews(Model model, Authentication auth) {
        User user = userService.findByUsername(auth.getName());

        List<Article> business = new ArrayList<>();
        List<Article> entertainment = new ArrayList<>();
        List<Article> general = new ArrayList<>();
        List<Article> health = new ArrayList<>();
        List<Article> science = new ArrayList<>();
        List<Article> sports = new ArrayList<>();
        List<Article> technology = new ArrayList<>();

        if (user.containCategory("business"))
            business = articleService.categoryNews("business");
        if (user.containCategory("entertainment"))
            entertainment = articleService.categoryNews("entertainment");
        if (user.containCategory("general"))
            general = articleService.categoryNews("general");
        if (user.containCategory("health"))
            health = articleService.categoryNews("health");
        if (user.containCategory("science"))
            science = articleService.categoryNews("science");
        if (user.containCategory("sports"))
            sports = articleService.categoryNews("sports");
        if (user.containCategory("technology"))
            technology = articleService.categoryNews("technology");

        model.addAttribute("business", business);
        model.addAttribute("entertainment", entertainment);
        model.addAttribute("general", general);
        model.addAttribute("health", health);
        model.addAttribute("science", science);
        model.addAttribute("sports", sports);
        model.addAttribute("technology", technology);

        return articleDir + "category";
    }

    @RequestMapping("/category/business/{id}")
    public String businessNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("business").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }

    @RequestMapping("/category/entertainment/{id}")
    public String entertainmentNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("entertainment").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }

    @RequestMapping("/category/general /{id}")
    public String generalNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("general").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }

    @RequestMapping("/category/health/{id}")
    public String healthNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("health").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }

    @RequestMapping("/category/science/{id}")
    public String scienceNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("science").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }

    @RequestMapping("/category/sports/{id}")
    public String sportsNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("sports").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }

    @RequestMapping("/category/technology/{id}")
    public String technologyNewsDetail(@PathVariable("id") long id, Model model) {
        Article article = articleService.categoryNews("technology").get((int) id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        model.addAttribute("funName", "category");
        return articleDir + "detail";
    }


}
