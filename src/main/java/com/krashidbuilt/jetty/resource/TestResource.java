package com.krashidbuilt.jetty.resource;

import com.krashidbuilt.jetty.model.Test;
import com.krashidbuilt.jetty.service.Settings;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("/test")
public class TestResource {
	private static Logger LOGGER = LogManager.getLogger();

	@GET()
	@Path("one")
	@Produces("application/json")
	public Response getOne() {
		LOGGER.debug("Get single test object from resource controller.");
		return Response.ok().entity(new Test()).build();
	}

	@POST()
	@Path("one")
	@Produces("application/json")
	public Response createOne(Test test, @Context UriInfo uriInfo) {
		LOGGER.debug("Create single test object at resource controller.");
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		return Response.created(builder.build()).entity(test).build();
	}

	@GET()
	@Path("list")
	@Produces("application/json")
	public Response getList() {
		List<Test> tests = new ArrayList<>();
		for(int i = 0; i <= 10; i++){
			Test test = new Test();
			test.setId(1);
			test.setName("Test " + i);
			tests.add(test);
		}
		return Response.ok().entity(tests).build();
	}

	@POST()
	@Path("list")
	@Produces("application/json")
	public Response createList(List<Test> testList, @Context UriInfo uriInfo) {
		LOGGER.debug("Create multiple test objects at resource controller.");
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		for(Test test : testList){
			LOGGER.info("create " + test.toString());
		}
		return Response.created(builder.build()).entity(testList).build();
	}

	@PUT()
	@Path("list")
	@Produces("application/json")
	public Response updateList(List<Test> testList, @Context UriInfo uriInfo) {
		LOGGER.debug("Update multiple test objects at resource controller.");
		for(Test test : testList){
			LOGGER.info("update " + test.toString());
		}
		return Response.ok().entity(testList).build();
	}

	@GET()
	@Path("setting")
	@Produces("application/json")
	public Response setting() {
		return Response.ok(Settings.getStringSetting("test.setting")).build();
	}


}
