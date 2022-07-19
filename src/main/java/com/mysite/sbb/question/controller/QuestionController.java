package com.mysite.sbb.question.controller;

import com.mysite.sbb.question.dao.QuestionRepository;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/list")
    public String showList(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "/user/list";
    }

    @RequestMapping("/detail/{id}")
    public String showQuestion(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "/user/question_detail";
    }



}
