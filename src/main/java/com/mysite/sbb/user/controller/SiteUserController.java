package com.mysite.sbb.user.controller;

import com.mysite.sbb.user.UserCreateForm;
import com.mysite.sbb.user.service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping("/signup")
    public String signup(UserCreateForm user){
        return "/signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/signup_form";
        }
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "/signup_form";
        }

        siteUserService.create(userCreateForm.getUserName(),
                userCreateForm.getEmail(), userCreateForm.getPassword1());

        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request){
        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referrer);
        return "/login_form";
    }
}
