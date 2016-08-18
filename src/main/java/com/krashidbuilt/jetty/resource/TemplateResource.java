package com.krashidbuilt.jetty.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.krashidbuilt.jetty.service.Settings;
import com.krashidbuilt.jetty.service.TemplateService;

@Path("/test")
public class TemplateResource {
	private static TemplateService helloWorldService = new TemplateService();

	@GET()
	@Path("hello")
	public String hello() {
		return helloWorldService.sayHello();
	}

	@GET()
	@Path("setting")
	public String setting() {
		return Settings.getStringSetting("test.setting");
	}
}
