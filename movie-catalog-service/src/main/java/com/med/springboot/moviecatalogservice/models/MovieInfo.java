package com.med.springboot.moviecatalogservice.models;

public class MovieInfo {

	String movieId;

	String name;

	public MovieInfo() {
	}
	
	public MovieInfo(String movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
