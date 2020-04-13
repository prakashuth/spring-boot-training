package com.med.springboot.moviecatalogservice.models;

public class Rating {

	public Rating(String movieId, int rating) {
		this.movieId = movieId;
		this.rating = rating;
	}

	String movieId;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	int rating;

}
