package com.example.springscratch.model.repository;

import com.example.springscratch.model.dto.MovieDTO;
import com.example.springscratch.model.dto.MovieParam;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class MovieRepository implements APIClientRepository {
    final String url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

    public MovieDTO getMovie(MovieParam param) throws Exception {
        final String key = dotenv.get("MOVIE_KEY");
        HttpRequest request = HttpRequest.newBuilder()
                // targetDt : yyyymmdd
                .uri(URI.create("%s?key=%s&targetDt=%s".formatted(url, key, param.targetDate())))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
//            return objectMapper.readValue(response.body(), MovieDTO.class);
            System.out.println(response.body());
        }
        return new MovieDTO();
    }
}
