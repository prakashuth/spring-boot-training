package com.med.springboot.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.med.springboot.moviecatalogservice.models.CatalogItem;
import com.med.springboot.moviecatalogservice.models.MovieInfo;
import com.med.springboot.moviecatalogservice.repository.CatalogRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class CatalogResources {
	

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CatalogRepository catalogRepository;
	
	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
		List<CatalogItem> getCatalog(String userId){
		MovieInfo movieInfo = getMovieInfo();
		List<CatalogItem> catalogs = new ArrayList<CatalogItem>();
		CatalogItem catalog = new CatalogItem();
		catalog.setName(movieInfo.getName());
		catalog.setDesc("Transformers description");
		catalog.setRating(5);
		catalog.setId(123);
		catalogs.add(catalog);
		return catalogs;
	}


	private MovieInfo getMovieInfo() {
		MovieInfo movieInfo = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie/100",MovieInfo.class);
		return movieInfo;
	}
	
	
	List<CatalogItem> getFallbackCatalog(String userId){
		List<CatalogItem> catalogs = new ArrayList<CatalogItem>();
		catalogRepository.findAll().forEach(catalog -> catalogs.add(catalog));
		//Collections.singletonList(new CatalogItem(123,"falback name","falback Transformers description",5));
		return catalogs;
	}
	
	/*
	Alternative WebClient way
	Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movie/1234")
	.retrieve().bodyToMono(Movie.class).block();
	*/

}
