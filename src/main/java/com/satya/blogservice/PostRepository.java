package com.satya.blogservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("todoRepository")
public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findAll();
}
