package com.example.springscratch.service;

import com.example.springscratch.model.dto.MovieDTO;
import com.example.springscratch.model.dto.MovieInfoDTO;
import com.example.springscratch.model.dto.MovieParam;
import com.example.springscratch.model.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MovieService {
    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getMovies() throws Exception {
        // yyyymmdd
        LocalDate nowDate = LocalDate.now();
        nowDate = nowDate.minusDays(1);
        String nowDateStr = nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        MovieParam param = new MovieParam(nowDateStr);
        return movieRepository.getMovies(param);
    }

    public List<MovieInfoDTO> getMovieInfos() throws Exception {
        return null;
    }
}