package com.codeup.codeupspringblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
    @GetMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return "This is the landing page!";
    }
}
