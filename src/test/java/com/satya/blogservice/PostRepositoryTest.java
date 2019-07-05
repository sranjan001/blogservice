package com.satya.blogservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PostRepository todoRepository;

    private Post[] todos;

    @Before
    public void setup() {
        Post todo1 = Post.builder().title("First task").build();
        Post todo2 = Post.builder().title("First task").build();
        Post todo3 = Post.builder().title("First task").build();
        Post todo4 = Post.builder().title("First task").build();
        Post todo5 = Post.builder().title("First task").build();

        todos = new Post[]{todo1, todo2, todo3, todo4, todo5};

        testEntityManager.persist(todo1);
        testEntityManager.persist(todo2);
        testEntityManager.persist(todo3);
        testEntityManager.persist(todo4);
        testEntityManager.persist(todo5);
    }

    @Test
    public void when_get_all_then_return_all_todos() {
        List<Post> actualTodos = todoRepository.findAll();

//        Assert.assertEquals(5, actualTodos.size());
        Assert.assertEquals(todos[todos.length - 1].getTitle(), actualTodos.get(4).getTitle());
    }
}
