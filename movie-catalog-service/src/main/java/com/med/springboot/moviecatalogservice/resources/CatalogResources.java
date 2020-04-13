package com.med.springboot.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.med.springboot.moviecatalogservice.models.CatalogItem;
import com.med.springboot.moviecatalogservice.models.MovieInfo;
import com.med.springboot.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResources {

	@RequestMapping("/{userID}")
	public List<CatalogItem> getCatalog(String userId) {
		RestTemplate restTemplate = new RestTemplate();
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 5));
		return ratings.stream().map(rating -> {
			MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(),MovieInfo.class);
			return new CatalogItem(movieInfo.getName(), "test transf desc", rating.getRating());
		}).collect(Collectors.toList());
		
	
		// return Collections.singletonList(new CatalogItem("transformers","test
		// desc",4));

	}
	/*
	Alternative WebClient way
	Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
	.retrieve().bodyToMono(Movie.class).block();
	*/
}
