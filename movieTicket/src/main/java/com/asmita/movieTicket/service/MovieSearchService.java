package com.asmita.movieTicket.service;

import java.util.List;

import com.asmita.movieTicket.entity.ShowInfo;

public interface MovieSearchService {
	List<String> getThreater( String movie);
	List<String> getMovie(String threaterName);
	public List<ShowInfo> getShowDetail(String movie);
	List<String> getMovies();
	List<String> getTheaterList();
}
