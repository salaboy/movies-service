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
    private OMBDConfigurationProperties ombdConfigurationProperties;

    private WebClient OMDBclient = WebClient.create("http://www.omdbapi.com/");

    @Autowired
    private TheMovieBDConfigurationProperties theMovieBDConfigurationProperties;

    private WebClient theMovieDBclient = WebClient.create("https://api.themoviedb.org/3");

    @GetMapping("/{movieTitle}")
    public Mono<String> searchMovie(@PathVariable String movieTitle, @RequestParam(required = false) String apiName) {
        if ("TheMovieDB".equals(apiName)) {
            return theMovieDBclient.get()
                    .uri("/search/movie?api_key=" + theMovieBDConfigurationProperties.getKey() + "&query=" + movieTitle )
                    .retrieve()
                    .bodyToMono(String.class);
        } else { // By Default use OMDB
            return OMDBclient.get()
                    .uri("?apikey=" + ombdConfigurationProperties.getKey() + "&t=" + movieTitle)
                    .retrieve()
                    .bodyToMono(String.class);
        }
    }
}
