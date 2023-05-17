package com.codeup.codeupspringblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")

public class PostController {
    @GetMapping
    @ResponseBody
    public String indexPage() {
        return "This is where you view the posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String idPage(@PathVariable int id) {
        return ("This is where you view the individual post " + id + ".");
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost() {
        return "This is where you view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createForm() {
        return "This is where you create a new post";
    }

}
