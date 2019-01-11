package com.salaboy.movies.moviesservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MoviesServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MoviesServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }


}

