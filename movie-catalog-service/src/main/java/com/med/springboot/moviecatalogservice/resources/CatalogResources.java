package com.med.springboot.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.med.springboot.moviecatalogservice.models.CatalogItem;
import com.med.springboot.moviecatalogservice.models.MovieInfo;

@RestController
@RequestMapping("/catalog")
public class CatalogResources {
	

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	List<CatalogItem> getCatalog(String userId){
		
		MovieInfo movieInfo = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie/100",MovieInfo.class);
		return Collections.singletonList(new CatalogItem(movieInfo.getName(),"Transformers description",5));
	}
	
	
	/*
	Alternative WebClient way
	Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movie/1234")
	.retrieve().bodyToMono(Movie.class).block();
	*/

}
