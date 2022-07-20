package com.mysite.sbb.answer.controller;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.answer.service.AnswerService;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @RequestMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question = this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()){ // 검증 실패
            model.addAttribute("question", question);
            return "/question_detail";
        }
        //model.addAttribute가 생략되어 있는거임
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }

    @PostMapping("/like/{questionId}/{answerId}")
    public String toggleLike(@PathVariable("questionId") Integer questionId, @PathVariable("answerId") Integer answerId){
        System.out.println("questionId" + questionId);
        System.out.println("answerId" + answerId);
        this.answerService.setLike(answerId);
        return String.format("redirect:/question/detail/%s", questionId);
    }


}
