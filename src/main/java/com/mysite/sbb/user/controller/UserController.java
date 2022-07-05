package com.mysite.sbb.user.controller;

import com.mysite.sbb.article.dao.ArticleRepository;
import com.mysite.sbb.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ArticleRepository userRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(){
        return userRepository.findAll();
    }
}
