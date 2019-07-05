package com.satya.blogservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @InjectMocks
    @Autowired
    private PostService service;

    @Mock
    private PostRepository repository;

    @Test
    public void when_request_for_get_all_todos_then_return_todos() {
        Post todo1 = Post.builder().id(1L).title("first task").build();
        Post todo2 = Post.builder().id(2L).title("second task").build();
        Post todo3 = Post.builder().id(3L).title("third task").build();

        List<Post> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);

        Mockito.when(repository.findAll()).thenReturn(todos);
        Post[] actualTodos = service.getPosts();

        assertEquals(todos.toArray(new Post[0]), actualTodos);
    }

    public void when_save_todo_with_tasks_then_return_todo_with_tasks() {

        Post todo1 = Post.builder().id(1L).title("first post").build();
        Post todo2 = Post.builder().id(2L).title("second post").build();
        Post todo3 = Post.builder().id(3L).title("third post").build();

        Comment task1 = Comment.builder().review("comment1").build();
        Comment task2 = Comment.builder().review("comment2").build();
        Comment task3 = Comment.builder().review("comment3").build();

        List<Post> tasks = new ArrayList<>();
        tasks.add(todo1);
        tasks.add(todo2);
        tasks.add(todo3);

        repository.save(todo1);
    }
}
