package com.krashidbuilt.jetty.resource;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import org.junit.Test;

public class TemplateIntegrationTest {
	private static String HELLO_URL = "http://localhost:8080/api/hello";
	
	@Test
	public void testHello() throws Exception {
		Client client = Client.create();
		WebResource webResource = client.resource(HELLO_URL);
		String response = webResource.get(String.class);
		
		assertThat(response, is("Hello, World!"));
	}
}
