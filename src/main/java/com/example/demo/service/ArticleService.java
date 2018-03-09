package com.example.demo.service;

import com.example.demo.model.web.Article;
import com.example.demo.model.web.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private EnvService envService;

    RestTemplate restTemplate = new RestTemplate();

    public List<Article> topNews() {
        StringBuilder sb = new StringBuilder();
        sb.append(envService.getEndpoint()).append("&apiKey=").append(envService.getApiKey());
        News news = restTemplate.getForObject(sb.toString(), News.class);
        List<Article> articles = news.getArticles();
        for (int i = 0; i < articles.size(); i++) {
            articles.get(i).setId(i);
        }
        return articles;
    }

    public List<Article> categoryNews(String category) {
        StringBuilder sb = new StringBuilder();
        sb.append(envService.getEndpoint()).append("&category=").append(category).append("&pageSize=5").append("&apiKey=").append(envService.getApiKey());
        News news = restTemplate.getForObject(sb.toString(), News.class);
        List<Article> articles = news.getArticles();
        for (int i = 0; i < articles.size(); i++) {
            articles.get(i).setId(i);
        }
        return articles;
    }
}
