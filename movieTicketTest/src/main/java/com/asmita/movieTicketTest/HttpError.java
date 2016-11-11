package com.asmita.movieTicketTest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//@SuppressWarnings("restriction")
@XmlRootElement(name = "error")
public class HttpError {
	
	@XmlElement
	public int status;
	
	@XmlElement
	public String code;
	
	@XmlElement
	public String message;
	
	@XmlElement
	public String debug;

	public HttpError(){}
	
	public HttpError(int status, String code, String message, String debug) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.debug = debug;
	}
	
	

	@Override
	public String toString() {
		return "HttpError [status=" + status + ", code=" + code + ", message="
				+ message + ", debug=" + debug + "]";
	}

}
