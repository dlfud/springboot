package com.mysite.sbb.article.controller;

import com.mysite.sbb.article.dao.ArticleRepository;
import com.mysite.sbb.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(){
        return articleRepository.findAll();
    }

//    @RequestMapping("/detail")
//    @ResponseBody
//    public Article showOne(){
//        return articleRepository.findById(1L).get();
//    }

    @RequestMapping("/detail")
    @ResponseBody
    public Article showNOne(@RequestParam long id, String name) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }
}
