package com.med.springboot.movieinfoservice.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.med.springboot.movieinfoservice.models.MovieInfo;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	@RequestMapping("/{movieId}")
	public MovieInfo getMovieInfo(String movieId) {
		return new MovieInfo("transformers","1234");
		
		
		
	}
	

}
