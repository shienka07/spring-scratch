package com.example.springscratch.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieResponse(BoxOfficeResult boxOfficeResult) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record BoxOfficeResult(List<DailyBoxOffice> dailyBoxOfficeList) {}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DailyBoxOffice(String rank, String movieCd, String movieNm, String openDt, String audiAcc) {}
}
