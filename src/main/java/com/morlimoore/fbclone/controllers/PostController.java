package com.morlimoore.fbclone.controllers;

import com.morlimoore.fbclone.entities.Post;
import com.morlimoore.fbclone.entities.User;
import com.morlimoore.fbclone.services.PostService;
import com.morlimoore.fbclone.services.UserService;
import com.morlimoore.fbclone.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * This class, serving as a spring controller, handles all that has to do with user posts.
 * Functions includes reading all the existing posts in the DB, adding a post to the DB,
 * liking a post.
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("listOfPosts", postService.getAllPosts());
        model.addAttribute("users", userService.getAllUsers());
        return "dashboard";
    }

    @PostMapping("/addPost")
    public String addPost(@Valid Post post, @PathVariable("id") long id, Model model) {

        post.setLikes(0);
        post.setCreatedAt(DateUtil.getCurrentDate());
        postService.addPost(post);
        return "redirect:/dashboard";
    }

//    @PostMapping("/likePost")
//    public String likeUserPost(@Valid Post post) {
//        System.out.println("postID: " + post.getPostID());
//        System.out.println("Helllooooooooooooo");
////        System.out.println("userID: " + post.getUser().getUserID());
////        postService.likeUserPost(post.getPostID(), post.getUser().getUserID());
//        return "redirect:/dashboard";
//    }

}
