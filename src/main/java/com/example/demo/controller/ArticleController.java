package com.example.demo.controller;

import com.example.demo.model.web.Article;
import com.example.demo.model.web.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
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
    private Environment env;



    @ResponseBody
    @RequestMapping("/top")
    public String showTopNewsStories(){
        final String apiKey = env.getProperty("news.apikey");
        String url = "https://newsapi.org/v2/top-headlines?country=us&category=general";
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject(url + "&apiKey=" + apiKey, News.class);
        List<Article> articles = news.getArticles();
        return news.toString();
    }

}
