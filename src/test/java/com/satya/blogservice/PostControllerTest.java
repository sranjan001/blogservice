package com.satya.blogservice;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PostControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @LocalServerPort
    private int port;


    @MockBean
    private PostService todoService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        RestAssured.port = port;
//        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }


    @Test
    public void when_get_all_todo_endpoint_called_then_return_all_todos() {

        Post todo1 = Post.builder().id(5L).title("first task").build();
        Post todo2 = Post.builder().id(6L).title("second task").build();
        Post todo3 = Post.builder().id(7L).title("third task").build();

        Post[] todos = new Post[]{todo1, todo2, todo3};

        Mockito.when(todoService.getPosts()).thenReturn(todos);

        Post[] actual = get("/posts").as(Post[].class);

        for(Post todo: actual)
            System.out.println(todo);

        assertEquals(todos, actual);

//        given().when().get("/todos")
//                .then()
//                .statusCode(HttpStatus.OK.value())
//                //.log().all()
//                //..contentType(ContentType.JSON)
//               // .body(arrayWithSize(3))
//        .as

    }

    @Test
    public void when_get_all_todo_endpoint_called_then_return_all_todos_with_tasks() {

        Post todo1 = Post.builder().id(5L).title("first task").build();
        Post todo2 = Post.builder().id(6L).title("second task").build();
        Post todo3 = Post.builder().id(7L).title("third task").build();

     /*   Comment task1 = Comment.build().builder().taskType(TaskType.SPL).details("task1").build();
        Task task2 = Task.builder().taskType(TaskType.SPL).details("task1").build();
        Task task3 = Task.builder().taskType(TaskType.SPL).details("task1").build();

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        todo1.setTasks(tasks);

        Todo[] todos = new Todo[]{todo1, todo2, todo3};

        Mockito.when(todoService.getTodos()).thenReturn(todos);

        Todo[] actual = get("/todos").as(Todo[].class);

        for(Todo todo: actual)
            System.out.println(todo);

        assertEquals(todos, actual);*/

//        given().when().get("/todos")
//                .then()
//                .statusCode(HttpStatus.OK.value())
//                //.log().all()
//                //..contentType(ContentType.JSON)
//               // .body(arrayWithSize(3))
//        .as

    }

    @Test
    public void testHello() {
        given().when().get("/")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
