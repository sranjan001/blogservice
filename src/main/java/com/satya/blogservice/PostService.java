package com.satya.blogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post[] getPosts() {

        List<Post> list = repository.findAll();

        if(list == null || list.size() == 0)
            return new Post[0];
        else
            return list.toArray(new Post[0]);
    }
}
