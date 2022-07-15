package com.mysite.sbb.Answer.controller;

import com.mysite.sbb.Answer.dao.AnswerRepository;
import com.mysite.sbb.Answer.domain.Answer;
import com.mysite.sbb.Answer.service.AnswerService;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    private final QuestionService questionService;

    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
