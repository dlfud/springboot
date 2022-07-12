package com.mysite.sbb.article.controller;

import com.mysite.sbb.article.dao.ArticleRepository;
import com.mysite.sbb.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
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

    @RequestMapping("/modify")
        @ResponseBody
        public Article Modify(long id, String title, String body){
            Article article = articleRepository.findById(id).get();// 조건에 맞는 데이터 가져오기
            if(title != null){
                article.setTitle(title);// 불러온 데이터 수정
            }
            if(body != null){
                article.setBody(body);
            }
            article.setUpdateDate(LocalDateTime.now());
            articleRepository.save(article);//수정된 데이터 db에 저장

        return article;
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public String doDelete(long id){
        if(!articleRepository.existsById(id)){
            return "%d번 게시물은 이미 삭제되었거나 없는 게시물입니다.".formatted(id);
        }
        articleRepository.deleteById(id);
        return "%d번 게시물이 삭제되었습니다.".formatted(id);
    }

    @RequestMapping("/findByTitle")
    @ResponseBody
    public Object findByTitle(String title){
        List<Article> articles = articleRepository.findByTitle(title);
        System.out.println(articles);
        if(articles != null){
            return "해당 제목의 게시물은 존재하지 않습니다.";
        }
        return articles;
    }
}
