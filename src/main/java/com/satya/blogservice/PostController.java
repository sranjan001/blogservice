package com.satya.blogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts", produces = "application/json")
    public Post[] getAllTodos() {

        return postService.getPosts();
    }

    @GetMapping
    public String hello() {
        return "hello";
    }

}
