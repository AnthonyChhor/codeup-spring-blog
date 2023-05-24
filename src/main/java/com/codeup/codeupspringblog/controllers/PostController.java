package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private  UserRepository userDao;


    private  PostRepository postDao;

    public PostController(UserRepository userDao, PostRepository postDao) {
        this.userDao = userDao;
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

    public String postCreate(@ModelAttribute("post") Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String body = "your created a post '" + post.getTitle() + "' and the description '" + post.getBody() + "'.";
        post.setUser(user);
        postDao.save(post);
        EmailService emailService = null;
        emailService.prepareAndSend(post, "Post Creation", body);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam Long id) {
        postDao.deleteById(id);
        return "redirect:/posts/index";
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

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).orElse(null);
        if (post == null) {
            return "error";
        }
        model.addAttribute("post", post);
        return "posts/edit";
    }

}



