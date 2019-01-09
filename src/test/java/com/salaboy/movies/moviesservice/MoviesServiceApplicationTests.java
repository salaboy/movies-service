package com.salaboy.movies.moviesservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesServiceApplicationTests {

    private WebTestClient testClient = WebTestClient
            .bindToServer()
            .baseUrl("http://localhost:8080")
            .build();
    @Test
    public void contextLoads() {
    }

    @Test
    public void searchShouldReturnMovie() {
        WebTestClient.ResponseSpec exchange = testClient.get().uri("/sidekicks").exchange();
        exchange.expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("Title").isEqualTo("Sidekicks")
                .jsonPath("Year").isEqualTo("1992");


    }

    @Test
    public void searchShouldAllowSwitchingAPIs() {

    }

    @Test
    public void searchShouldFailOnWrongParams() {

    }


}

