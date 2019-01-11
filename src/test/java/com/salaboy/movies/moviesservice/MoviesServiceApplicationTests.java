package com.salaboy.movies.moviesservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MoviesServiceApplicationTests {


    @Autowired
    private WebTestClient testClient;


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
        WebTestClient.ResponseSpec exchange = testClient.get().uri("/sidekicks").exchange();
        exchange.expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("Title").isEqualTo("Sidekicks")
                .jsonPath("Year").isEqualTo("1992");

        WebTestClient.ResponseSpec exchange2 = testClient.get().uri("/sidekicks?apiName=TheMovieDB").exchange();
        exchange.expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("results[0].title").isEqualTo("Sidekicks")
                .jsonPath("release_date").isEqualTo("1974-03-21");
    }

    @Test
    public void searchShouldFailOnWrongParams() {

    }


}

