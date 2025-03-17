package com.example.springscratch.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieInfoResponse (MovieInfoResult movieInfoResult) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record BoxOfficeResult(
            String showTm,
            List<Nation> nations,
            List<Genre> genres,
            List<Dir> directors,
            List<Actor> actors
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Nation() {   }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Genre() {}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Director() {}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Actor() {}
}
