package com.salaboy.movies.moviesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class MovieServiceController {

    @Autowired
    private OMBDConfigurationProperties config;

    private WebClient OMDBclient = WebClient.create("http://www.omdbapi.com/");


    @GetMapping("/{movieTitle}")
    public Mono<String> searchMovie(@PathVariable String movieTitle, @RequestParam(required = false) String apiName) {
        if ("TheMovieDB".equals(apiName)) {
            return null;
        } else { // By Default use OMDB
            WebClient.ResponseSpec responseSpec = OMDBclient.get().uri("?apikey=" + config.getKey() + "&t=" + movieTitle).retrieve();
            return responseSpec.bodyToMono(String.class);
        }
    }
}
