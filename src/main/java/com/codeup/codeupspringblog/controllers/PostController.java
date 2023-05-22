package com.codeup.codeupspringblog.Controller;

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
    public PostController(PostRepository postDao) { this.postDao = postDao;}

    @GetMapping("posts/index")
    public String indexPage(Model model) {
        List<Post> posts = new ArrayList<>();

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

    @GetMapping("/{id}")
    public String idPage(@PathVariable int id, Model model) {
        Post post = new Post();
        post.setTitle("Show post");
        post.setBody("This is the show post.");

        model.addAttribute("post", post);

        return "posts/show";
    }


    @GetMapping("/create")
    @ResponseBody
    public String createPost() {
        return "posts/create";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createForm() {
        return "This is where you create a new post";
    }

}
