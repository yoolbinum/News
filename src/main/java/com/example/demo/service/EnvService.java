package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EnvService {
    @Autowired
    private Environment env;

    public String getApiKey(){
        return env.getProperty("news.apikey");
    }

    public String getEndpoint(){
        return env.getProperty("news.endpoint");
    }
}
