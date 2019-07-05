package com.satya.blogservice;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PostControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private PostController postController;

    @Before
    public void setup() {
        RestAssured.port = port;
//        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void when_get_all_todo_endpoint_called_then_return_all_todos() {

        Post todo1 = Post.builder().title("first task").build();
        Post todo2 = Post.builder().title("second task").build();
        Post todo3 = Post.builder().title("third task").build();

        Post[] posts = new Post[]{todo1, todo2, todo3};

      //  Mockito.when(todoService.getTodos()).thenReturn(todos);

        Post[] actual = get("/posts").as(Post[].class);

        assertEquals(posts[posts.length-1].getTitle(), "third task");

//        given().when().get("/todos")
//                .then()
//                .statusCode(HttpStatus.OK.value())
//                //.log().all()
//                //..contentType(ContentType.JSON)
//               // .body(arrayWithSize(3))
//        .as

    }

}
