package com.example.springscratch.controller;

import com.example.springscratch.model.dto.MovieDTO;
import com.example.springscratch.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MovieController {
    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/")
    public String index() throws Exception {
        MovieDTO movie = movieService.getMovie();
        return "index";
    }
}
