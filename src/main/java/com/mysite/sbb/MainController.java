package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //어노테이션
public class MainController {
    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){

        return "index";
    }

    @RequestMapping("/")
    public String Root(){
        return "redirect:/question/list";
    }

}
