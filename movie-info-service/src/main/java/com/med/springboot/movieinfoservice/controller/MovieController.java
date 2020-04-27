package com.med.springboot.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.med.springboot.movieinfoservice.models.MovieInfo;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	
	@Value("${api.key}")
	private String apiKey;
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieInfo movieInfo = restTemplate.getForObject("https://api.themoviedb.org/3/movie/100?api_key=7980d95eefa89b131192420cff5c6719",MovieInfo.class);

		return new Movie(movieId, movieInfo.getTitle(),movieInfo.getOverview());
		
	}

}
