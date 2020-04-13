package com.med.springboot.movieinfoservice.models;

public class MovieInfo {

	String movieid, name;

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public MovieInfo(String name, String movieId) {
		this.movieid = movieId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
