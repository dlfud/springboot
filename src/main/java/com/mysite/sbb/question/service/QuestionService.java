package com.mysite.sbb.question.service;

import com.mysite.sbb.question.dao.QuestionRepository;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.util.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> opQuestion = this.questionRepository.findById(id);
        if(opQuestion.isPresent()){
            Question question = opQuestion.get();
            //조회수 늘리기
            question.setViewCount(question.getViewCount() + 1);
            //바뀐 db저장
            this.questionRepository.save(question);
            return question;
        }
        else{
            throw new DataNotFoundException("question not Found");
        }
    }
}
