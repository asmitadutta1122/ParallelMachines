package com.asmita.movieTicketTest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "show")
public class HttpShow {
	
	@XmlElement
	public String movieName;
	
	@XmlElement
	public String theaterName;

	@XmlElement
	public String noOfSeat;
	
	@XmlElement
	public String time;
	
	public HttpShow(){}

	public HttpShow(String movieName, String theaterName, String time, String noOfSeat) {
		super();
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.time = time;
		this.noOfSeat = noOfSeat;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpShow other = (HttpShow) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		if (noOfSeat == null) {
			if (other.noOfSeat != null)
				return false;
		} else if (!noOfSeat.equals(other.noOfSeat))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;

		return true;
	}
	
	

}
