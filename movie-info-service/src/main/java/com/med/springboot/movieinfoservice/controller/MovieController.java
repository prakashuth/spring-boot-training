package com.med.springboot.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.med.springboot.movieinfoservice.models.MovieInfo;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	RestTemplate restTemplate;
	
	private WebClient.Builder webClient = WebClient.builder();


	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		MovieInfo movieInfo = WebClient.builder().build().get().uri("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey)
				.retrieve().bodyToMono(MovieInfo.class).block();
		
		
		/*
		 * MovieInfo movieInfo = restTemplate
		 * .getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +
		 * apiKey, MovieInfo.class);
		 */

		return new Movie(movieId, movieInfo.getTitle(), movieInfo.getOverview());

	}

	
	
}
