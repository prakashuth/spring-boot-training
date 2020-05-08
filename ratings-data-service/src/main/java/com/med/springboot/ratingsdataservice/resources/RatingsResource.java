package com.med.springboot.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.med.springboot.ratingsdataservice.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(String movieId) {
		return new Rating(movieId,4);
	}
}
