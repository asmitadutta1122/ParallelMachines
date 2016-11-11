package com.asmita.movieTicketTest;

import javax.xml.bind.annotation.XmlRootElement;

//@SuppressWarnings("restriction")
@XmlRootElement(name = "movie")
public class HttpMovie {
	
	public String movieName;
	
	public String theaterName;
	
	public HttpMovie(){}
	
	public HttpMovie(String movieName, String theaterName) {
		this.movieName = movieName;
		this.theaterName = theaterName;
	}
	
	

}
