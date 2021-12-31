package com.example.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //메인 페이지
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "page/index";
    }
}
