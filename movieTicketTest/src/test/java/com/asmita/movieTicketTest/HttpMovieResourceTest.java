package com.asmita.movieTicketTest;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class HttpMovieResourceTest {
	
	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH_Theater = "/movieTicket/rest/movie/theater";
	private static final String URI_PATH = "/movieTicket/rest/movie";
	private static final String URI_PATH_SHOW = "/movieTicket/rest/show";
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	private WebTarget target1;
	private WebTarget target2;
	
	
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH_Theater);
		target1 = client.target(HTTP_HOST).path(URI_PATH);
		target2 = client.target(HTTP_HOST).path(URI_PATH_SHOW);
				
	}
	
	@Test
	public void testGetTheaterNoParamsXml(){	
		Builder resp =target.request();
		Builder resp1 = resp.accept(MediaType.APPLICATION_XML);
		Response response =	resp1.get();
		
		verifyMissing(response);
	}
	
	@Test
	public void testGetUsersNoParamsJson(){						
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).get();				
		verifyMissing(response);
	}
	
	@Test
	public void testGetMovieNoParamsXml(){
		Response response =	target1.request().accept(MediaType.APPLICATION_XML).get();	
		verifyMissing(response);
		
	}
	@Test
	public void testGetMovieNoParamsJson(){
		Response response =	target1.request().accept(MediaType.APPLICATION_JSON).get();	
		verifyMissing(response);
		
	}
	
	@Test
	public void testbookTicktNoParamJson(){					
		//HttpShow show = new HttpShow();		
		Response response =	target2.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{show:{}}", MediaType.APPLICATION_JSON));
		
		verifyInvalid(response);
	}
	
	@Test
	public void testbookTicktNoParamXml(){					
		Response response =	target2.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<show/>", MediaType.APPLICATION_XML));
		
		verifyInvalid(response);
	}
	
	@Test
	public void bookTicket(){
		HttpShow show = new HttpShow();
		show.movieName = "Twilight";
		show.theaterName="Regal_Jack";
		show.noOfSeat ="10";
		show.time ="1300";
		Response response =	target2.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(show, MediaType.APPLICATION_JSON));
		HttpShow createResponse = response.readEntity(HttpShow.class);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.noOfSeat, show.noOfSeat);
		Assert.assertTrue("seatSatus",true);
	}
	
	private void verifyMissing(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("MISSING_DATA", error.code);
		Assert.assertEquals("no search parameter provided", error.message);
		Assert.assertEquals("", error.debug);
	}
	
	private void verifyInvalid(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("INVALID_FIELD", error.code);
		Assert.assertEquals("", error.debug);		
	}
	

}
