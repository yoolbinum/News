package com.example.demo.controller;

import com.example.demo.model.web.Article;
import com.example.demo.model.web.News;
import com.example.demo.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class ArticleController {

    @Autowired
    private EnvService envService;

    final private String articleDir = "model/article/";

    @RequestMapping("/top")
    public String showTopNewsStories(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject(envService.getEndpoint() + "&apiKey=" + envService.getApiKey(), News.class);
        List<Article> articles = news.getArticles();
        for(int i = 0; i < articles.size(); i++){
            articles.get(i).setId(i);
        }
        model.addAttribute("articles", articles);
        return articleDir + "list";
    }

    @RequestMapping("/top/{id}")
    public String topNewsStoriesDetail(@PathVariable("id") long id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject(envService.getEndpoint() + "&apiKey=" + envService.getApiKey(), News.class);
        Article article =  news.getArticles().get((int)id);
        model.addAttribute("article", article);
        model.addAttribute("source", article.getSource());
        return articleDir + "detail";
    }


}
