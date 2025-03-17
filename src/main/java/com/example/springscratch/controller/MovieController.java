package com.example.springscratch.controller;

import com.example.springscratch.model.dto.MovieDTO;
import com.example.springscratch.model.dto.MovieInfoDTO;
import com.example.springscratch.service.GeminiService;
import com.example.springscratch.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {
    final MovieService movieService;
    final GeminiService geminiService;

    public MovieController(MovieService movieService, GeminiService geminiService) {
        this.movieService = movieService;
        this.geminiService = geminiService;
    }


    @GetMapping("/")
    public String index(Model model) throws Exception {
//        List<MovieDTO> movies = movieService.getMovies();
        List<MovieInfoDTO> movies = movieService.getMovieInfos();
        model.addAttribute("movies", movies);
        String prompt = "%s, 앞에서 말하는  상황, 분위기와 어울리는 영화를 추천하고 그 이유를 작성해줘. no markdown, just plain-text, in korean language".formatted(movies.toString());
        String recommendation = geminiService.callGemini(prompt);
        model.addAttribute("recommendation", recommendation);
        return "index";
    }
}
