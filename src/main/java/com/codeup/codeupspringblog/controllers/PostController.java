package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("posts/index")
    public String indexPage(Model model) {
        List<Post> posts = postDao.findAll();

        Post post1 = new Post();
        post1.setTitle("First Post");
        post1.setBody("This is the first post.");

        Post post2 = new Post();
        post2.setTitle("Second Post");
        post2.setBody("This is the second post.");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }


    @GetMapping("posts/create")
    public String createPost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam Long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String getId(@PathVariable long id, Model model) {
        Post post = postDao.getReferenceById(id);
        System.out.println(post.getUser().getEmail());
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/posts/{id}")
    public String delete(@RequestParam long deleteId) {

        postDao.deleteById(deleteId);

        return "redirect:/posts";
    }


}
