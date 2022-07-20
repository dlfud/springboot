package com.mysite.sbb.question.controller;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.question.QuestionForm;
import com.mysite.sbb.question.dao.QuestionRepository;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return "/question_list";
    }

    @RequestMapping("/detail/{id}")
    public String showQuestion(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "/question_detail";
    }


    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){ // 화면으로 이동
        return "/question_form";
    }

    @PostMapping("/create") // 데이터 보내서 등록
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){ // 검증에 실패한다면
            return "/question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
